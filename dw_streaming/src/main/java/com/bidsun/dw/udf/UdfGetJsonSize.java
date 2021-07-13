package com.bidsun.dw.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author Niuxy
 * @className UdfGetJsonSize
 * @description TODO
 * @date 2021/5/28 14:57
 */
public class UdfGetJsonSize extends UDF {
    public static void main(String[] args) throws JSONException {
        String str = "[{},{}]";
        System.out.println(evaluate(str));
    }

    public static int evaluate(String str) throws JSONException {
        JSONArray jsonArray = new JSONArray(str);
        int length = jsonArray.length();
        return length;
    }
}
