add jar /data/niuxy/udf-1.0.jar;
CREATE FUNCTION NumFieldsUDAF as 'com.bidsun.dw.udaf.NumFields';
SELECT  NumFieldsUDAF("乔丹,科比,悟空,大师兄,热水壶","热水壶,绝地求生,悟空,罗辑");
DROP FUNCTION IF EXISTS UDSum;
#非必填已填字段数
NumFieldsUDAF(requiredFieldStr,filledFieldStr)
#完整状态
status_complete(table_name,data_id,business_pid)
#流程完整分
score_busi_complete(table_name,data_id)

hadoop fs -mkdir /lib
hadoop fs -put /data/niuxy/udf-1.0.jar /lib/
hadoop fs -ls /lib
create function UdfStr2Json as 'com.bidsun.dw.udf.UdfStr2Json'
USING JAR 'hdfs://hdp-0001:8020/lib/udf-1.0.jar';



add jar /data/niuxy/udf-1.0.jar;
create function UdfStr2JsonTmp as 'com.bidsun.dw.udf.UdfStr2Json';
describe function UdfStr2Json;

SELECT  UdfStr2Json("source_table_name_ch:评标报告,field_name:judgeResult,field_name_ch:评标结论,tag_id:1,one_level_tag_id:2,two_level_tag_id:2,is_must:0source_table_name_ch:评标报告,field_name:judgeResult,field_name_ch:评标结论,tag_id:1,one_level_tag_id:2,two_level_tag_id:2,is_must:0");

CREATE FUNCTION UdfStr2Json as 'com.bidsun.dw.udf.UdfStr2Json';