package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.GCJSBiaoDuan;
import com.bidsun.dw.pojo.GCJSKaiBiaoJiLu;
import org.apache.flink.api.common.functions.AggregateFunction;

/**
 * @author Niuxy
 * @className MyCountAggregate
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class GCJSBiaoDuanCountAggregate implements AggregateFunction<GCJSBiaoDuan, Double, Double> {
    @Override
    public Double createAccumulator() {
        /*访问量初始化为0*/
        return 0.0;
    }

    @Override
    public Double add(GCJSBiaoDuan value, Double accumulator) {

        /*访问量直接+1 即可*/
        return accumulator + value.getContractReckonPrice();
    }

    @Override
    public Double getResult(Double accumulator) {

        return accumulator;
    }

    /*合并两个统计量*/
    @Override
    public Double merge(Double a, Double b) {
        return a + b;
    }
}

