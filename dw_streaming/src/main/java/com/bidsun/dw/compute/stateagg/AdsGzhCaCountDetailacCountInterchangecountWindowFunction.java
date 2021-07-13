package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.AdsGzhCaCountDetail;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.Set;

/**
 * @author Niuxy
 * @className MyCountWindowFunction2
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class AdsGzhCaCountDetailacCountInterchangecountWindowFunction implements WindowFunction< Set<String>, AdsGzhCaCountDetail, String, TimeWindow> {
    @Override
    public void apply(String  s, TimeWindow window, Iterable<Set<String>> input, Collector<AdsGzhCaCountDetail> out) throws Exception {
        /*商品访问统计输出*/
        /*out.collect("productId"productId,window.getEnd(),input.iterator().next()));*/
        //out.collect("----------------窗口时间："+window.getEnd());

        AdsGzhCaCountDetail AdsGzhCaCountDetail = new AdsGzhCaCountDetail();
        AdsGzhCaCountDetail.setPlatform_code(s);
        AdsGzhCaCountDetail.setAccount_interchange_count(input.iterator().next().size());
        out.collect(AdsGzhCaCountDetail);
    }



}
