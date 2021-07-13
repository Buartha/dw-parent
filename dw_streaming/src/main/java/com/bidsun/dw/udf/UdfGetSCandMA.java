package com.bidsun.dw.udf;

import com.google.common.collect.Lists;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author Niuxy
 * @className UdfGetSCandMA
 * @description TODO
 * @date 2021/5/28 16:16
 */
public class UdfGetSCandMA extends GenericUDTF {
    public static void main(String[] args) throws JSONException {
        String str = "[{\"sectionCode\":\"0遵5203302020060004CG001\",\"marginAmount\":36325},{\"sectionCode\":\"0遵5203302020060004CG001\",\"marginAmount\":36325}]";
        System.out.println(evaluate(str));
    }

    public static String evaluate(String str) throws JSONException {
        JSONArray jsonArray = new JSONArray(str);

        int length = jsonArray.length();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String sectionCode = jsonObject.get("sectionCode").toString();
            Double marginAmount = jsonObject.getDouble("marginAmount");
            stringBuilder.append("sectionCode:" + sectionCode + ",marginAmount:" + marginAmount);
        }
        return stringBuilder.toString();
    }

    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
        List<String> colName = Lists.newLinkedList();
        colName.add("sectionCode");
        colName.add("marginAmount");
        List<ObjectInspector> resType = Lists.newLinkedList();
        resType.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        resType.add(PrimitiveObjectInspectorFactory.javaDoubleObjectInspector);
        // 返回分别为列名 和 列类型
        return ObjectInspectorFactory.getStandardStructObjectInspector(colName, resType);
    }


    @Override
    public void process(Object[] args) throws HiveException {
        if (args[0] == null) {
            return;
        }
        String arg1 = args[0].toString();

        String[] arr1 = arg1.split(",");
        String[] arr2 = null;
        if (args[1] != null) {
            arr2 = args[1].toString().split(",");
        }

       /* for (int i = 0; i < arr1.length; i++) {
            String s = arr1[i];
            if (arr2 != null && arr2.length > i) {
                obj[1] = arr2[i];
            } else {
                obj[1] = null;
            }
            forward(obj);
        }*/
    }

    @Override
    public void close() throws HiveException {

    }
}
