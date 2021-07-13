package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.AdsGzhTradeCountDaily;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import scala.Tuple2;

/**
 * @author Niuxy
 * @className AdsGzhTradeCountZhongBiaoJieGuoCountWindowFunction
 * @description TODO
 * @date 2021/6/29 16:43
 */
public class AdsGzhTradeCountZhongBiaoJieGuoCountWindowFunction implements WindowFunction<Tuple2<Double, Integer>, AdsGzhTradeCountDaily, String, TimeWindow> {
    @Override
    public void apply(String  s, TimeWindow window, Iterable<Tuple2<Double, Integer>> input, Collector<AdsGzhTradeCountDaily> out) throws Exception {
        /*商品访问统计输出*/
        /*out.collect("productId"productId,window.getEnd(),input.iterator().next()));*/
        //out.collect("----------------窗口时间："+window.getEnd());

        AdsGzhTradeCountDaily adsGzhTradeCountDaily = new AdsGzhTradeCountDaily();
        adsGzhTradeCountDaily.setPlatform_code(s);
        adsGzhTradeCountDaily.setTrade_count(input.iterator().next()._2);
        adsGzhTradeCountDaily.setTrade_amount(input.iterator().next()._1);
        out.collect(adsGzhTradeCountDaily);
    }


}
