package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.TradeSystemRecord;
import org.apache.flink.api.common.functions.AggregateFunction;
import scala.Tuple4;


/**
 * @author Niuxy
 * @className MyCountAggregate
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class TradeSystemRecordCountAggregate implements AggregateFunction<TradeSystemRecord, Tuple4<Integer, Integer,Integer,Integer>, Tuple4<Integer, Integer,Integer,Integer>> {
    @Override
    public Tuple4<Integer, Integer,Integer,Integer> createAccumulator() {
        /*访问量初始化为0*/
        return Tuple4.apply(0,0,0,0);
    }

    @Override
    public Tuple4<Integer, Integer,Integer,Integer> add(TradeSystemRecord value, Tuple4<Integer, Integer,Integer,Integer> accumulator) {
        int a=0;
        int b=0;
        int c=0;
        int d=0;
      if("1".equals(value.getType())||"2".equals(value.getType())||"3".equals(value.getType()))
         a= accumulator._1()+1;
        if("3".equals(value.getType()))
            b=accumulator._2()+1;
        if("1".equals(value.getType()))
            c= accumulator._3()+1;
        if("2".equals(value.getType()))
            b= accumulator._4()+1;
    return Tuple4.apply(a,b,c,d);
    }

    @Override
    public Tuple4<Integer, Integer,Integer,Integer> getResult(Tuple4<Integer, Integer,Integer,Integer> accumulator) {

        return accumulator;

    }

    /*合并两个统计量*/
    @Override
    public Tuple4<Integer, Integer,Integer,Integer> merge(Tuple4<Integer, Integer,Integer,Integer> a,Tuple4<Integer, Integer,Integer,Integer> b) {

        return Tuple4.apply(a._1() + b._1(), a._2() + b._2(),a._3() + b._3(),a._4() + b._4());
    }
}

