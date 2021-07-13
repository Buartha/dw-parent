package com.bidsun.dw.compute.stateagg;

import com.bidsun.dw.pojo.AdsGzhCaCountDetail;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import scala.Tuple3;
import scala.Tuple4;

/**
 * @author Niuxy
 * @className MyCountWindowFunction2
 * @description TODO
 * @date 2021/6/28 16:55
 */
public class AdsGzhCaCountDetailUsageountWindowFunction implements WindowFunction<Tuple4<Integer, Integer,Integer,Integer>, AdsGzhCaCountDetail, String, TimeWindow> {
    @Override
    public void apply(String  s, TimeWindow window, Iterable<Tuple4<Integer, Integer,Integer,Integer>> input, Collector<AdsGzhCaCountDetail> out) throws Exception {
        /*商品访问统计输出*/
        /*out.collect("productId"productId,window.getEnd(),input.iterator().next()));*/
        //out.collect("----------------窗口时间："+window.getEnd());

        AdsGzhCaCountDetail AdsGzhCaCountDetail = new AdsGzhCaCountDetail();
        AdsGzhCaCountDetail.setPlatform_code(s);
        AdsGzhCaCountDetail.setMobile_ca_usage_count(input.iterator().next()._1());
        AdsGzhCaCountDetail.setSignature_code_login_count(input.iterator().next()._2());
        AdsGzhCaCountDetail.setEncrypt_decrypt_count(input.iterator().next()._3()+input.iterator().next()._4());
        out.collect(AdsGzhCaCountDetail);
    }



}
