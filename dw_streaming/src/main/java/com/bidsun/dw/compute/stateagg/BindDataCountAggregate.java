package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.BindData;
import org.apache.flink.api.common.functions.AggregateFunction;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Niuxy
 * @className MyCountAggregate
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class BindDataCountAggregate implements AggregateFunction<BindData,  Set<String>,  Set<String>> {
    @Override
    public  Set<String> createAccumulator() {
        /*访问量初始化为0*/
        return  new HashSet<String>();
    }

    @Override
    public  Set<String> add(BindData value, Set<String> accumulator) {
        /*访问量直接+1 即可*/
        accumulator.add(value.getCompany_id());
        return accumulator;
    }

    @Override
    public  Set<String> getResult( Set<String> accumulator) {

        return accumulator;

    }

    /*合并两个统计量*/
    @Override
    public  Set<String> merge(Set<String> a, Set<String> b) {
        Set<String> c = new HashSet<String>();
        c.addAll(a);
        c.addAll(b);
        return c;
    }
}

