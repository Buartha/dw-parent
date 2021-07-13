package com.bidsun.dw.streaming;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.bidsun.dw.compute.stateagg.*;
import com.bidsun.dw.pojo.*;
import com.bidsun.dw.tools.*;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
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
public class StatRuleComputeMain_biaoguanxi implements StatRuleComputeConstants {
    private static Logger logger = LoggerFactory.getLogger(StatRuleComputeMain_biaoguanxi.class);


    public static void main(String[] args) throws Exception {
        ThreadContext.put("module", "mainfunction");

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();


        final ParameterTool params = ParameterTool.fromArgs(args);
        //测试备注掉
        //Map inputParaConf = YamlConfigUtils.findAndReadConfigFile(params.getRequired(INPUTPARAM_CONFIG_PATH), false);
        Map inputParaConf = YamlConfigUtils.findAndReadConfigFile("./conf/ComputeRule1001.yaml", true);

        //测试备注掉
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


        //SimpleStringSchema可以获取到kafka消息，JSONKeyValueDeserializationSchema可以获取都消息的key,value，metadata:topic,partition，offset等信息
        String kafkaRuleStatInputTopic = inputParaConf.get(YamlConfigUtils.kafkaRuleStatInputTopic).toString();

        FlinkKafkaConsumer010<ObjectNode> kafkaConsumer011 = new FlinkKafkaConsumer010<ObjectNode>(kafkaRuleStatInputTopic,
                new JSONKeyValueDeserializationSchema(true), envParameter.getProperties());

        //加入kafka数据源
        DataStreamSource<ObjectNode> streamSource = env.addSource(kafkaConsumer011);

        //数据处理部分
        SingleOutputStreamOperator<EbidsunEvent> ebidsunEventStream = streamSource.flatMap(new BidsunEventFunction());
        ebidsunEventStream.print();


        //根据数据类型分流部分
        // 使用Side Output分流
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
        final OutputTag<EbidsunEvent> gcjsZhongBiaoGongGao = new OutputTag<EbidsunEvent>("gcjsZhongBiaoGongGao") {
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
                        ctx.output(gcjsZhongBiaoGongGao, ebidsunEvent);
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
        DataStream<EbidsunEvent> gcjsZhongBiaoGongGaoTagStream = sideOutputData.getSideOutput(gcjsZhongBiaoGongGao);
        /*
         * 开标记录状态计算
         * */
        //统计异常数
       SingleOutputStreamOperator<GCJSZhaoBiaoYiChangQingKuangBaoGao> zhaoBiaoYiChangQingKuangBaoGaoStream = gcjsZhaoBiaoYiChangQingKuangBaoGaoTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSZhaoBiaoYiChangQingKuangBaoGao>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSZhaoBiaoYiChangQingKuangBaoGao> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    GCJSZhaoBiaoYiChangQingKuangBaoGao zhaoBiaoYiChangQingKuangBaoGao = JSON.parseObject(eventBody, GCJSZhaoBiaoYiChangQingKuangBaoGao.class);
                    out.collect(zhaoBiaoYiChangQingKuangBaoGao);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        DataStream<AdsGzhTradeCountDaily> zhaoBiaoYiChangQingKuangBaoGaoCountStream = zhaoBiaoYiChangQingKuangBaoGaoStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSZhaoBiaoYiChangQingKuangBaoGao, String>() {
                    @Override
                    public String getKey(GCJSZhaoBiaoYiChangQingKuangBaoGao value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSZhaoBiaoYiChangQingKuangBaoGaoCountAggregate(), new AdsGzhTradeCountDailyExceptioncountWindowFunction());
         //zhaoBiaoYiChangQingKuangBaoGaoCountStream.print();


        //统计开标数
        SingleOutputStreamOperator<GCJSKaiBiaoJiLu> gcjsKaiBiaoJiLuStream = gcjsKaiBiaoJiLuTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSKaiBiaoJiLu>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSKaiBiaoJiLu> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    GCJSKaiBiaoJiLu kaiBiaoJiLu = JSON.parseObject(eventBody, GCJSKaiBiaoJiLu.class);
                    out.collect(kaiBiaoJiLu);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        DataStream<AdsGzhTradeCountDaily> kaiBiaoJiLuCountStream = gcjsKaiBiaoJiLuStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSKaiBiaoJiLu, String>() {
                    @Override
                    public String getKey(GCJSKaiBiaoJiLu value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSKaiBiaoJiLuCountAggregate(), new AdsGzhTradeCountDailycountWindowFunction());
        //kaiBiaoJiLuCountStream.print();


        //统计评标数
        SingleOutputStreamOperator<GCJSPingBiaoBaoGao> gcjsPingBiaoBaoGaoStream = gcjsPingBiaoBaoGaoTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSPingBiaoBaoGao>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSPingBiaoBaoGao> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    GCJSPingBiaoBaoGao GCJSPingBiaoBaoGao = JSON.parseObject(eventBody, GCJSPingBiaoBaoGao.class);
                    out.collect(GCJSPingBiaoBaoGao);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        DataStream<AdsGzhTradeCountDaily> PingBiaoBaoGaoCountStream = gcjsPingBiaoBaoGaoStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSPingBiaoBaoGao, String>() {
                    @Override
                    public String getKey(GCJSPingBiaoBaoGao value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSPingBiaoBaoGaoCountAggregate(), new AdsGzhTradeCountDailyendTimecountWindowFunction());
   //PingBiaoBaoGaoCountStream.print();


        //统计投标数
        SingleOutputStreamOperator<GCJSTouBiaoBaoZhengJinJiaoNa> gcjsTouBiaoBaoZhengJinJiaoNaStream = gcjsTouBiaoBaoZhengJinJiaoNaTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSTouBiaoBaoZhengJinJiaoNa>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSTouBiaoBaoZhengJinJiaoNa> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    GCJSTouBiaoBaoZhengJinJiaoNa GCJSTouBiaoBaoZhengJinJiaoNa = JSON.parseObject(eventBody, GCJSTouBiaoBaoZhengJinJiaoNa.class);
                    out.collect(GCJSTouBiaoBaoZhengJinJiaoNa);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        DataStream<AdsGzhTradeCountDaily> gcjsTouBiaoBaoZhengJinJiaoNaCountStream = gcjsTouBiaoBaoZhengJinJiaoNaStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSTouBiaoBaoZhengJinJiaoNa, String>() {
                    @Override
                    public String getKey(GCJSTouBiaoBaoZhengJinJiaoNa value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSTouBiaoBaoZhengJinJiaoNaCountAggregate(), new AdsGzhTradeCountDailyTendercountWindowFunction());
        //gcjsTouBiaoBaoZhengJinJiaoNaCountStream.print();

        /*
         * CA互认统计
         * */

          //账户互通数
        SingleOutputStreamOperator<BindData> bindDataStream = bindDataTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, BindData>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<BindData> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    BindData bindData = JSON.parseObject(eventBody, BindData.class);
                    out.collect(bindData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        DataStream<AdsGzhCaCountDetail> bindDataCountStream = bindDataStream.filter(x -> x.getPlatform_Id() != null)
                .keyBy(new KeySelector<BindData, String>() {
                    @Override
                    public String getKey(BindData value) throws Exception {
                        return value.getPlatform_Id();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new BindDataCountAggregate(), new AdsGzhCaCountDetailacCountInterchangecountWindowFunction());
       // bindDataCountStream.print();

        //移动CA使用次数,扫码登录次数,加解密次数
        SingleOutputStreamOperator<TradeSystemRecord> tradeSystemRecordStream = tradeSystemRecordTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, TradeSystemRecord>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<TradeSystemRecord> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    TradeSystemRecord tradeSystemRecord = JSON.parseObject(eventBody, TradeSystemRecord.class);
                    out.collect(tradeSystemRecord);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        DataStream<AdsGzhCaCountDetail> tradeSystemRecordCountStream = tradeSystemRecordStream.filter(x -> x.getPlatform_id() != null)
                .keyBy(new KeySelector<TradeSystemRecord, String>() {
                    @Override
                    public String getKey(TradeSystemRecord value) throws Exception {
                        return value.getPlatform_id();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new TradeSystemRecordCountAggregate(), new AdsGzhCaCountDetailUsageountWindowFunction());
        //tradeSystemRecordCountStream.print();

        /*
         * 链上保函统计
         * */
        //电子保函开函份数,当日入驻金融机构数
        DataStream<AdsGzhChainElgDaily> PingBiaoBaoGaoCountStream_2 = gcjsTouBiaoBaoZhengJinJiaoNaStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSTouBiaoBaoZhengJinJiaoNa, String>() {
                    @Override
                    public String getKey(GCJSTouBiaoBaoZhengJinJiaoNa value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSTouBiaoBaoZhengJinJiaoNaCountAggregate_2(), new AdsGzhChainElgDailyElgOpeningCountWindowFunction());
        //PingBiaoBaoGaoCountStream_2.print();


        //释放企业资金压力
        SingleOutputStreamOperator<GCJSZhaoBiaoWenJian> gcjsZhaoBiaoWenJianStream = gcjsZhaoBiaoWenJianTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSZhaoBiaoWenJian>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSZhaoBiaoWenJian> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                GCJSZhaoBiaoWenJian gCJSZhaoBiaoWenJian = new GCJSZhaoBiaoWenJian();
                Double marginAmount = 0.00;
                try {
                    JSONArray marginInfo = JSONArray.parseArray(JSON.parseObject(eventBody).get("marginInfo").toString());
                    for (Object a : marginInfo) {
                        marginAmount = marginAmount + Double.parseDouble(JSON.parseObject(a.toString()).get("marginAmount").toString());
                    }
                    eventBody = eventBody.substring(0, eventBody.length() - 1) + ",\"marginAmount\": " + new BigDecimal(marginAmount) + "}";
                    gCJSZhaoBiaoWenJian = JSON.parseObject(eventBody, GCJSZhaoBiaoWenJian.class);
                    out.collect(gCJSZhaoBiaoWenJian);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        SingleOutputStreamOperator<GCJSZhaoBiaoWenJian> gcjsZhaoBiaoWenJianAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhaoBiaoWenJianStream,                              //要处理的数据流
                new ZhaoBiaoWenJianAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );

        DataStream<AdsGzhChainElgDaily> gcjsZhaoBiaoWenJianCountStream = gcjsZhaoBiaoWenJianAsyncStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSZhaoBiaoWenJian, String>() {
                    @Override
                    public String getKey(GCJSZhaoBiaoWenJian value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new  GCJSZhaoBiaoWenJianCountAggregate(), new AdsGzhChainElgDailyReleasePressureCountWindowFunction());
        //gcjsZhaoBiaoWenJianCountStream.print();
        /*
         * 中标结果公告
         * */

        //统计入场数
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

        DataStream<AdsGzhTradeCountDaily> windowedStream2_gcgg = gcjsZhaoBiaoGongGaoStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSZhaoBiaoGongGao, String>() {
                    @Override
                    public String getKey(GCJSZhaoBiaoGongGao value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSZhaoBiaoGongGaoCountAggregate(), new AdsGzhTradeCountDailyEntranceprojectcountWindowFunction());
       // windowedStream2_gcgg.print();



        //统计交易金额和成交数
        SingleOutputStreamOperator<GCJSZhongBiaoJieGuoGongGao> gcjsZhongBiaoJieGuoGongGaoStream = gcjsZhongBiaoJieGuoGongGaoTagStream
                .keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSZhongBiaoJieGuoGongGao>() {
                    @Override
                    public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSZhongBiaoJieGuoGongGao> out) throws Exception {
                        String eventBody = ebidsunEvent.getEventBody();
                        GCJSZhongBiaoJieGuoGongGao zhongBiaoJieGuoGongGao = new GCJSZhongBiaoJieGuoGongGao();
                        Double CONTRACT_AMOUNT = 0.00;
                        try {
                            JSONArray winningbidInfo = JSONArray.parseArray(JSON.parseObject(eventBody).get("WinningbidInfo").toString());
                            for (Object a : winningbidInfo) {
                                CONTRACT_AMOUNT = CONTRACT_AMOUNT + Double.parseDouble(JSON.parseObject(a.toString()).get("CONTRACT_AMOUNT").toString());
                            }
                            eventBody = eventBody.substring(0, eventBody.length() - 1) + ",\"CONTRACT_AMOUNT\": " + new BigDecimal(CONTRACT_AMOUNT) + "}";
                            zhongBiaoJieGuoGongGao = JSON.parseObject(eventBody, GCJSZhongBiaoJieGuoGongGao.class);
                            out.collect(zhongBiaoJieGuoGongGao);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

        //判断是否缴纳保证金,异步查询
        //catalog_main_data_6d86c2ff870a5e54ebbf880c9573573b
        SingleOutputStreamOperator<GCJSZhongBiaoJieGuoGongGao> zhongBiaoJieGuoAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhongBiaoJieGuoGongGaoStream,                              //要处理的数据流
                new AsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );

        //zhongBiaoJieGuoAsyncStream.print();

        DataStream<AdsGzhTradeCountDaily> ZhongBiaoJieGuoCountStream = zhongBiaoJieGuoAsyncStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSZhongBiaoJieGuoGongGao, String>() {
                    @Override
                    public String getKey(GCJSZhongBiaoJieGuoGongGao value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSZhongBiaoJieGuoCountAggregate(), new AdsGzhTradeCountZhongBiaoJieGuoCountWindowFunction());
       // ZhongBiaoJieGuoCountStream.print();


        //统计节资金额(合同金额)
        SingleOutputStreamOperator<GCJSBiaoDuan> gcjsBiaoDuanStream = gcjsBiaoDuanTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSBiaoDuan>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSBiaoDuan> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    GCJSBiaoDuan gCJSBiaoDuan = JSON.parseObject(eventBody, GCJSBiaoDuan.class);
                    out.collect(gCJSBiaoDuan);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        SingleOutputStreamOperator<GCJSBiaoDuan> gcjsBiaoDuanAsyncStream = AsyncDataStream.orderedWait(
                gcjsBiaoDuanStream,                              //要处理的数据流
                new BiaoDuanAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );

        DataStream<AdsGzhTradeCountDaily> gCJSBiaoDuanCountStream = gcjsBiaoDuanAsyncStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSBiaoDuan, String>() {
                    @Override
                    public String getKey(GCJSBiaoDuan value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSBiaoDuanCountAggregate(), new AdsGzhTradeCountJieZiJinECountWindowFunction());
      //  gCJSBiaoDuanCountStream.print();

        /*
         * 数据应用统计
         * */
        //上链共享项目总量
        SingleOutputStreamOperator<LocalTransactionInfo> localTransactionInfoStream = localTransactionInfoTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, LocalTransactionInfo>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<LocalTransactionInfo> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    LocalTransactionInfo localTransactionInfo = JSON.parseObject(eventBody, LocalTransactionInfo.class);
                    out.collect(localTransactionInfo);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        DataStream<AdsGzhDataApplicationDaily> localTransactionInfoCountStream = localTransactionInfoStream.filter(x -> x.getPlatform_id() != null)
                .keyBy(new KeySelector<LocalTransactionInfo, String>() {
                    @Override
                    public String getKey(LocalTransactionInfo value) throws Exception {
                        return value.getPlatform_id();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new LocalTransactionInfoCountAggregate(), new AdsGzhDataApplicationDailyUsageountWindowFunction());
       // localTransactionInfoCountStream.print();

//上链数据
        DataStream<AdsGzhDataShareDaily> localTransactionInfoCountStream_2 = localTransactionInfoStream.filter(x -> x.getPlatform_id() != null)
                .keyBy(new KeySelector<LocalTransactionInfo, String>() {
                    @Override
                    public String getKey(LocalTransactionInfo value) throws Exception {
                        return value.getPlatform_id();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new LocalTransactionInfoCountAggregate(), new AdsGzhDataShareDailyCountWindowFunction());
        localTransactionInfoCountStream.print();

        //访问量
        SingleOutputStreamOperator<SubscribeFavorites> subscribeFavoritesStream = subscribeFavoritesTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, SubscribeFavorites>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<SubscribeFavorites> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    SubscribeFavorites subscribeFavorites = JSON.parseObject(eventBody, SubscribeFavorites.class);
                    out.collect(subscribeFavorites);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        SingleOutputStreamOperator<SubscribeFavorites> subscribeFavoritesAsyncStream = AsyncDataStream.orderedWait(
                subscribeFavoritesStream,                              //要处理的数据流
                new SubscribeFavoritesAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
        subscribeFavoritesAsyncStream.print();
        DataStream<AdsGzhDataApplicationDaily> subscribeFavoritesCountStream = subscribeFavoritesAsyncStream.filter(x -> x.getPlatform_id() != null)
                .keyBy(new KeySelector<SubscribeFavorites, String>() {
                    @Override
                    public String getKey(SubscribeFavorites value) throws Exception {
                        return value.getPlatform_id();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new SubscribeFavoritesCountAggregate(), new AdsGzhDataApplicationDailyFavoriteWindowFunction());
       // subscribeFavoritesCountStream.print();

        //访问量
        SingleOutputStreamOperator<SubscribeHistory> subscribehistoryStream = subscribehistoryTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, SubscribeHistory>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<SubscribeHistory> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    SubscribeHistory subscribeHistory = JSON.parseObject(eventBody, SubscribeHistory.class);
                    out.collect(subscribeHistory);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        SingleOutputStreamOperator<SubscribeHistory> subscribehistoryAsyncStream = AsyncDataStream.orderedWait(
                subscribehistoryStream,                              //要处理的数据流
                new SubscribeHistoryAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
        subscribehistoryAsyncStream.print();
        DataStream<AdsGzhDataApplicationDaily> subscribehistoryCountStream = subscribehistoryAsyncStream.filter(x -> x.getPlatform_id() != null)
                .keyBy(new KeySelector<SubscribeHistory, String>() {
                    @Override
                    public String getKey(SubscribeHistory value) throws Exception {
                        return value.getPlatform_id();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new SubscribeHistoryCountAggregate(), new AdsGzhDataApplicationDailyvVisitWindowFunction());
        //subscribehistoryCountStream.print();

        //统计收藏量
        SingleOutputStreamOperator<subscribe> subscribeStream = subscribeTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, subscribe>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<subscribe> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                subscribe subscribe = new subscribe();
                String pl = "";
                try {
                    JSONArray trade_center = JSONArray.parseArray(JSON.parseObject(eventBody).get("trade_center").toString());
                    if (null != trade_center) {
                        for (Object a : trade_center) {
                            pl = pl + JSON.parseObject(a.toString()).get("id").toString() + ",";
                        }
                        eventBody = eventBody.substring(0, eventBody.length() - 1) + ",\"Platform_codes\": \"" + pl + "\"}";
                        subscribe = JSON.parseObject(eventBody, subscribe.class);
                        out.collect(subscribe);
                    }

                } catch(JSONException e){
                    e.printStackTrace();
                }

                //   LocalTransactionInfo LocalTransactionInfo = JSON.parseObject(eventBody, LocalTransactionInfo.class);
                //计算逻辑

            }
        });
        SingleOutputStreamOperator<subscribe> subscribeStream_2 = subscribeStream.flatMap(new FlatMapFunction<subscribe, subscribe>() {
            @Override
            public void flatMap(subscribe line, Collector<subscribe> out) throws Exception {
                //将一行字符串按空格切分成一个字符串数组

                for (String Platform_code : line.getPlatform_codes().split(",")) {
                    //输出
                    line.setPlatform_code(Platform_code);
                    out.collect(line);
                }
            }
        });

        DataStream<AdsGzhDataApplicationDaily> subscribeCountStream = subscribeStream_2.filter(x -> x.getPlatform_code() != null)
                .keyBy(new KeySelector<subscribe, String>() {
                    @Override
                    public String getKey(subscribe value) throws Exception {
                        return value.getPlatform_code();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new SubscribeCountAggregate(), new AdsGzhDataApplicationDailySubscribeWindowFunction());
        //subscribeCountStream.print();

 /*       //招标公告与资格预审公告数据集异常
        SingleOutputStreamOperator<GCJSZhaoBiaoGongGao> zhongBiaoGongGaoAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhaoBiaoGongGaoStream,                              //要处理的数据流
                new BiaoDuanYuShenAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
      //  zhongBiaoGongGaoAsyncStream.print();
        //公告发布时间异常(标段(包)建立时间>=公告发布时间)
        SingleOutputStreamOperator<GCJSZhaoBiaoGongGao> zhongBiaoGongGaoStartTimeAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhaoBiaoGongGaoStream,                              //要处理的数据流
                new GonggaoStratTimeAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
      //  zhongBiaoGongGaoStartTimeAsyncStream.print();
        //公告开标时间异常(答疑澄清时间<开标时间)(业务待确定,业务待反馈，异步未完成)
        SingleOutputStreamOperator<GCJSZhaoBiaoGongGao> zhongBiaoGongGaoOpeningTimeAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhaoBiaoGongGaoStream,                              //要处理的数据流
                new GonggaoStratTimeAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
        zhongBiaoGongGaoStartTimeAsyncStream.print();
//招标项目异常(逻辑问题，待处理)
        SingleOutputStreamOperator<GCJSZhaoBiaoXiangMu> gcjsZhaoBiaoXiangMuStream = gcjsZhaoBiaoXiangMuTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSZhaoBiaoXiangMu>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSZhaoBiaoXiangMu> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    GCJSZhaoBiaoXiangMu gCJSZhaoBiaoXiangMu = JSON.parseObject(eventBody, GCJSZhaoBiaoXiangMu.class);
                    out.collect(gCJSZhaoBiaoXiangMu);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        SingleOutputStreamOperator<GCJSZhaoBiaoXiangMu> gcjsZhaoBiaoXiangMuAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhaoBiaoXiangMuStream,                              //要处理的数据流
                new ZhaobBaoXiangMuGuanxiAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
//中标结果公告数据集表有数据，则采购项目、采购公告数据集表必须有数据
        SingleOutputStreamOperator<ZFCGChengJiaoJieGuoGongShi> zfcgChengJiaoJieGuoGongShiStream = zfcgChengJiaoJieGuoGOngGaoTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, ZFCGChengJiaoJieGuoGongShi>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<ZFCGChengJiaoJieGuoGongShi> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    ZFCGChengJiaoJieGuoGongShi zfcgChengJiaoJieGuoGongShi = JSON.parseObject(eventBody, ZFCGChengJiaoJieGuoGongShi.class);
                    out.collect(zfcgChengJiaoJieGuoGongShi);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        SingleOutputStreamOperator<ZFCGChengJiaoJieGuoGongShi> zfcgChengJiaoJieGuoGongShiAsyncStream = AsyncDataStream.orderedWait(
                zfcgChengJiaoJieGuoGongShiStream,                              //要处理的数据流
                new ChengJiaoGongGaoxiAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
//中标（成交）价格/项目预算小于10%或者项目预算/中标价格小于10%则为异常（未解决）
        SingleOutputStreamOperator<ZFCGChengJiaoJieGuoGongShi> zfcgChengJiaoJieGuoGongShiJinEAsyncStream = AsyncDataStream.orderedWait(
                zfcgChengJiaoJieGuoGongShiStream,                              //要处理的数据流
                new ChengJiaoGongGaoJiEAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
        //开标时间小于评标结束时间和招标公告发布时间小于评标结束时间
        SingleOutputStreamOperator<GCJSPingBiaoBaoGao> gcjsPingBiaoBaoGaoEndtimesyncStream = AsyncDataStream.orderedWait(
                gcjsPingBiaoBaoGaoStream,                              //要处理的数据流
                new PingBiaoBaoGaoEndtimeAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
//采购公告发布时间小于中标结果公告首次公告时间
        SingleOutputStreamOperator<ZFCGChengJiaoJieGuoGongShi> zfcgChengJiaoJieGuoGongShiFristTimeAsyncStream = AsyncDataStream.orderedWait(
                zfcgChengJiaoJieGuoGongShiStream,                              //要处理的数据流
                new ChengJiaoGongGaoFirstTimeAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
        //招标公告发布时间小于开标时间
        SingleOutputStreamOperator<GCJSKaiBiaoJiLu> gcjsKaiBiaoJiLuBidOpeningtimesyncStream = AsyncDataStream.orderedWait(
                gcjsKaiBiaoJiLuStream,                              //要处理的数据流
                new KaiBiaoJiLiuBidOpeningtimeAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
        //评标结束时间小于中标候选人公示发布时间
        SingleOutputStreamOperator<GCJSZhongBiaoHouXuanRenGongShi> zhongBiaoHouXuanRenGongShiStream = zfcgZhongBiaoHouXuanRenGongShiTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, GCJSZhongBiaoHouXuanRenGongShi>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<GCJSZhongBiaoHouXuanRenGongShi> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    GCJSZhongBiaoHouXuanRenGongShi zhongBiaoHouXuanRenGongShi = JSON.parseObject(eventBody, GCJSZhongBiaoHouXuanRenGongShi.class);
                    out.collect(zhongBiaoHouXuanRenGongShi);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        SingleOutputStreamOperator<GCJSZhongBiaoHouXuanRenGongShi> gcjszhongBiaoHouXuanRenGongShitimesyncStream = AsyncDataStream.orderedWait(
                zhongBiaoHouXuanRenGongShiStream,                              //要处理的数据流
                new ZhongBiaoHouXuanRenGongShiTimeAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
       // 项目创建时间小于采购公告发布时间
        SingleOutputStreamOperator<ZFCGZhaoBiaoGongGao> zhongBiaoGongGaoStream = gcjsZhongBiaoGongGaoTagStream.keyBy("tableName").flatMap(new RichFlatMapFunction<EbidsunEvent, ZFCGZhaoBiaoGongGao>() {
            @Override
            public void flatMap(EbidsunEvent ebidsunEvent, Collector<ZFCGZhaoBiaoGongGao> out) throws Exception {
                String eventBody = ebidsunEvent.getEventBody();
                try {
                    ZFCGZhaoBiaoGongGao zhaoBiaoGongGao = JSON.parseObject(eventBody, ZFCGZhaoBiaoGongGao.class);
                    out.collect(zhaoBiaoGongGao);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        SingleOutputStreamOperator<ZFCGZhaoBiaoGongGao> zhongBiaoGongGaotimesyncStream = AsyncDataStream.orderedWait(
                zhongBiaoGongGaoStream,                              //要处理的数据流
                new ZhongBiaoGongGaoTimeAsyncFunctionForMysqlUtils(30),   //异步查询函数的具体执行实例
                3000,                             //超时时间
                TimeUnit.MILLISECONDS,             //时间单位
                20                          //最大异步并发请求数量
        );
*/
        env.execute("StatRuleCompute_" + scenarioId);
    }
}