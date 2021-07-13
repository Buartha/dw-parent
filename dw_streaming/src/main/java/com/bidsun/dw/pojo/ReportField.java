package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wangyg
 * @className ReportField
 * @description 反馈字段级
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
public class ReportField implements Serializable {
    public ReportField() {
        this.pid = "0";
        this.ebidsun_data_id = "0";
        this.table_name = "0";
        this.source_pid = "0";
        this.field_name = "0";
        this.field_value = "0";
        this.business_type = 0;
        this.data_version = "2.0";
        this.tag_id = 0;
        this.operate_id = 0;
        this.one_level_tag_id = 0;
        this.two_level_tag_id = 0;
        this.logic_tag = "0";
        this.tenderprojectcode = "0";
        this.sectioncode = "0";
        this.PLATFORM_NAME = "0";
        this.PLATFORM_CODE = "0";
        this.PLATFORM_DEPARTMENT = "0";
        this.PLATFORM_RESPONSIBLE = "0";
        this.PLATFORM_RESPONSIBLE_PHONE = "0";
        this.PLATFORM_RESPONSIBLE_UNIT = "0";
        this.DATA_RESPONSIBLE_CODE = "0";
        this.DATA_RESPONSIBLE = "0";
        this.DATA_RESPONSIBLE_PHONE = "0";
        this.rule_score = 0.0;
        this.upload_time = null;
        this.submit_time = null;
        this.create_time = null;
        this.update_time = null;
    }

    private static final long serialVersionUID = -6637354161064511025L;

    private String pid;
    private String ebidsun_data_id;
    private String table_name;
    private String source_pid;
    private String field_name;
    private String field_value;
    private int business_type;
    private String data_version;
    private int tag_id;
    private int operate_id;
    private int one_level_tag_id;
    private int two_level_tag_id;
    private String logic_tag;
    private String tenderprojectcode;
    private String sectioncode;
    private String PLATFORM_NAME;
    private String PLATFORM_CODE;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;
    private Double rule_score;
    private Date upload_time;
    private Date submit_time;
    private Date create_time;
    private Date update_time;


}
