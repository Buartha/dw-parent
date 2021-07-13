package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className subscribe
 * @description 大数据返回的反馈表
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseBusinessPro implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String row_id;
    private String platform_id;
    private String project_code;
    private String project_name;
    private String section_code;
    private String section_name;
    private Integer data_version;
    private String source_version;
    private String source_table_id;
    private String source_number;
    private String msg;
    private Integer bid_category;
    private String source_tableName;
    private String source_table_en_name;
    private String data_responsible_unit;
    private String data_responsible_code;
    private String data_responsible_name;
    private String data_responsible_phone;
    private Integer read_tag;
    private String field_str;
    private String extension;
    private Integer mask;
    private LocalDateTime ctime;
    private LocalDateTime mtime;

    public String getRow_id() {
        return row_id;
    }

    public void setRow_id(String row_id) {
        this.row_id = row_id;
    }

    public String getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(String platform_id) {
        this.platform_id = platform_id;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getSection_code() {
        return section_code;
    }

    public void setSection_code(String section_code) {
        this.section_code = section_code;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Integer getData_version() {
        return data_version;
    }

    public void setData_version(Integer data_version) {
        this.data_version = data_version;
    }

    public String getSource_version() {
        return source_version;
    }

    public void setSource_version(String source_version) {
        this.source_version = source_version;
    }

    public String getSource_table_id() {
        return source_table_id;
    }

    public void setSource_table_id(String source_table_id) {
        this.source_table_id = source_table_id;
    }

    public String getSource_number() {
        return source_number;
    }

    public void setSource_number(String source_number) {
        this.source_number = source_number;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getBid_category() {
        return bid_category;
    }

    public void setBid_category(Integer bid_category) {
        this.bid_category = bid_category;
    }

    public String getSource_tableName() {
        return source_tableName;
    }

    public void setSource_tableName(String source_tableName) {
        this.source_tableName = source_tableName;
    }

    public String getSource_table_en_name() {
        return source_table_en_name;
    }

    public void setSource_table_en_name(String source_table_en_name) {
        this.source_table_en_name = source_table_en_name;
    }

    public String getData_responsible_unit() {
        return data_responsible_unit;
    }

    public void setData_responsible_unit(String data_responsible_unit) {
        this.data_responsible_unit = data_responsible_unit;
    }

    public String getData_responsible_code() {
        return data_responsible_code;
    }

    public void setData_responsible_code(String data_responsible_code) {
        this.data_responsible_code = data_responsible_code;
    }

    public String getData_responsible_name() {
        return data_responsible_name;
    }

    public void setData_responsible_name(String data_responsible_name) {
        this.data_responsible_name = data_responsible_name;
    }

    public String getData_responsible_phone() {
        return data_responsible_phone;
    }

    public void setData_responsible_phone(String data_responsible_phone) {
        this.data_responsible_phone = data_responsible_phone;
    }

    public Integer getRead_tag() {
        return read_tag;
    }

    public void setRead_tag(Integer read_tag) {
        this.read_tag = read_tag;
    }

    public String getField_str() {
        return field_str;
    }

    public void setField_str(String field_str) {
        this.field_str = field_str;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public LocalDateTime getMtime() {
        return mtime;
    }

    public void setMtime(LocalDateTime mtime) {
        this.mtime = mtime;
    }
}
