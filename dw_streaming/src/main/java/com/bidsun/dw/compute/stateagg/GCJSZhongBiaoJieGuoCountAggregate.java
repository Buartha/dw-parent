package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.GCJSZhongBiaoJieGuoGongGao;
import org.apache.flink.api.common.functions.AggregateFunction;
import scala.Tuple2;

/**
 * @author Niuxy
 * @className GCJSZhongBiaoJieGuoCountAggregate
 * @description TODO
 * @date 2021/6/29 15:49
 */
public class GCJSZhongBiaoJieGuoCountAggregate implements AggregateFunction<GCJSZhongBiaoJieGuoGongGao, Tuple2<Double, Integer>, Tuple2<Double, Integer>> {
    @Override
    public Tuple2<Double, Integer> createAccumulator() {
        /*访问量初始化为0*/
        return Tuple2.apply(0.00, 0);
    }

    @Override
    public Tuple2<Double, Integer> add(GCJSZhongBiaoJieGuoGongGao value, Tuple2<Double, Integer> accumulator) {

        /*访问量直接+1 即可*/
        Double contract_amount = value.getCONTRACT_AMOUNT();

        return Tuple2.apply(accumulator._1 + contract_amount, accumulator._2 + 1);
    }

    @Override
    public Tuple2<Double, Integer> getResult(Tuple2<Double, Integer> accumulator) {

        return accumulator;
    }

    /*合并两个统计量*/
    @Override
    public Tuple2<Double, Integer> merge(Tuple2<Double, Integer> a, Tuple2<Double, Integer> b) {
        return Tuple2.apply(a._1 + b._1, a._2 + b._2);
    }
}
