package com.bidsun.dw.streaming;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bidsun.dw.compute.stateagg.*;
import com.bidsun.dw.pojo.*;
import com.bidsun.dw.streaming.bi.ConnectSQL;
import com.bidsun.dw.streaming.bi.Json_mysql_2;
import com.bidsun.dw.tools.*;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.BroadcastState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ReadOnlyBroadcastState;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.api.scala.codegen.TypeInformationGen;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.streaming.api.datastream.*;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.BroadcastProcessFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.util.serialization.JSONKeyValueDeserializationSchema;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Niuxy
 * @className StatRuleComputeMain
 * @description streaming main function
 * @date 2021/5/21 11:32
 */
public class StatRuleComputeMain_mingxi implements StatRuleComputeConstants {
    //private static Logger logger = LoggerFactory.getLogger(StatRuleComputeMain_mingxi.class);


    public static void main(String[] args) throws Exception {
        Json_mysql_2.execSQL("catalog_data_field_required");
        ThreadContext.put("module", "mainfunction");

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();


        final ParameterTool params = ParameterTool.fromArgs(args);
        //???????????????
        //Map inputParaConf = YamlConfigUtils.findAndReadConfigFile(params.getRequired(INPUTPARAM_CONFIG_PATH), false);
        Map inputParaConf = YamlConfigUtils.findAndReadConfigFile("./conf/ComputeRule1002.yaml", true);

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
       // if (logger.isInfoEnabled()) {
        //    logger.info("------Input parameter map: {}", inputParaConf);
       //     logger.info("------scenarioId is: {}", scenarioId);
        //    logger.info("Input topic name is: {}", kafkaRecordTopic);
      //  }


        //SimpleStringSchema???????????????kafka?????????JSONKeyValueDeserializationSchema????????????????????????key,value???metadata:topic,partition???offset?????????
        String kafkaRuleStatInputTopic = inputParaConf.get(YamlConfigUtils.kafkaRuleStatInputTopic).toString();

        FlinkKafkaConsumer010<ObjectNode> kafkaConsumer011 = new FlinkKafkaConsumer010<ObjectNode>(kafkaRuleStatInputTopic,
                new JSONKeyValueDeserializationSchema(true), envParameter.getProperties());

        //??????kafka?????????
        DataStreamSource<ObjectNode> streamSource = env.addSource(kafkaConsumer011);

        //??????????????????
        SingleOutputStreamOperator<EbidsunEvent> ebidsunEventStream = streamSource.flatMap(new BidsunEventFunction());
        //ebidsunEventStream.print();
  // ebidsunEventStream.map(x -> x.getTableName().substring(0,7)).print();
        SingleOutputStreamOperator<EbidsunEvent> catalogEventStream = ebidsunEventStream.filter(x -> "catalog".equals(x.getTableName().substring(0, 7)));


       String  sql="SELECT tablename, instancefield,filedname from catalog_data_field_required where isrequired=1";
        ConnectSQL db1 = null;
        db1 = new ConnectSQL(sql);// ??????ConnectSQL??????
        ResultSet resultSet = db1.pst.executeQuery();
        ArrayList<String> filednamelist = new ArrayList<>();
        Tuple2<String, ArrayList<String>> filednameTuple2 = new Tuple2<>("",filednamelist);
        filednameTuple2=null;
        HashMap<String, Tuple2<String, ArrayList<String>>> resultsmap = new HashMap<>();
        JSONObject node = new JSONObject();
        while (resultSet.next()){
            String tablename = resultSet.getString("tablename");
            String instancefield = resultSet.getString("instancefield");
            String filedname = resultSet.getString("filedname");
            if (null != resultsmap.get(tablename)){
                 filednamelist = resultsmap.get(tablename)._2;
                 filednamelist.add(filedname);
                filednameTuple2=Tuple2.apply(instancefield,filednamelist);
                resultsmap.put(tablename,filednameTuple2);
            }else {
                filednamelist=null;
                filednamelist.add(filedname);
                filednameTuple2 = Tuple2.apply(instancefield, filednamelist);
                resultsmap.put(tablename, filednameTuple2);

            }
            }
        final OutputTag<EbidsunEvent> catalog = new OutputTag<EbidsunEvent>("catalog") {
        };
        final OutputTag<EbidsunEvent> catalogDataFieldRequired = new OutputTag<EbidsunEvent>("catalogDataFieldRequired") {
        };


        //??????????????????????????????
        // ??????Side Output??????
      /*  final OutputTag<EbidsunEvent> gcjsZhongBiaoJieGuoGongGao = new OutputTag<EbidsunEvent>("zhongBiaoJieGuoGongGao") {
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
        SingleOutputStreamOperator<EbidsunEvent> sideOutputData = ebidsunEventStream.process(new ProcessFunction<EbidsunEvent, EbidsunEvent>() {
            @Override
            public void processElement(EbidsunEvent ebidsunEvent, Context ctx, Collector<EbidsunEvent> out) throws Exception {
                String tableName = ebidsunEvent.getTableName();
                switch (tableName) {
                    case "catalog_main_data_4bd1f410d2f4737df2e8da9c885a2e3e":
                        ctx.output(gcjsZhongBiaoJieGuoGongGao, ebidsunEvent);
                        break;
                    case "catalog_main_data4ff9fe0380450915ca9f365d248909e":
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



        *//*
         * ????????????????????????
         * *//*
        //???????????????
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
         zhaoBiaoYiChangQingKuangBaoGaoCountStream.print();


        //???????????????
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
       kaiBiaoJiLuCountStream.print();

        //???????????????
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
       // PingBiaoBaoGaoCountStream.print();
   PingBiaoBaoGaoCountStream.print();


        //???????????????
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
        gcjsTouBiaoBaoZhengJinJiaoNaCountStream.print();

        *//*
         * CA????????????
         * *//*

          //???????????????
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
        bindDataCountStream.print();

        //??????CA????????????,??????????????????,???????????????
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
        tradeSystemRecordCountStream.print();

        *//*
         * ??????????????????
         * *//*
        //????????????????????????,???????????????????????????
        DataStream<AdsGzhChainElgDaily> PingBiaoBaoGaoCountStream_2 = gcjsTouBiaoBaoZhengJinJiaoNaStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSTouBiaoBaoZhengJinJiaoNa, String>() {
                    @Override
                    public String getKey(GCJSTouBiaoBaoZhengJinJiaoNa value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSTouBiaoBaoZhengJinJiaoNaCountAggregate_2(), new AdsGzhChainElgDailyElgOpeningCountWindowFunction());
        PingBiaoBaoGaoCountStream_2.print();


        //????????????????????????
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
                gcjsZhaoBiaoWenJianStream,                              //?????????????????????
                new ZhaoBiaoWenJianAsyncFunctionForMysqlUtils(30),   //???????????????????????????????????????
                3000,                             //????????????
                TimeUnit.MILLISECONDS,             //????????????
                20                          //??????????????????????????????
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
        gcjsZhaoBiaoWenJianCountStream.print();
        *//*
         * ??????????????????
         * *//*

        //???????????????
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
        windowedStream2_gcgg.print();



        //??????????????????????????????
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

        //???????????????????????????,????????????
        //catalog_main_data_6d86c2ff870a5e54ebbf880c9573573b
        SingleOutputStreamOperator<GCJSZhongBiaoJieGuoGongGao> zhongBiaoJieGuoAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhongBiaoJieGuoGongGaoStream,                              //?????????????????????
                new AsyncFunctionForMysqlUtils(30),   //???????????????????????????????????????
                3000,                             //????????????
                TimeUnit.MILLISECONDS,             //????????????
                20                          //??????????????????????????????
        );

        zhongBiaoJieGuoAsyncStream.print();

        DataStream<AdsGzhTradeCountDaily> ZhongBiaoJieGuoCountStream = zhongBiaoJieGuoAsyncStream.filter(x -> x.getPLATFORM_CODE() != null)
                .keyBy(new KeySelector<GCJSZhongBiaoJieGuoGongGao, String>() {
                    @Override
                    public String getKey(GCJSZhongBiaoJieGuoGongGao value) throws Exception {
                        return value.getPLATFORM_CODE();
                    }
                })
                .timeWindow(Time.days(1), Time.seconds(10))
                .aggregate(new GCJSZhongBiaoJieGuoCountAggregate(), new AdsGzhTradeCountZhongBiaoJieGuoCountWindowFunction());
        ZhongBiaoJieGuoCountStream.print();


        //??????????????????(????????????)
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
                gcjsBiaoDuanStream,                              //?????????????????????
                new BiaoDuanAsyncFunctionForMysqlUtils(30),   //???????????????????????????????????????
                3000,                             //????????????
                TimeUnit.MILLISECONDS,             //????????????
                20                          //??????????????????????????????
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
        gCJSBiaoDuanCountStream.print();

        *//*
         * ??????????????????
         * *//*
        //????????????????????????
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
        localTransactionInfoCountStream.print();

//????????????
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

        //?????????
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
                subscribeFavoritesStream,                              //?????????????????????
                new SubscribeFavoritesAsyncFunctionForMysqlUtils(30),   //???????????????????????????????????????
                3000,                             //????????????
                TimeUnit.MILLISECONDS,             //????????????
                20                          //??????????????????????????????
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
        subscribeFavoritesCountStream.print();

        //?????????
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
                subscribehistoryStream,                              //?????????????????????
                new SubscribeHistoryAsyncFunctionForMysqlUtils(30),   //???????????????????????????????????????
                3000,                             //????????????
                TimeUnit.MILLISECONDS,             //????????????
                20                          //??????????????????????????????
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
        subscribehistoryCountStream.print();

        //???????????????
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
                //????????????

            }
        });
        SingleOutputStreamOperator<subscribe> subscribeStream_2 = subscribeStream.flatMap(new FlatMapFunction<subscribe, subscribe>() {
            @Override
            public void flatMap(subscribe line, Collector<subscribe> out) throws Exception {
                //?????????????????????????????????????????????????????????

                for (String Platform_code : line.getPlatform_codes().split(",")) {
                    //??????
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
        subscribeCountStream.print();

        //????????????????????????????????????????????????
        SingleOutputStreamOperator<GCJSZhaoBiaoGongGao> zhongBiaoGongGaoAsyncStream = AsyncDataStream.orderedWait(
                gcjsZhaoBiaoGongGaoStream,                              //?????????????????????
                new BiaoDuanYuShenAsyncFunctionForMysqlUtils(30),   //???????????????????????????????????????
                3000,                             //????????????
                TimeUnit.MILLISECONDS,             //????????????
                20                          //??????????????????????????????
        );
        zhongBiaoGongGaoAsyncStream.print();*/
        env.execute("StatRuleCompute_" + scenarioId);
    }
}