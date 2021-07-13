package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className AdsGzhCaDetail
 * @description ca明细表
 * @date 2021/6/1 8:45
 */
public class AdsGzhCaDetail implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String id;
    private String ca_id;
    private String user_id;
    private String user_name;
    private String ca_category;
    private String company_name;
    private String project_id;
    private String project_name;
    private String platform_code;
    private String platform_name;
    private String ca_company_name;
    private Integer purchase_type;
    private String subject;
    private String apply_telephone;
    private LocalDateTime get_ca_time;
    private LocalDateTime indate;
    private String indate_type;
    private LocalDateTime from_time;
    private LocalDateTime to_time;
    private Integer ca_manager;
    private String issuer;
    private LocalDateTime purchase_time;
    private Integer purpose;
    private LocalDateTime use_time;
    private String extention;
    private Integer mask;
    private LocalDateTime ctime;
    private LocalDateTime mtime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCa_id() {
        return ca_id;
    }

    public void setCa_id(String ca_id) {
        this.ca_id = ca_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCa_category() {
        return ca_category;
    }

    public void setCa_category(String ca_category) {
        this.ca_category = ca_category;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getPlatform_code() {
        return platform_code;
    }

    public void setPlatform_code(String platform_code) {
        this.platform_code = platform_code;
    }

    public String getPlatform_name() {
        return platform_name;
    }

    public void setPlatform_name(String platform_name) {
        this.platform_name = platform_name;
    }

    public String getCa_company_name() {
        return ca_company_name;
    }

    public void setCa_company_name(String ca_company_name) {
        this.ca_company_name = ca_company_name;
    }

    public Integer getPurchase_type() {
        return purchase_type;
    }

    public void setPurchase_type(Integer purchase_type) {
        this.purchase_type = purchase_type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getApply_telephone() {
        return apply_telephone;
    }

    public void setApply_telephone(String apply_telephone) {
        this.apply_telephone = apply_telephone;
    }

    public LocalDateTime getGet_ca_time() {
        return get_ca_time;
    }

    public void setGet_ca_time(LocalDateTime get_ca_time) {
        this.get_ca_time = get_ca_time;
    }

    public LocalDateTime getIndate() {
        return indate;
    }

    public void setIndate(LocalDateTime indate) {
        this.indate = indate;
    }

    public String getIndate_type() {
        return indate_type;
    }

    public void setIndate_type(String indate_type) {
        this.indate_type = indate_type;
    }

    public LocalDateTime getFrom_time() {
        return from_time;
    }

    public void setFrom_time(LocalDateTime from_time) {
        this.from_time = from_time;
    }

    public LocalDateTime getTo_time() {
        return to_time;
    }

    public void setTo_time(LocalDateTime to_time) {
        this.to_time = to_time;
    }

    public Integer getCa_manager() {
        return ca_manager;
    }

    public void setCa_manager(Integer ca_manager) {
        this.ca_manager = ca_manager;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public LocalDateTime getPurchase_time() {
        return purchase_time;
    }

    public void setPurchase_time(LocalDateTime purchase_time) {
        this.purchase_time = purchase_time;
    }

    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public LocalDateTime getUse_time() {
        return use_time;
    }

    public void setUse_time(LocalDateTime use_time) {
        this.use_time = use_time;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
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
