package com.bidsun.dw.udf;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UdfTest extends UDF{
    public String evaluate (String input){
        return "Hello:"+input;
    }
    //本地测试
    @Test
    public void Test() throws Exception{
        String evaluate = evaluate("2018-12-31");
        System.out.println(evaluate);
    }

    public static void main(String[] args) throws JSONException {
        /*String str = "张三,男,18";
        char separator = ',';
        String[] strings = StrUtil.splitToArray(str, separator);
        String s = JSONUtil.toJsonStr(strings);
        System.out.println(s);*/
        // 查找的字符串
        String line = "source_table_name_ch:评标报告,field_name:judgeResult,field_name_ch:评标结论,tag_id:1,one_level_tag_id:2,two_level_tag_id:2,is_must:0source_table_name_ch:评标报告,field_name:judgeResult,field_name_ch:评标结论,tag_id:1,one_level_tag_id:2,two_level_tag_id:2,is_must:0";
        String pattern = "(source_table_name_ch)(.*?)(is_must:[0-1])"; //Java正则表达式以括号分组，第一个括号表示以"（乙方）:"开头，第三个括号表示以" "(空格)结尾，中间括号为目标值，
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 创建 matcher 对象
        Matcher m = r.matcher(line);
        //JSONObject result = new JSONObject();
        //JSONArray jsonArr = new JSONArray();
        JSONArray JsonArray = new JSONArray();
        while (m.find()) {
            String[] arr = m.group(0).split(",");
            JSONObject result1 = new JSONObject();
            for (String s : arr) {
                HashMap<String, String> map = new HashMap<String, String>();
                //JSONObject jsonObject = new JSONObject();
                String[] split = s.split(":");
                //result1.put(split[0], split[1]);
                if (split[0].equals("tag_id") || split[0].equals("one_level_tag_id") || split[0].equals("two_level_tag_id") || split[0].equals("is_must")) {
                    result1.put(split[0], Integer.valueOf(split[1]));
                } else {
                    result1.put(split[0], split[1]);
                }
            }
            JsonArray.put(result1);
        }
        //JSONObject jsonObject = jsonArr.toJSONObject(jsonArr);
        System.out.println("Found json: " + JsonArray.toString() + "长度" + JsonArray.length());
    }

}
