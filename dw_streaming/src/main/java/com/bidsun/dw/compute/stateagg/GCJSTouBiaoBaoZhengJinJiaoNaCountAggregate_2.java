package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.GCJSTouBiaoBaoZhengJinJiaoNa;
import org.apache.flink.api.common.functions.AggregateFunction;
import scala.Tuple2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Niuxy
 * @className MyCountAggregate
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class GCJSTouBiaoBaoZhengJinJiaoNaCountAggregate_2 implements AggregateFunction<GCJSTouBiaoBaoZhengJinJiaoNa, Tuple2<Integer, Set<String>>, Tuple2<Integer, Set<String>>> {
    @Override
    public Tuple2<Integer, Set<String>> createAccumulator() {
        /*访问量初始化为0*/
        return Tuple2.apply(0, new HashSet<String>());
    }

    @Override
    public Tuple2<Integer, Set<String>> add(GCJSTouBiaoBaoZhengJinJiaoNa value, Tuple2<Integer,Set<String>> accumulator) {
        int a = 0;
        accumulator._2.add(value.getBidderOrgCode());
        /*访问量直接+1 即可*/
        if ("2".equals(value.getBidderName()) || "3".equals(value.getBidderName()) || "4".equals(value.getBidderName()))
            a = accumulator._1 + 1;
            //return Tuple2.apply(accumulator._1+1, accumulator._2);
        else
            a = accumulator._1;
        //   return  Tuple2.apply(accumulator._1, accumulator._2) ;
    return Tuple2.apply(a,accumulator._2);
    }

    @Override
    public Tuple2<Integer, Set<String>> getResult(Tuple2<Integer, Set<String>> accumulator) {

        return accumulator;

    }

    /*合并两个统计量*/
    @Override
    public Tuple2<Integer, Set<String>> merge(Tuple2<Integer,Set<String>> a,Tuple2<Integer, Set<String>> b) {
        Set<String> c = new HashSet<String>();
        c.addAll(a._2);
        c.addAll(b._2);
        return Tuple2.apply(a._1 + b._1, c);
    }
}

