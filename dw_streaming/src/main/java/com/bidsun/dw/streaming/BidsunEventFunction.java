package com.bidsun.dw.streaming;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bidsun.dw.pojo.EbidsunEvent;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Niuxy
 * @className BidsunEventFunction
 * @description TODO
 * @date 2021/6/16 17:11
 */
public class BidsunEventFunction extends RichFlatMapFunction<ObjectNode, EbidsunEvent> {
    private static final Logger logger = LoggerFactory.getLogger(BidsunEventFunction.class);

    @Override
    public void flatMap(ObjectNode jsonNodes, Collector<EbidsunEvent> collector) throws Exception {
        JSONObject jsonObject = JSON.parseObject(jsonNodes.toString());
        String tableName = jsonObject.getJSONObject("value").getString("tableName");

        String value = jsonObject.getJSONObject("value").toJSONString();
        String eventBody = value.replaceAll("_1", "").replaceAll("_2", "").replaceAll("_3", "");

        EbidsunEvent ebidsunEvent = new EbidsunEvent(tableName, eventBody);
        collector.collect(ebidsunEvent);
    }
}
