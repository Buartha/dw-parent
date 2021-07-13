package com.bidsun.dw.pojo;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className LogAppQrcode
 * @description 扫码登录统计
 * @date 2021/6/1 8:45
 */
public class LogAppQrcode implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String qr_code_id;
    private String qr_code;
    private String app_id;
    private String platform_Id;
    private Integer qr_code_type;
    private Integer qr_code_status;
    private Integer gran_usert_auth_status;
    private String company_id;
    private String company_name;
    private String user_id;
    private String open_id;
    private String token;
    private String account_id;
    private String extension;
    private Integer mask;
    private String ctime;
    private String mtime;

    public String getQr_code_id() {
        return qr_code_id;
    }

    public void setQr_code_id(String qr_code_id) {
        this.qr_code_id = qr_code_id;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getPlatform_Id() {
        return platform_Id;
    }

    public void setPlatform_Id(String platform_Id) {
        this.platform_Id = platform_Id;
    }

    public Integer getQr_code_type() {
        return qr_code_type;
    }

    public void setQr_code_type(Integer qr_code_type) {
        this.qr_code_type = qr_code_type;
    }

    public Integer getQr_code_status() {
        return qr_code_status;
    }

    public void setQr_code_status(Integer qr_code_status) {
        this.qr_code_status = qr_code_status;
    }

    public Integer getGran_usert_auth_status() {
        return gran_usert_auth_status;
    }

    public void setGran_usert_auth_status(Integer gran_usert_auth_status) {
        this.gran_usert_auth_status = gran_usert_auth_status;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
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

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }
}
