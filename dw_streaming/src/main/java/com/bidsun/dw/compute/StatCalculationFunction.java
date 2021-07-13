package com.bidsun.dw.compute;

import com.bidsun.dw.pojo.BidsunAttributes;
import com.bidsun.dw.pojo.CatalogEvent;
import com.bidsun.dw.streaming.StatRuleComputeConstants;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Niuxy
 * @className StatCalculationFunction
 * @description TODO
 * @date 2021/5/24 21:17
 */
public class StatCalculationFunction extends RichFlatMapFunction
        <Tuple2<String, CatalogEvent>, CatalogEvent> {
    private static final Logger logger = LoggerFactory.getLogger(CatalogEvent.class);


    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        ThreadContext.put("module", "stat");
    }


    @Override
    public void close() throws Exception {
        super.close();
    }


    /* (non-Javadoc)
     * @see org.apache.flink.api.common.functions.RichFlatMapFunction#flatMap
     * (java.lang.Object, org.apache.flink.util.Collector)
     */
    @Override
    public void flatMap(Tuple2<String, CatalogEvent> source,
                        Collector<CatalogEvent> collector) throws Exception {
        CatalogEvent original = source.f1;
        //String tranCode = original.getTransactionCode();
        //String msgId = original.getMessageId();
        /*if (logger.isInfoEnabled()) {
            logger.info("Receiving SpdbSceneAttribute for stat calculation: transactionCode={}, "
                            + "messageId={}, scenario={}, attributes={}",
                    new Object[]{tranCode, msgId, original.getSceneId(), original.getMetrics()});
        }
        long start = System.currentTimeMillis();
        try {
            original.set(StatRuleComputeConstants.ATTR_PROCESSRESULT_STAT, ProcessResult.SUCCESS);

            if (logger.isInfoEnabled()) {
                logger.info("Completed stat calculation: transactionCode={}, messageId={}", tranCode, msgId);
            }
        } catch (Exception ex) {
            logger.error("Error processing SpdbSceneAttribute for stat calculation, transactionCode="
                    + tranCode + " messageId=" + msgId, ex);
            original.set(StatRuleComputeConstants.ATTR_PROCESSRESULT_STAT, ProcessResult.ERROR);
        }
        long end = System.currentTimeMillis();
        original.set(StatRuleComputeConstants.ATTR_PROCESSTIME_STAT, Long.valueOf(end - start));*/
        collector.collect(original);
    }
}

