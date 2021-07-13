package com.bidsun.dw.pojo;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className SLMatchingFile
 * @description 数澜文件反馈
 * @date 2021/6/1 8:45
 */
public class SLMatchingFile implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private Integer id;
    private String project_name;
    private String project_id;
    private String one_name;
    private Double one_score;
    private String two_name;
    private Double two_score;
    private String three_name;
    private Double three_score;
    private String file_type;
    private String bd_name;
    private String zbid;
    private String sid;
    private String pid;
    private String tender_project_name;
    private String tender_project_code;
    private String bd_project_code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getOne_name() {
        return one_name;
    }

    public void setOne_name(String one_name) {
        this.one_name = one_name;
    }

    public Double getOne_score() {
        return one_score;
    }

    public void setOne_score(Double one_score) {
        this.one_score = one_score;
    }

    public String getTwo_name() {
        return two_name;
    }

    public void setTwo_name(String two_name) {
        this.two_name = two_name;
    }

    public Double getTwo_score() {
        return two_score;
    }

    public void setTwo_score(Double two_score) {
        this.two_score = two_score;
    }

    public String getThree_name() {
        return three_name;
    }

    public void setThree_name(String three_name) {
        this.three_name = three_name;
    }

    public Double getThree_score() {
        return three_score;
    }

    public void setThree_score(Double three_score) {
        this.three_score = three_score;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getBd_name() {
        return bd_name;
    }

    public void setBd_name(String bd_name) {
        this.bd_name = bd_name;
    }

    public String getZbid() {
        return zbid;
    }

    public void setZbid(String zbid) {
        this.zbid = zbid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTender_project_name() {
        return tender_project_name;
    }

    public void setTender_project_name(String tender_project_name) {
        this.tender_project_name = tender_project_name;
    }

    public String getTender_project_code() {
        return tender_project_code;
    }

    public void setTender_project_code(String tender_project_code) {
        this.tender_project_code = tender_project_code;
    }

    public String getBd_project_code() {
        return bd_project_code;
    }

    public void setBd_project_code(String bd_project_code) {
        this.bd_project_code = bd_project_code;
    }
}
