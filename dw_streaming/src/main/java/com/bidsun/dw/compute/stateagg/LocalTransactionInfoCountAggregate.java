package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.LocalTransactionInfo;
import org.apache.flink.api.common.functions.AggregateFunction;

/**
 * @author Niuxy
 * @className MyCountAggregate
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class LocalTransactionInfoCountAggregate implements AggregateFunction<LocalTransactionInfo, Integer, Integer> {
    @Override
    public Integer createAccumulator() {
        /*访问量初始化为0*/
        return 0;
    }

    @Override
    public Integer add(LocalTransactionInfo value, Integer accumulator) {

        /*访问量直接+1 即可*/
        return accumulator + 1;
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

