package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.AdsGzhChainElgDaily;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import scala.Tuple2;

import java.util.Set;

/**
 * @author Niuxy
 * @className MyCountWindowFunction2
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class AdsGzhChainElgDailyElgOpeningCountWindowFunction implements WindowFunction<Tuple2<Integer, Set<String>>, AdsGzhChainElgDaily, String, TimeWindow> {
    @Override
    public void apply(String  s, TimeWindow window, Iterable<Tuple2<Integer, Set<String>>> input, Collector<AdsGzhChainElgDaily> out) throws Exception {
        /*商品访问统计输出*/
        /*out.collect("productId"productId,window.getEnd(),input.iterator().next()));*/
        //out.collect("----------------窗口时间："+window.getEnd());

        AdsGzhChainElgDaily AdsGzhChainElgDaily = new AdsGzhChainElgDaily();
        AdsGzhChainElgDaily.setPlatform_code(s);
        AdsGzhChainElgDaily.setElg_opening_count(input.iterator().next()._1);
        AdsGzhChainElgDaily.setFinancial_institutions_count(input.iterator().next()._2.size());
        out.collect(AdsGzhChainElgDaily);
    }



}
