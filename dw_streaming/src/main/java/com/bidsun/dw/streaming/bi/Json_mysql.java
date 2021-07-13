package com.bidsun.dw.streaming.bi;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author: wangyg
 * @Date: 2021/6/25 20:11
 */
public class Json_mysql
{
    static HashMap map = new HashMap();
    static ArrayList<String> arrcolname = new ArrayList<String>();
    static ArrayList<String> arrcolout = new ArrayList<String>();
    public static ResultSet execSQL(String strtablename) {
        String strsql = null;
        ConnectSQL db1 = null;
        ResultSet ret = null;
        strsql = "select * from " + strtablename+ " limit 10";// SQL语句
        System.out.println(strsql);
        db1 = new ConnectSQL(strsql);// 创建ConnectSQL对象
        KafkaProducer<String, String> StringKafkaProducer = KafkaWriter.register_Kafka();
        try {
            ret = db1.pst.executeQuery();// 执行语句，得到结果集
            while (ret.next()) {
                ResultSetMetaData rsmd = ret.getMetaData();
                int icolnum = rsmd.getColumnCount();

                for (int i = 1; i <= icolnum; i++) {
                    map.put("tableName",strtablename);
                    map.put(rsmd.getColumnName(i).toString(),ret.getString(i));

                    //KafkaWriter.writeToKafka(userActionJson,StringKafkaProducer);
                  //  TimeUnit.SECONDS.sleep(1);

                  //  arrcolname.add(rsmd.getColumnName(i).toString());//table字段名
                   // arrcolout.add(ret.getString(i));//table内容
                }
                String userActionJson = JSON.toJSONString(map);
                System.out.println(userActionJson);
            }
            ret.close();
            db1.close();// 关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    public static String ToJson(LinkedHashMap<String, Object> mTotalOut) {
        String strJsonOut = new String();
        // toJson
        GsonBuilder gsonbuilder = new GsonBuilder().setPrettyPrinting().serializeNulls();
        Gson gson = gsonbuilder.create();
        strJsonOut = gson.toJson(mTotalOut);
        return strJsonOut;

    }

    public static void main(String[] args) throws SQLException {
        ResultSet test3 = execSQL("test_company_info");

       // System.out.println(test3.getArray(1).getArray());

    }
}
