package com.bidsun.dw.sink;

import com.bidsun.dw.pojo.AdsGzhTradeCountDaily;
import com.bidsun.dw.tools.DbUtils;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author Niuxy
 * @className AdsGzhTradeCountSink
 * @description TODO
 * @date 2021/6/24 17:31
 */
public class AdsGzhTradeCountSink extends RichSinkFunction<AdsGzhTradeCountDaily> {
    private static Logger logger = LoggerFactory.getLogger(AdsGzhTradeCountDaily.class);

    private static final String INSERT_CASE = "insert into data_test.ads_gzh_trade_count_test (platform_code, open_count) values (?, ?)";
    private PreparedStatement statement;
    private Connection connection;


    @Override
    public void invoke(AdsGzhTradeCountDaily tradeCount, SinkFunction.Context context) throws Exception {
        statement.setString(1, tradeCount.getPlatform_code());
        statement.setDouble(2, tradeCount.getOpen_count());
        //statement.setString(2, tradeCount.getTenderProjectCode());
        statement.addBatch();

        int[] count = statement.executeBatch();

        logger.warn("成功写入的对象：" + tradeCount.toString());
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        connection = DbUtils.getConnection();
        statement = connection.prepareStatement(INSERT_CASE);
    }

    @Override
    public void close() throws Exception {
        super.close();
        //关闭并释放资源
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
    }

}
