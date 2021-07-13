package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className CaUserCa
 * @description 用户CA证书
 * @date 2021/6/1 8:45
 */
public class CaUserCa implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String user_ca_id;
    private String order_id;
    private String company_id;
    private String user_id;
    private String ca_id;
    private Integer ca_type;
    private String ca_company_name;
    private String short_ca_company_name;
    private String ca_user_id;
    private String signature_algorithm;
    private Integer algorithm_type;
    private Integer algorithm_length;
    private String country;
    private String subject;
    private String password;
    private String user_name;
    private String company_name;
    private String phone;
    private String email;
    private String serial_num;
    private LocalDateTime from_time;
    private LocalDateTime to_time;
    private String issuer;
    private String pub_key;
    private String enc_private;
    private String cert;
    private String version;
    private Integer status;
    private String device_id;
    private String pre_ca_user_id;
    private Integer ca_category;
    private Integer activity_type;
    private String cloud_shield_id;
    private String key_label;
    private Integer ca_manager;
    private String apply_telephone;
    private String extension;
    private Integer mask;
    private String ctime;
    private String mtime;

    public String getUser_ca_id() {
        return user_ca_id;
    }

    public void setUser_ca_id(String user_ca_id) {
        this.user_ca_id = user_ca_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCa_id() {
        return ca_id;
    }

    public void setCa_id(String ca_id) {
        this.ca_id = ca_id;
    }

    public Integer getCa_type() {
        return ca_type;
    }

    public void setCa_type(Integer ca_type) {
        this.ca_type = ca_type;
    }

    public String getCa_company_name() {
        return ca_company_name;
    }

    public void setCa_company_name(String ca_company_name) {
        this.ca_company_name = ca_company_name;
    }

    public String getShort_ca_company_name() {
        return short_ca_company_name;
    }

    public void setShort_ca_company_name(String short_ca_company_name) {
        this.short_ca_company_name = short_ca_company_name;
    }

    public String getCa_user_id() {
        return ca_user_id;
    }

    public void setCa_user_id(String ca_user_id) {
        this.ca_user_id = ca_user_id;
    }

    public String getSignature_algorithm() {
        return signature_algorithm;
    }

    public void setSignature_algorithm(String signature_algorithm) {
        this.signature_algorithm = signature_algorithm;
    }

    public Integer getAlgorithm_type() {
        return algorithm_type;
    }

    public void setAlgorithm_type(Integer algorithm_type) {
        this.algorithm_type = algorithm_type;
    }

    public Integer getAlgorithm_length() {
        return algorithm_length;
    }

    public void setAlgorithm_length(Integer algorithm_length) {
        this.algorithm_length = algorithm_length;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(String serial_num) {
        this.serial_num = serial_num;
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

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getPub_key() {
        return pub_key;
    }

    public void setPub_key(String pub_key) {
        this.pub_key = pub_key;
    }

    public String getEnc_private() {
        return enc_private;
    }

    public void setEnc_private(String enc_private) {
        this.enc_private = enc_private;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getPre_ca_user_id() {
        return pre_ca_user_id;
    }

    public void setPre_ca_user_id(String pre_ca_user_id) {
        this.pre_ca_user_id = pre_ca_user_id;
    }

    public Integer getCa_category() {
        return ca_category;
    }

    public void setCa_category(Integer ca_category) {
        this.ca_category = ca_category;
    }

    public Integer getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(Integer activity_type) {
        this.activity_type = activity_type;
    }

    public String getCloud_shield_id() {
        return cloud_shield_id;
    }

    public void setCloud_shield_id(String cloud_shield_id) {
        this.cloud_shield_id = cloud_shield_id;
    }

    public String getKey_label() {
        return key_label;
    }

    public void setKey_label(String key_label) {
        this.key_label = key_label;
    }

    public Integer getCa_manager() {
        return ca_manager;
    }

    public void setCa_manager(Integer ca_manager) {
        this.ca_manager = ca_manager;
    }

    public String getApply_telephone() {
        return apply_telephone;
    }

    public void setApply_telephone(String apply_telephone) {
        this.apply_telephone = apply_telephone;
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
