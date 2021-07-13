package com.bidsun.dw.test;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.state.BroadcastState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ReadOnlyBroadcastState;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.BroadcastStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.BroadcastProcessFunction;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.util.Collector;

/**
 * ClassName:    BroadcastStateDemo02
 * Author:   Administrator
 * Date: 2021/5/16
 * Description:
 *    事实流 -- user1,10,10000.0
 *    维度流 -- INSERT,10,新人礼包
 *    user1,10,新人礼包,10000.0
 *    把维度流广播出去,
 *
 * INSERT,10,新人礼包
 * INSERT,11,元旦活动
 * UPDATE,10,新人活动
 * INSERT,12,女神节活动
 * DELETE,11,元旦活动
 *
 *user1,10,10000.0
 * user2,11,10000.0
 * user3,10,10000.0
 */
public class BroadcastStateDemo02 {

    public static void main(String[] args) throws Exception {

        //创建执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());

        //开始CheckPoint,程序具有容错性
        env.enableCheckpointing(10000);

        //创建事实流端口
        DataStreamSource<String> lines1 = env.socketTextStream("linux1", 8888);

        //分析数据
        SingleOutputStreamOperator<Tuple3<String, String, String>> map1 = lines1.map(new MapFunction<String, Tuple3<String, String, String>>() {
            @Override
            public Tuple3<String, String, String> map(String value) throws Exception {
                String[] split = value.split(",");
                return Tuple3.of(split[0], split[1], split[2]);
            }
        });

        //需要构建状态,把数据持久化(开启Checkpoint)
        //创建维度流端口
        DataStreamSource<String> lines2 = env.socketTextStream("linux1", 9999);

        //处理数据
        SingleOutputStreamOperator<Tuple3<String, String, String>> map2 = lines2.map(new MapFunction<String, Tuple3<String, String, String>>() {
            @Override
            public Tuple3<String, String, String> map(String value) throws Exception {
                String[] split = value.split(",");
                return Tuple3.of(split[0], split[1], split[2]);
            }
        });

        //构建一个状态描述器,把需要广播的数据流广播出去   编号和需要修改的数据
        MapStateDescriptor<String, String> mapStateDescriptor = new MapStateDescriptor<>("broadcast", String.class, String.class);
        //把数据转换成广播流   广播状态的并行实例
        BroadcastStream<Tuple3<String, String, String>> broadcast = map2.broadcast(mapStateDescriptor);

        //把两个流关联起来
        //user1,10,新人礼包,10000.0
        map1.connect(broadcast).process(new BroadcastProcessFunction<Tuple3<String, String, String>, Tuple3<String, String, String>, Tuple4<String, String, String, String>>() {
            //来一条数据处理一次
            //只能关联不能改
            @Override
            public void processElement(Tuple3<String, String, String> value, ReadOnlyContext ctx, Collector<Tuple4<String, String, String, String>> out) throws Exception {
                //处理事实流数据
                System.out.println("事实流数据------->"+ value);
                //这是一个闭包,调取外部参数
                ReadOnlyBroadcastState<String, String> broadcastState = ctx.getBroadcastState(mapStateDescriptor);
                String actId = value.f1;
                String name = broadcastState.get(actId);
                out.collect(Tuple4.of(value.f0,actId,name,value.f2));
            }
            //维度流数据
            //维度流的数据先进来,处理好数据放在内存中,广播之后放到了后面的每一个分区
            @Override
            public void processBroadcastElement(Tuple3<String, String, String> value, Context ctx, Collector<Tuple4<String, String, String, String>> out) throws Exception {
                System.out.println("调用了维度流数据------->"+value);
                String type = value.f0;
                String id = value.f1;
                String name = value.f2;

                //这里使用了闭包  //
                BroadcastState<String, String> broadcastState = ctx.getBroadcastState(mapStateDescriptor);

                //判断输入的类型,进行相应的操作
                if ("DELETE".equals(type)){
                    broadcastState.remove(id);
                }else {
                    broadcastState.put(id,name);
                }
            }
        }).print();

        env.execute();

    }

}
