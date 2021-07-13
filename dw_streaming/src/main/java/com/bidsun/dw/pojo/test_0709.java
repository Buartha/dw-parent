package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Wangyg
 * @className pbbg
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class test_0709 implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
  String	pid	;
  String	ebidsun_data_id	;
  String	table_name	;
  String	source_pid	;
  String	field_name	;
  String	field_value	;
  int	business_type	;
  String	data_version	;
  String	operator	;
  int	tag_id	;
  int	operate_id	;
  int	one_level_tag_id	;
  int	two_level_tag_id	;
  String	logic_tag	;
  String	PLATFORM_NAME	;
  String	PLATFORM_CODE	;
  String	PLATFORM_DEPARTMENT	;
  String	PLATFORM_RESPONSIBLE	;
  String	PLATFORM_RESPONSIBLE_PHONE	;
  String	PLATFORM_RESPONSIBLE_UNIT	;
  String	DATA_RESPONSIBLE_CODE	;
  String	DATA_RESPONSIBLE	;
  String	DATA_RESPONSIBLE_PHONE	;
  Double	rule_score	;
  Date upload_time	;
  Date	submit_time	;
  Date	create_time	;
  Date	update_time	;

}
