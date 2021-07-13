package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.GCJSTouBiaoBaoZhengJinJiaoNa;
import org.apache.flink.api.common.functions.AggregateFunction;

/**
 * @author Niuxy
 * @className MyCountAggregate
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class GCJSTouBiaoBaoZhengJinJiaoNaCountAggregate implements AggregateFunction<GCJSTouBiaoBaoZhengJinJiaoNa, Integer, Integer> {
    @Override
    public Integer createAccumulator() {
        /*访问量初始化为0*/
        return 0;
    }

    @Override
    public Integer add(GCJSTouBiaoBaoZhengJinJiaoNa value, Integer accumulator) {

        /*访问量直接+1 即可*/
        if (""!= value.getBidderName())
        return accumulator + 1;
        else
            return  accumulator ;
    }

    @Override
    public Integer getResult(Integer accumulator) {

        return accumulator;
    }

    /*合并两个统计量*/
    @Override
    public Integer merge(Integer a, Integer b) {
        return a + b;
    }
}

