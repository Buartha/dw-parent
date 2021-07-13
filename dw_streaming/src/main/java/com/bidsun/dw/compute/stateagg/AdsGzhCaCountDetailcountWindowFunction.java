package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.AdsGzhCaCountDetail;
import com.bidsun.dw.pojo.AdsGzhTradeCountDaily;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * @author Niuxy
 * @className MyCountWindowFunction2
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class AdsGzhCaCountDetailcountWindowFunction implements WindowFunction<Integer, AdsGzhCaCountDetail, String, TimeWindow> {
    @Override
    public void apply(String  s, TimeWindow window, Iterable<Integer> input, Collector<AdsGzhCaCountDetail> out) throws Exception {
        /*商品访问统计输出*/
        /*out.collect("productId"productId,window.getEnd(),input.iterator().next()));*/
        //out.collect("----------------窗口时间："+window.getEnd());

        AdsGzhCaCountDetail adsGzhCaCountDetail = new AdsGzhCaCountDetail();
        adsGzhCaCountDetail.setPlatform_code(s);
        adsGzhCaCountDetail.setAccount_interchange_count(input.iterator().next());
        out.collect(adsGzhCaCountDetail);
    }



}
