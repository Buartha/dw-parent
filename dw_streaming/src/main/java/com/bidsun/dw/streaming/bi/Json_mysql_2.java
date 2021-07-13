package com.bidsun.dw.streaming.bi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @Author: wangyg
 * @Date: 2021/6/25 20:11
 */
public class Json_mysql_2
{
    static HashMap map = new HashMap();
    static ArrayList<String> arrcolname = new ArrayList<String>();
    static ArrayList<String> arrcolout = new ArrayList<String>();
    public static void execSQL(String strtablename) {
        String strsql = null;
        String strsql2 ="";
        String strsql3 ="";
        ConnectSQL db1 = null;
        ConnectSQL db2 = null;
        ResultSet ret = null;
        strsql = "desc " + strtablename;// SQL语句

        db1 = new ConnectSQL(strsql);// 创建ConnectSQL对象
        KafkaProducer<String, String> StringKafkaProducer = KafkaWriter.register_Kafka();
        try {
            ret = db1.pst.executeQuery();// 执行语句，得到结果集
            while (ret.next()) {
                ResultSetMetaData rsmd = ret.getMetaData();
                int icolnum = rsmd.getColumnCount();
                strsql2=strsql2+ '\''+ ret.getString(1)+ '\''+","+ret.getString(1)+",";
                //System.out.println(strsql2);
                for (int i = 1; i <= icolnum; i++) {
                    map.put("tableName",strtablename);

                    //KafkaWriter.writeToKafka(userActionJson,StringKafkaProducer);
                  //  TimeUnit.SECONDS.sleep(1);

                  //  arrcolname.add(rsmd.getColumnName(i).toString());//table字段名

                }
              //  String userActionJson = JSON.toJSONString(map);
               // System.out.println(userActionJson);
            }
            strsql2="SELECT JSON_OBJECT("+strsql2+"\'tableName\',"+ "\'"+strtablename+"\'"+") FROM ";
            ret.close();
            db1.close();// 关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        strsql3 = strsql2 + strtablename+ " limit 3";// SQL语句
        System.out.println(strsql3);
        db2 = new ConnectSQL(strsql3);// 创建ConnectSQL对象
        try {
            ret = db2.pst.executeQuery();// 执行语句，得到结果集
            while (ret.next()) {
                KafkaWriter.writeToKafka(ret.getString(1),StringKafkaProducer,strtablename+"test");
               // System.out.println(ret.getString(1));
            }

            ret.close();
            db1.close();// 关闭连接
            StringKafkaProducer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        String tableName=null;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("退出请输入：exit");
            System.out.println("请输入正确表名：");
             tableName = scanner.nextLine();
          //  tableName=args[0];
            System.out.println(tableName);
            if (tableName.equals("exit") ){
                System.out.print("任务执行结束");
                System.exit(-1);}
            execSQL(tableName);
            System.out.println("执行结束");
        }



       // System.out.println(test3.getArray(1).getArray());

    }
}
