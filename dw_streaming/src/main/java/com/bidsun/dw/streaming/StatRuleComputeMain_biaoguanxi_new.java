package com.bidsun.dw.streaming;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.bidsun.dw.compute.stateagg.*;
import com.bidsun.dw.pojo.*;
import com.bidsun.dw.tools.*;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.streaming.api.datastream.AsyncDataStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.util.serialization.JSONKeyValueDeserializationSchema;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Niuxy
 * @className StatRuleComputeMain
 * @description streaming main function
 * @date 2021/5/21 11:32
 */
public class StatRuleComputeMain_biaoguanxi_new implements StatRuleComputeConstants {
    private static Logger logger = LoggerFactory.getLogger(StatRuleComputeMain_biaoguanxi_new.class);


    public static void main(String[] args) throws Exception {
        ThreadContext.put("module", "mainfunction");

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();


        final ParameterTool params = ParameterTool.fromArgs(args);
        //???????????????
        //Map inputParaConf = YamlConfigUtils.findAndReadConfigFile(params.getRequired(INPUTPARAM_CONFIG_PATH), false);
        Map inputParaConf = YamlConfigUtils.findAndReadConfigFile("./conf/ComputeRule1001.yaml", true);

        //???????????????
        //String scenarioId = params.getRequired(INPUTPARAM_SCENARIOID);
        String scenarioId = "0001";

        // 1.set parallelism of Run Env
        int hosts = ((Number) inputParaConf.get(YamlConfigUtils.globalHostNums)).intValue();
        int cores = ((Number) inputParaConf.get(YamlConfigUtils.globalHostCpuNums)).intValue();
        env.setParallelism(hosts * cores);

        // 1.1 check
        // checkpoint is valid or not
        int checkPointInterval = YamlConfigUtils.getCheckpointInterval(inputParaConf);
        if (checkPointInterval > 1000) {
            env.enableCheckpointing(checkPointInterval);
            boolean isEnableExactlyOnce = YamlConfigUtils.getCheckpointEnableExactlyOnce(inputParaConf);
            int checkpointTimeOut = YamlConfigUtils.getCheckpointTimeOut(inputParaConf);
            int concurrentCheckpointThreadCnt = YamlConfigUtils.getCheckpointConcurrentThreadCnt(inputParaConf);
            int minCheckPointPauseMs = YamlConfigUtils.getCheckpointMinPauseBetweenMS(inputParaConf);

            env.getCheckpointConfig().setCheckpointTimeout(checkpointTimeOut);
            env.getCheckpointConfig().setMaxConcurrentCheckpoints(concurrentCheckpointThreadCnt);
            env.getCheckpointConfig().setMinPauseBetweenCheckpoints(minCheckPointPauseMs);

            /*if (isEnableExactlyOnce) {
                env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
            } else {
                env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.AT_LEAST_ONCE);
            }
            logger.info("RuleCompute CheckPoint:[timeOut:" + checkpointTimeOut
                    + ", threadCnt:" + concurrentCheckpointThreadCnt
                    + ", interval:" + checkPointInterval
                    + ", isEnableExactlyOnce:" + isEnableExactlyOnce
                    + ", checkPointMinMS:" + minCheckPointPauseMs
                    + "]")*/
            ;
        }

        ParameterTool envParameter = ParameterTool.fromMap(
                YamlConfigUtils.getStatRuleInputConfig(inputParaConf, scenarioId));
        env.getConfig().setGlobalJobParameters(envParameter);
        System.out.println("------>" + envParameter.toMap().toString());
        String kafkaServerAddress = envParameter.getRequired(YamlConfigUtils.kafkaServerAddress);
        String kafkaRecordTopic = envParameter.getRequired(YamlConfigUtils.kafkaRuleStatInputTopic);
        String kafkaAutoOffsetResetConfig = envParameter.getRequired(YamlConfigUtils.kafkaAutoOffsetResetConfig);
        System.out.println("kafkaAutoOffsetResetConfig---" + kafkaAutoOffsetResetConfig);
        String kafkaOutputTopic = envParameter.getRequired(YamlConfigUtils.kafkaRuleStatOutputTopic);
        if (logger.isInfoEnabled()) {
            logger.info("------Input parameter map: {}", inputParaConf);
            logger.info("------scenarioId is: {}", scenarioId);
            logger.info("Input topic name is: {}", kafkaRecordTopic);
        }


        //SimpleStringSchema???????????????kafka?????????JSONKeyValueDeserializationSchema????????????????????????key,value???metadata:topic,partition???offset?????????
        String kafkaRuleStatInputTopic = inputParaConf.get(YamlConfigUtils.kafkaRuleStatInputTopic).toString();

        FlinkKafkaConsumer010<ObjectNode> kafkaConsumer011 = new FlinkKafkaConsumer010<ObjectNode>(kafkaRuleStatInputTopic,
                new JSONKeyValueDeserializationSchema(true), envParameter.getProperties());

        //??????kafka?????????
        DataStreamSource<ObjectNode> streamSource = env.addSource(kafkaConsumer011);

        //??????????????????
        SingleOutputStreamOperator<EbidsunEvent> ebidsunEventStream = streamSource.flatMap(new BidsunEventFunction());



        //??????????????????????????????
        // ??????Side Output??????
        final OutputTag<EbidsunEvent> gcjsZhongBiaoJieGuoGongGao = new OutputTag<EbidsunEvent>("zhongBiaoJieGuoGongGao") {
        };
        final OutputTag<EbidsunEvent> gcjsKaiBiaoJiLu = new OutputTag<EbidsunEvent>("gcjsKaiBiaoJiLu") {
        };
        final OutputTag<EbidsunEvent> gcjsZhaoBiaoGongGao = new OutputTag<EbidsunEvent>("gcjsZhaoBiaoGongGao") {
        };
        final OutputTag<EbidsunEvent> gcjsPingBiaoBaoGao = new OutputTag<EbidsunEvent>("gcjsPingBiaoBaoGao") {
        };
        final OutputTag<EbidsunEvent> gcjsTouBiaoBaoZhengJinJiaoNa = new OutputTag<EbidsunEvent>("gcjsPingBiaoBaoGao") {
        };
        final OutputTag<EbidsunEvent> gcjsZhaoBiaoYiChangQingKuangBaoGao = new OutputTag<EbidsunEvent>("gcjsZhaoBiaoYiChangQingKuangBaoGao") {
        };
        final OutputTag<EbidsunEvent> tradeSystemRecord = new OutputTag<EbidsunEvent>("tradeSystemRecord") {
        };
        final OutputTag<EbidsunEvent> gcjsBiaoDuan = new OutputTag<EbidsunEvent>("gcjsBiaoDuan") {
        };
        final OutputTag<EbidsunEvent> gcjsZhaoBiaoWenJian = new OutputTag<EbidsunEvent>("gcjsZhaoBiaoWenJian") {
        };
        final OutputTag<EbidsunEvent> bindData = new OutputTag<EbidsunEvent>("bindData") {
        };
        final OutputTag<EbidsunEvent> localTransactionInfo = new OutputTag<EbidsunEvent>("localTransactionInfo") {
        };
        final OutputTag<EbidsunEvent> subscribehistory = new OutputTag<EbidsunEvent>("subscribehistory") {
        };
        final OutputTag<EbidsunEvent> subscribeFavorites = new OutputTag<EbidsunEvent>("subscribeFavorites") {
        };
        final OutputTag<EbidsunEvent> subscribe = new OutputTag<EbidsunEvent>("subscribe") {
        };
        final OutputTag<EbidsunEvent> gcjsZhaoBiaoXiangMu = new OutputTag<EbidsunEvent>("gcjsZhaoBiaoXiangMu") {
        };

        final OutputTag<EbidsunEvent> zfcgChengJiaoJieGuoGOngGao = new OutputTag<EbidsunEvent>("zfcgChengJiaoJieGuoGOngGao") {
        };
        final OutputTag<EbidsunEvent> zfcgZhongBiaoHouXuanRenGongShi = new OutputTag<EbidsunEvent>("zfcgZhongBiaoHouXuanRenGongShi") {
        };
        final OutputTag<EbidsunEvent> gcjsCaiGouGongGao = new OutputTag<EbidsunEvent>("gcjsCaiGouGongGao") {
        };
        final OutputTag<EbidsunEvent> gcjsJiaoYiZhengMingShu = new OutputTag<EbidsunEvent>("gcjsJiaoYiZhengMingShu") {
        };
        final OutputTag<EbidsunEvent> gcjsTouBiaoRen = new OutputTag<EbidsunEvent>("gcjsTouBiaoRen") {
        };
        final OutputTag<EbidsunEvent> gcjsPingBiaoZhuanJia = new OutputTag<EbidsunEvent>("gcjsPingBiaoZhuanJia") {
        };
        //???????????????
        final OutputTag<EbidsunEvent> gcjsZhaoBiaoHouXuanRenKuangBaoGao = new OutputTag<EbidsunEvent>("gcjsZhaoBiaoHouXuanRenKuangBaoGao") {
        };
        final OutputTag<EbidsunEvent> gcjsZhaoBiaoHouXuanRenGongShi = new OutputTag<EbidsunEvent>("gcjsHouXuanRenGongShi") {
        };
        final OutputTag<EbidsunEvent> gcjsHeTongTag = new OutputTag<EbidsunEvent>("gcjsHeTong") {
        };

        SingleOutputStreamOperator<EbidsunEvent> sideOutputData = ebidsunEventStream.process(new ProcessFunction<EbidsunEvent, EbidsunEvent>() {
            @Override
            public void processElement(EbidsunEvent ebidsunEvent, Context ctx, Collector<EbidsunEvent> out) throws Exception {
                String tableName = ebidsunEvent.getTableName();
                switch (tableName) {
                    case "catalog_main_data_4bd1f410d2f4737df2e8da9c885a2e3e":
                        ctx.output(gcjsZhongBiaoJieGuoGongGao, ebidsunEvent);
                        break;
                    case "catalog_main_data_24ff9fe0380450915ca9f365d248909e":
                        ctx.output(gcjsKaiBiaoJiLu, ebidsunEvent);
                        break;
                    case "catalog_main_data_da7351dc745bd74a0a57c0fc7f091cbe":
                        ctx.output(gcjsZhaoBiaoGongGao, ebidsunEvent);
                        break;
                    case "catalog_main_data_8bc0b9758d26c0f14aa07729e81b5ea6":
                        ctx.output(gcjsPingBiaoBaoGao, ebidsunEvent);
                        break;
                    case "catalog_main_data_6d86c2ff870a5e54ebbf880c9573573b":
                        ctx.output(gcjsTouBiaoBaoZhengJinJiaoNa, ebidsunEvent);
                        break;
                    case "catalog_main_data_d9b876b3965d2219253cb331f730e667":
                        ctx.output(gcjsZhaoBiaoYiChangQingKuangBaoGao, ebidsunEvent);
                        break;
                    case "trade_system_record":
                        ctx.output(tradeSystemRecord, ebidsunEvent);
                        break;
                    case "catalog_main_data_151d806e9846ed734c1beb8278905ff8":
                        ctx.output(gcjsBiaoDuan, ebidsunEvent);
                        break;
                    case "catalog_main_data_943fa6eb110cb38a346ff2e4df12e4af":
                        ctx.output(gcjsZhaoBiaoWenJian, ebidsunEvent);
                        break;
                    case "bind_data":
                        ctx.output(bindData, ebidsunEvent);
                        break;
                    case "local_transaction_info":
                        ctx.output(localTransactionInfo, ebidsunEvent);
                        break;
                    case "subscribe_history":
                        ctx.output(subscribehistory, ebidsunEvent);
                        break;
                    case "subscribe_favorites":
                        ctx.output(subscribeFavorites, ebidsunEvent);
                        break;
                    case "subscribe":
                        ctx.output(subscribe, ebidsunEvent);
                        break;
                    case "catalog_main_data_342d696b581170aa44ecf4f00bca8a6d":
                        ctx.output(gcjsZhaoBiaoXiangMu, ebidsunEvent);
                        break;
                    case "catalog_main_data_7b63980dc3c016c1f076f5daedf1d0fb":
                        ctx.output(zfcgChengJiaoJieGuoGOngGao, ebidsunEvent);
                        break;
                    case "catalog_main_data_cd7630c02e0aa53c7891a54b1be65c7b":
                        ctx.output(zfcgZhongBiaoHouXuanRenGongShi, ebidsunEvent);
                        break;
                    case "catalog_main_data_e9ddcd7b9b894717b8dfa1d9ce6cbfdb":
                        ctx.output(gcjsCaiGouGongGao, ebidsunEvent);
                        break;
                    case "catalog_main_data_497556c0be8f878b68f414b71dc9b70b":
                        ctx.output(gcjsJiaoYiZhengMingShu, ebidsunEvent);
                        break;
                    case "catalog_main_data_706555aff633d53cee1a7ced81f6c5c3":
                        ctx.output(gcjsTouBiaoRen, ebidsunEvent);
                        break;
                    //????????????(????????????)
                    case "catalog_main_data_beb316e8386c710394f1cd06c3cdff9a":
                        ctx.output(gcjsPingBiaoZhuanJia, ebidsunEvent);
                        break;
                    //???????????????
                    case "catalog_main_data_6a31714e779dd05a33a9a8aa7e81e75d":
                        ctx.output(gcjsZhaoBiaoHouXuanRenKuangBaoGao, ebidsunEvent);
                        break;
                    //??????
                    case "catalog_main_data_8336408b75bedd47565e338c8afb5281":
                        ctx.output(gcjsHeTongTag, ebidsunEvent);
                        break;
                    default:
                        out.collect(ebidsunEvent);
                }
            }
        });

        DataStream<EbidsunEvent> gcjsZhongBiaoJieGuoGongGaoTagStream = sideOutputData.getSideOutput(gcjsZhongBiaoJieGuoGongGao);
        DataStream<EbidsunEvent> gcjsKaiBiaoJiLuTagStream = sideOutputData.getSideOutput(gcjsKaiBiaoJiLu);
        DataStream<EbidsunEvent> gcjsZhaoBiaoGongGaoTagStream = sideOutputData.getSideOutput(gcjsZhaoBiaoGongGao);
        DataStream<EbidsunEvent> gcjsPingBiaoBaoGaoTagStream = sideOutputData.getSideOutput(gcjsPingBiaoBaoGao);
        DataStream<EbidsunEvent> gcjsTouBiaoBaoZhengJinJiaoNaTagStream = sideOutputData.getSideOutput(gcjsTouBiaoBaoZhengJinJiaoNa);
        DataStream<EbidsunEvent> gcjsZhaoBiaoYiChangQingKuangBaoGaoTagStream = sideOutputData.getSideOutput(gcjsZhaoBiaoYiChangQingKuangBaoGao);
        DataStream<EbidsunEvent> tradeSystemRecordTagStream = sideOutputData.getSideOutput(tradeSystemRecord);
        DataStream<EbidsunEvent> gcjsBiaoDuanTagStream = sideOutputData.getSideOutput(gcjsBiaoDuan);
        DataStream<EbidsunEvent> gcjsZhaoBiaoWenJianTagStream = sideOutputData.getSideOutput(gcjsZhaoBiaoWenJian);
        DataStream<EbidsunEvent> bindDataTagStream = sideOutputData.getSideOutput(bindData);
        DataStream<EbidsunEvent> localTransactionInfoTagStream = sideOutputData.getSideOutput(localTransactionInfo);
        DataStream<EbidsunEvent> subscribehistoryTagStream = sideOutputData.getSideOutput(subscribehistory);
        DataStream<EbidsunEvent> subscribeFavoritesTagStream = sideOutputData.getSideOutput(subscribeFavorites);
        DataStream<EbidsunEvent> subscribeTagStream = sideOutputData.getSideOutput(subscribe);
        DataStream<EbidsunEvent> gcjsZhaoBiaoXiangMuTagStream = sideOutputData.getSideOutput(gcjsZhaoBiaoXiangMu);
        DataStream<EbidsunEvent> zfcgChengJiaoJieGuoGOngGaoTagStream = sideOutputData.getSideOutput(zfcgChengJiaoJieGuoGOngGao);
        DataStream<EbidsunEvent> zfcgZhongBiaoHouXuanRenGongShiTagStream = sideOutputData.getSideOutput(zfcgZhongBiaoHouXuanRenGongShi);
        DataStream<EbidsunEvent> gcjsCaiGouGongGaoTagStream = sideOutputData.getSideOutput(gcjsCaiGouGongGao);
        DataStream<EbidsunEvent> gcjsJiaoYiZhengMingShuTagStream = sideOutputData.getSideOutput(gcjsJiaoYiZhengMingShu);
        //???????????????
        DataStream<EbidsunEvent> gcjsZhongBiaoHouXuanRenTagStream = sideOutputData.getSideOutput(gcjsZhaoBiaoHouXuanRenKuangBaoGao);

        //??????????????????
        DataStream<EbidsunEvent> gcjsTouBiaoRenTagStream = sideOutputData.getSideOutput(gcjsTouBiaoRen);
        //?????????????????????
        DataStream<EbidsunEvent> gcjsZhuanJiaQianDaoTagStream = sideOutputData.getSideOutput(gcjsPingBiaoZhuanJia);
        //?????????????????????
        DataStream<EbidsunEvent> gcjsZhongBiaoHouXuanRenGongShiTagStream = sideOutputData.getSideOutput(gcjsZhaoBiaoHouXuanRenKuangBaoGao);
        //??????
        DataStream<EbidsunEvent> gcjsHeTongTagStream = sideOutputData.getSideOutput(gcjsHeTongTag);

        //??????(???)????????????<??????????????????
        SingleOutputStreamOperator<GCJSZhaoBiaoGongGao> gcjsZhaoBiaoGongGaoStream = gcjsZhaoBiaoGongGaoTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSZhaoBiaoGongGao>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSZhaoBiaoGongGao> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    GCJSZhaoBiaoGongGao GCJSZhaoBiaoGongGao = JSON.parseObject(eventBody, GCJSZhaoBiaoGongGao.class);
                    out.collect(GCJSZhaoBiaoGongGao);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

        //??????????????????????????????gcjsTouBiaoRenTagStream
        SingleOutputStreamOperator<GCJSTouBiaoRenMingDan> touBiaoRenSingleOutputStream = gcjsTouBiaoRenTagStream.map(new MapFunction<EbidsunEvent, GCJSTouBiaoRenMingDan>() {
            @Override
            public GCJSTouBiaoRenMingDan map(EbidsunEvent ebidsunEvent) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                GCJSTouBiaoRenMingDan touBiaoRenMingDan = null;
                try {
                    touBiaoRenMingDan = JSON.parseObject(eventBody, GCJSTouBiaoRenMingDan.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return touBiaoRenMingDan;
            }
        });

        //?????????????????????3?????????????????????????????????????????????????????????
        //?????????:(1,????????????)(2,???????????????)
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> touBiaoRenShuLiangAsyncStream = AsyncDataStream.orderedWait(
                touBiaoRenSingleOutputStream,                       //?????????????????????
                new TouBiaoRenShuLiangForMysqlUtils(30),   //???????????????????????????????????????
                3000,                                        //????????????
                TimeUnit.MILLISECONDS,                               //????????????
                20                                           //??????????????????????????????
        );
        //????????????????????????????????????????????????
        //?????????:(1,??????)(2,???????????????)
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> touBiaoRenTouBiaoBaoJiaAsyncStream = AsyncDataStream.orderedWait(
                touBiaoRenSingleOutputStream,                              //?????????????????????
                new TouBiaoRenTouBiaoBaoJiaForMysqlUtils(30),   //???????????????????????????????????????
                3000,                             //????????????
                TimeUnit.MILLISECONDS,             //????????????
                20                          //??????????????????????????????
        );

        //??????????????????????????????????????????/???????????????????????????????????????????????????(????????????)
        //?????????:(1,????????????)(2,???????????????)
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> touBiaoRenWenJianDiJiaoShiJianAsyncStream = AsyncDataStream.orderedWait(
                touBiaoRenSingleOutputStream,
                new GongGaoXinXiAsyncFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );

        //???????????????????????????
        SingleOutputStreamOperator<GCJSZhuanJiaQianDao> zhuanJiaQianDaoOutputStream = gcjsZhuanJiaQianDaoTagStream.map(new MapFunction<EbidsunEvent, GCJSZhuanJiaQianDao>() {
            @Override
            public GCJSZhuanJiaQianDao map(EbidsunEvent ebidsunEvent) throws Exception {
                String zhuanJiaQianDao = ebidsunEvent.getEventBody();
                GCJSZhuanJiaQianDao zhuanjia = null;
                try {
                    zhuanjia = JSON.parseObject(String.valueOf(zhuanJiaQianDao), GCJSZhuanJiaQianDao.class);
                    System.out.println(zhuanjia);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return zhuanjia;
            }
        });

        //????????????????????????????????????\????????????????????????1???????????????
        //?????????:(1,????????????,????????????)(2,????????????,????????????)(3,????????????--????????????)
        SingleOutputStreamOperator<Tuple3<ReportField, ReportField, ReportField>> zhuanJiaShuLiangAsyncStream = AsyncDataStream.orderedWait(
                zhuanJiaQianDaoOutputStream,
                new ZhuanJiaQianDaoAsynFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );

        //??????????????????????????????
        SingleOutputStreamOperator<GCJSZhongBiaoHouXuanRen> gcjsZhongBiaoHouXuanRen = gcjsZhongBiaoHouXuanRenTagStream.map(new MapFunction<EbidsunEvent, GCJSZhongBiaoHouXuanRen>() {
            @Override
            public GCJSZhongBiaoHouXuanRen map(EbidsunEvent ebidsunEvent) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                GCJSZhongBiaoHouXuanRen zhongBiaoHouXuanRen = null;
                try {
                    zhongBiaoHouXuanRen = JSON.parseObject(eventBody, GCJSZhongBiaoHouXuanRen.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return zhongBiaoHouXuanRen;
            }
        });
        //????????????????????????
        //?????????:(1,????????????)(2,???????????????)
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> pbbgHouXuanRenAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhongBiaoHouXuanRen,
                new ZhongBiaoHouXuanRenAsynFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );

        //????????????????????????????????????
        SingleOutputStreamOperator<GCJSZhongBiaoHouXuanRenGongShi> gcjsZhongBiaoHouXuanRenGongShi = gcjsZhongBiaoHouXuanRenGongShiTagStream.map(new MapFunction<EbidsunEvent, GCJSZhongBiaoHouXuanRenGongShi>() {
            @Override
            public GCJSZhongBiaoHouXuanRenGongShi map(EbidsunEvent ebidsunEvent) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                GCJSZhongBiaoHouXuanRenGongShi houXuanRenGongShi = null;
                try {
                    houXuanRenGongShi = JSON.parseObject(eventBody, GCJSZhongBiaoHouXuanRenGongShi.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return houXuanRenGongShi;
            }
        });
        //????????????????????????
        //?????????:(1,????????????)(2,?????????????????????)
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> pbbgHouXuanRenGongShiAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhongBiaoHouXuanRenGongShi,
                new ZhongBiaoHouXuanRenGongShiAsynFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );

        //?????????????????????????????????
        SingleOutputStreamOperator<GCJSZhongBiaoJieGuoGongGao> gcjsGCJSZhongBiaoJieGuoGongGao = gcjsZhongBiaoHouXuanRenGongShiTagStream.map(new MapFunction<EbidsunEvent, GCJSZhongBiaoJieGuoGongGao>() {
            @Override
            public GCJSZhongBiaoJieGuoGongGao map(EbidsunEvent ebidsunEvent) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                GCJSZhongBiaoJieGuoGongGao zhongBiaoJieGuoGongGao = null;
                try {
                    zhongBiaoJieGuoGongGao = JSON.parseObject(eventBody, GCJSZhongBiaoJieGuoGongGao.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return zhongBiaoJieGuoGongGao;
            }
        });

        //????????????????????????
        //?????????:(1,????????????)(2,??????????????????)
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> pbbgZhongBiaoJieGuoAsyncStream = AsyncDataStream.orderedWait(
                gcjsGCJSZhongBiaoJieGuoGongGao,
                new ZhongBiaoJieGuoGongShiAsynFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );
        //?????????????????????
        SingleOutputStreamOperator<GCJSHeTong> gcjsHeTong = gcjsHeTongTagStream.map(new MapFunction<EbidsunEvent, GCJSHeTong>() {
            @Override
            public GCJSHeTong map(EbidsunEvent ebidsunEvent) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                GCJSHeTong heTong = null;
                try {
                    heTong = JSON.parseObject(eventBody, GCJSHeTong.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return heTong;
            }
        });
        //????????????????????????
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> pbbgHouHeTongAsyncStream = AsyncDataStream.orderedWait(
                gcjsHeTong,
                new HeTongAsynFunctionForMysqlUtils(30),
                3000,        //?????????:(1,????????????)(2,??????)
                TimeUnit.MILLISECONDS,
                20
        );

        //???????????????????????????????????????????????????
        //?????????:(1,??????????????????)(2,?????????????????????)
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> ZhongBiaoHouXuanRenMingChengAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhongBiaoHouXuanRen,
                new ZhongBiaoHouXuanAsyncFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );

        //?????????????????????????????????????????????(??????)
        //?????????:(1,??????)(2,?????????????????????)
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> touBiaoJiaGeAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhongBiaoHouXuanRen,
                new ZhongBiaoHouXuanTBJGAsyncFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );

        //??????????????????
        SingleOutputStreamOperator<GCJSZhongBiaoJieGuoGongGao> gcjsZhaoBiaoJieGuoGongGao = gcjsZhongBiaoJieGuoGongGaoTagStream.map(new MapFunction<EbidsunEvent, GCJSZhongBiaoJieGuoGongGao>() {
            @Override
            public GCJSZhongBiaoJieGuoGongGao map(EbidsunEvent ebidsunEvent) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                GCJSZhongBiaoJieGuoGongGao zhaoBiaoJieGuoGongGao = null;
                try {
                    zhaoBiaoJieGuoGongGao = JSON.parseObject(eventBody, GCJSZhongBiaoJieGuoGongGao.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return zhaoBiaoJieGuoGongGao;
            }
        });

        //??????????????????????????????????????????????????????
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> zhongBiaoRenMingChengAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhaoBiaoJieGuoGongGao,
                new ZhongBiaoJieGuoZBRMCAsyncFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );

        //?????????????????????????????????????????????
        SingleOutputStreamOperator<Tuple2<ReportField, ReportField>> zhaoBiaoJinJieGuoGongShiZhongBiaoJieGuoAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhaoBiaoJieGuoGongGao,
                new ZhongBiaoJieGuoZBJEAsyncFunctionForMysqlUtils(30),
                3000,
                TimeUnit.MILLISECONDS,
                20
        );
        ZhongBiaoHouXuanRenMingChengAsyncStream.print();

        env.execute("StatRuleCompute_" + scenarioId);
    }
}