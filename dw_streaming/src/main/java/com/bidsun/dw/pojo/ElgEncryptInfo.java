package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className ElgEncryptInfo
 * @description elg 密文表
 * @date 2021/6/1 8:45
 */
public class ElgEncryptInfo implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String elg_id;
    private String elg_order_id;
    private String elg_status;
    private String elg_org_id;
    private String elg_org_name;
    private LocalDateTime elg_apply_time;
    private String elg_encryptinfo;
    private String elg_envelope;
    private String elg_encrypted_method;
    private String elg_envelop_encrypted_method;
    private String elg_user_cert;
    private String elg_user_id;
    private String elg_url;
    private String elg_error_message;
    private String elg_company_id;
    private LocalDateTime elg_push_trad_time;
    private LocalDateTime elg_out_elg_time;
    private LocalDateTime elg_pay_time;
    private LocalDateTime receive_deadline;
    private LocalDateTime last_pay_time;
    private String accept_company;
    private String invalided;
    private String invoice_type;
    private LocalDateTime decrypt_time;
    private String invoice_status;
    private String guarantee_type;
    private String platform_id;
    private String platform_name;
    private String license_number;
    private String tax_num;
    private String enterprise_addr;
    private String enterprise_tel;
    private String enterprise_bankno;
    private String enterprise_bank_name;
    private String agent_phone;
    private String agent_email;
    private LocalDateTime release_credit_time;
    private String bid_category;
    private String extension;
    private String mask;
    private LocalDateTime ctime;
    private LocalDateTime mtime;

    public String getElg_id() {
        return elg_id;
    }

    public void setElg_id(String elg_id) {
        this.elg_id = elg_id;
    }

    public String getElg_order_id() {
        return elg_order_id;
    }

    public void setElg_order_id(String elg_order_id) {
        this.elg_order_id = elg_order_id;
    }

    public String getElg_status() {
        return elg_status;
    }

    public void setElg_status(String elg_status) {
        this.elg_status = elg_status;
    }

    public String getElg_org_id() {
        return elg_org_id;
    }

    public void setElg_org_id(String elg_org_id) {
        this.elg_org_id = elg_org_id;
    }

    public String getElg_org_name() {
        return elg_org_name;
    }

    public void setElg_org_name(String elg_org_name) {
        this.elg_org_name = elg_org_name;
    }

    public LocalDateTime getElg_apply_time() {
        return elg_apply_time;
    }

    public void setElg_apply_time(LocalDateTime elg_apply_time) {
        this.elg_apply_time = elg_apply_time;
    }

    public String getElg_encryptinfo() {
        return elg_encryptinfo;
    }

    public void setElg_encryptinfo(String elg_encryptinfo) {
        this.elg_encryptinfo = elg_encryptinfo;
    }

    public String getElg_envelope() {
        return elg_envelope;
    }

    public void setElg_envelope(String elg_envelope) {
        this.elg_envelope = elg_envelope;
    }

    public String getElg_encrypted_method() {
        return elg_encrypted_method;
    }

    public void setElg_encrypted_method(String elg_encrypted_method) {
        this.elg_encrypted_method = elg_encrypted_method;
    }

    public String getElg_envelop_encrypted_method() {
        return elg_envelop_encrypted_method;
    }

    public void setElg_envelop_encrypted_method(String elg_envelop_encrypted_method) {
        this.elg_envelop_encrypted_method = elg_envelop_encrypted_method;
    }

    public String getElg_user_cert() {
        return elg_user_cert;
    }

    public void setElg_user_cert(String elg_user_cert) {
        this.elg_user_cert = elg_user_cert;
    }

    public String getElg_user_id() {
        return elg_user_id;
    }

    public void setElg_user_id(String elg_user_id) {
        this.elg_user_id = elg_user_id;
    }

    public String getElg_url() {
        return elg_url;
    }

    public void setElg_url(String elg_url) {
        this.elg_url = elg_url;
    }

    public String getElg_error_message() {
        return elg_error_message;
    }

    public void setElg_error_message(String elg_error_message) {
        this.elg_error_message = elg_error_message;
    }

    public String getElg_company_id() {
        return elg_company_id;
    }

    public void setElg_company_id(String elg_company_id) {
        this.elg_company_id = elg_company_id;
    }

    public LocalDateTime getElg_push_trad_time() {
        return elg_push_trad_time;
    }

    public void setElg_push_trad_time(LocalDateTime elg_push_trad_time) {
        this.elg_push_trad_time = elg_push_trad_time;
    }

    public LocalDateTime getElg_out_elg_time() {
        return elg_out_elg_time;
    }

    public void setElg_out_elg_time(LocalDateTime elg_out_elg_time) {
        this.elg_out_elg_time = elg_out_elg_time;
    }

    public LocalDateTime getElg_pay_time() {
        return elg_pay_time;
    }

    public void setElg_pay_time(LocalDateTime elg_pay_time) {
        this.elg_pay_time = elg_pay_time;
    }

    public LocalDateTime getReceive_deadline() {
        return receive_deadline;
    }

    public void setReceive_deadline(LocalDateTime receive_deadline) {
        this.receive_deadline = receive_deadline;
    }

    public LocalDateTime getLast_pay_time() {
        return last_pay_time;
    }

    public void setLast_pay_time(LocalDateTime last_pay_time) {
        this.last_pay_time = last_pay_time;
    }

    public String getAccept_company() {
        return accept_company;
    }

    public void setAccept_company(String accept_company) {
        this.accept_company = accept_company;
    }

    public String getInvalided() {
        return invalided;
    }

    public void setInvalided(String invalided) {
        this.invalided = invalided;
    }

    public String getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(String invoice_type) {
        this.invoice_type = invoice_type;
    }

    public LocalDateTime getDecrypt_time() {
        return decrypt_time;
    }

    public void setDecrypt_time(LocalDateTime decrypt_time) {
        this.decrypt_time = decrypt_time;
    }

    public String getInvoice_status() {
        return invoice_status;
    }

    public void setInvoice_status(String invoice_status) {
        this.invoice_status = invoice_status;
    }

    public String getGuarantee_type() {
        return guarantee_type;
    }

    public void setGuarantee_type(String guarantee_type) {
        this.guarantee_type = guarantee_type;
    }

    public String getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(String platform_id) {
        this.platform_id = platform_id;
    }

    public String getPlatform_name() {
        return platform_name;
    }

    public void setPlatform_name(String platform_name) {
        this.platform_name = platform_name;
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public String getTax_num() {
        return tax_num;
    }

    public void setTax_num(String tax_num) {
        this.tax_num = tax_num;
    }

    public String getEnterprise_addr() {
        return enterprise_addr;
    }

    public void setEnterprise_addr(String enterprise_addr) {
        this.enterprise_addr = enterprise_addr;
    }

    public String getEnterprise_tel() {
        return enterprise_tel;
    }

    public void setEnterprise_tel(String enterprise_tel) {
        this.enterprise_tel = enterprise_tel;
    }

    public String getEnterprise_bankno() {
        return enterprise_bankno;
    }

    public void setEnterprise_bankno(String enterprise_bankno) {
        this.enterprise_bankno = enterprise_bankno;
    }

    public String getEnterprise_bank_name() {
        return enterprise_bank_name;
    }

    public void setEnterprise_bank_name(String enterprise_bank_name) {
        this.enterprise_bank_name = enterprise_bank_name;
    }

    public String getAgent_phone() {
        return agent_phone;
    }

    public void setAgent_phone(String agent_phone) {
        this.agent_phone = agent_phone;
    }

    public String getAgent_email() {
        return agent_email;
    }

    public void setAgent_email(String agent_email) {
        this.agent_email = agent_email;
    }

    public LocalDateTime getRelease_credit_time() {
        return release_credit_time;
    }

    public void setRelease_credit_time(LocalDateTime release_credit_time) {
        this.release_credit_time = release_credit_time;
    }

    public String getBid_category() {
        return bid_category;
    }

    public void setBid_category(String bid_category) {
        this.bid_category = bid_category;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
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
