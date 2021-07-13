package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.GCJSZhaoBiaoWenJian;
import com.bidsun.dw.pojo.GCJSZhongBiaoJieGuoGongGao;
import org.apache.flink.api.common.functions.AggregateFunction;
import scala.Tuple2;

/**
 * @author Niuxy
 * @className GCJSZhongBiaoJieGuoCountAggregate
 * @description TODO
 * @date 2021/6/29 15:49
 */
public class GCJSZhaoBiaoWenJianCountAggregate implements AggregateFunction<GCJSZhaoBiaoWenJian, Double, Double> {
    @Override
    public Double createAccumulator() {
        /*访问量初始化为0*/
        return 0.0;
    }

    @Override
    public Double add(GCJSZhaoBiaoWenJian value, Double accumulator) {

        /*访问量直接+1 即可*/

        return accumulator+value.getMarginAmount();
    }

    @Override
    public Double getResult(Double accumulator) {

        return accumulator;
    }

    /*合并两个统计量*/
    @Override
    public Double merge(Double a, Double b) {
        return a+b;
    }
}
