package com.bidsun.dw.compute.stateagg;

import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * @author Niuxy
 * @className MyCountWindowFunction2
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class AdsGzhTradeCountDailyEntranceprojectcountWindowFunction implements WindowFunction<Integer, com.bidsun.dw.pojo.AdsGzhTradeCountDaily, String, TimeWindow> {
    @Override
    public void apply(String  s, TimeWindow window, Iterable<Integer> input, Collector<com.bidsun.dw.pojo.AdsGzhTradeCountDaily> out) throws Exception {
        /*商品访问统计输出*/
        /*out.collect("productId"productId,window.getEnd(),input.iterator().next()));*/
        //out.collect("----------------窗口时间："+window.getEnd());

        com.bidsun.dw.pojo.AdsGzhTradeCountDaily adsGzahTradeCountDaily = new com.bidsun.dw.pojo.AdsGzhTradeCountDaily();
        adsGzahTradeCountDaily.setPlatform_code(s);
        adsGzahTradeCountDaily.setEntrance_project_count(input.iterator().next());
        out.collect(adsGzahTradeCountDaily);
    }



}
