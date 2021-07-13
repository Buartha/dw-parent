package com.bidsun.dw.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * source_table_name_ch:评标报告,field_name:judgeResult,field_name_ch:评标结论,tag_id:1,one_level_tag_id:2,two_level_tag_id:2,is_must:0source_table_name_ch:评标报告,field_name:judgeResult,field_name_ch:评标结论,tag_id:1,one_level_tag_id:2,two_level_tag_id:2,is_must:0
 * */

public class UdfStr2Json extends UDF {
    public static String evaluate(String jsonStr) throws JSONException {
        String pattern = "(source_table_name_ch)(.*?)(is_must:[0-1])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(jsonStr);
        JSONArray JsonArray = new JSONArray();
        while (m.find()) {
            String[] arr = m.group(0).split(",");
            JSONObject result1 = new JSONObject();
            for (String s : arr) {
                HashMap<String, String> map = new HashMap<String, String>();
                String[] split = s.split(":");
                if (split[0].equals("tag_id") || split[0].equals("one_level_tag_id") || split[0].equals("two_level_tag_id") || split[0].equals("is_must")) {
                    result1.put(split[0], Integer.valueOf(split[1]));
                } else {
                    result1.put(split[0], split[1]);
                }
            }
            JsonArray.put(result1);
        }
        return JsonArray.toString();
    }
}
