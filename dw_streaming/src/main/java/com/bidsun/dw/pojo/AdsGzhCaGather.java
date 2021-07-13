package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className AdsGzhCaDetail
 * @description ca汇总表
 * @date 2021/6/1 8:45
 */
public class AdsGzhCaGather implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String platform_code;
    private String platform_name;
    private Integer entrance_project_count;
    private Integer bid_opening_count;
    private Integer bid_evaluation_count;
    private BigDecimal trade_amount;
    private Integer trade_count;
    private BigDecimal save_amount;
    private Integer bid_count;
    private BigDecimal contract_estimated_amount;
    private Integer trade_days;
    private Integer service_bidding_enterprise_count;
    private BigDecimal release_pressure_enterprise_capital;
    private Integer financial_institutions_count;
    private Integer elg_opening_count;
    private Integer elg_insurance_opening_count;
    private Integer elg_bank_opening_count;
    private Integer elg_guarantee_opening_count;
    private Integer account_interchange_count;
    private Integer mobile_ca_usage_count;
    private Integer signature_code_login_count;
    private Integer signature_count;
    private Integer encrypt_count;
    private Integer decrypt_count;
    private Integer ca_send_count;
    private Integer visit_count;
    private Integer subscribe_count;
    private Integer favorite_count;
    private Integer chain_upload_project_app_count;
    private Integer chain_upload_data_count;
    private Integer chain_upload_project_count;
    private Integer error_count;
    private Integer proces_count;
    private Integer repair_count;
    private Double repair_ratio;
    private Double correct_score;
    private Double timely_score;
    private Double compelete_score;
    private Double repair_score;
    private Double compliance_score;
    private Double entire_score;
    private Double day_end_ratio;
    private Integer share_decrypt_count;
    private LocalDateTime statistic_date;
    private String extension;
    private Integer mask;
    private LocalDateTime ctime;
    private LocalDateTime mtime;

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

    public Integer getEntrance_project_count() {
        return entrance_project_count;
    }

    public void setEntrance_project_count(Integer entrance_project_count) {
        this.entrance_project_count = entrance_project_count;
    }

    public Integer getBid_opening_count() {
        return bid_opening_count;
    }

    public void setBid_opening_count(Integer bid_opening_count) {
        this.bid_opening_count = bid_opening_count;
    }

    public Integer getBid_evaluation_count() {
        return bid_evaluation_count;
    }

    public void setBid_evaluation_count(Integer bid_evaluation_count) {
        this.bid_evaluation_count = bid_evaluation_count;
    }

    public BigDecimal getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(BigDecimal trade_amount) {
        this.trade_amount = trade_amount;
    }

    public Integer getTrade_count() {
        return trade_count;
    }

    public void setTrade_count(Integer trade_count) {
        this.trade_count = trade_count;
    }

    public BigDecimal getSave_amount() {
        return save_amount;
    }

    public void setSave_amount(BigDecimal save_amount) {
        this.save_amount = save_amount;
    }

    public Integer getBid_count() {
        return bid_count;
    }

    public void setBid_count(Integer bid_count) {
        this.bid_count = bid_count;
    }

    public BigDecimal getContract_estimated_amount() {
        return contract_estimated_amount;
    }

    public void setContract_estimated_amount(BigDecimal contract_estimated_amount) {
        this.contract_estimated_amount = contract_estimated_amount;
    }

    public Integer getTrade_days() {
        return trade_days;
    }

    public void setTrade_days(Integer trade_days) {
        this.trade_days = trade_days;
    }

    public Integer getService_bidding_enterprise_count() {
        return service_bidding_enterprise_count;
    }

    public void setService_bidding_enterprise_count(Integer service_bidding_enterprise_count) {
        this.service_bidding_enterprise_count = service_bidding_enterprise_count;
    }

    public BigDecimal getRelease_pressure_enterprise_capital() {
        return release_pressure_enterprise_capital;
    }

    public void setRelease_pressure_enterprise_capital(BigDecimal release_pressure_enterprise_capital) {
        this.release_pressure_enterprise_capital = release_pressure_enterprise_capital;
    }

    public Integer getFinancial_institutions_count() {
        return financial_institutions_count;
    }

    public void setFinancial_institutions_count(Integer financial_institutions_count) {
        this.financial_institutions_count = financial_institutions_count;
    }

    public Integer getElg_opening_count() {
        return elg_opening_count;
    }

    public void setElg_opening_count(Integer elg_opening_count) {
        this.elg_opening_count = elg_opening_count;
    }

    public Integer getElg_insurance_opening_count() {
        return elg_insurance_opening_count;
    }

    public void setElg_insurance_opening_count(Integer elg_insurance_opening_count) {
        this.elg_insurance_opening_count = elg_insurance_opening_count;
    }

    public Integer getElg_bank_opening_count() {
        return elg_bank_opening_count;
    }

    public void setElg_bank_opening_count(Integer elg_bank_opening_count) {
        this.elg_bank_opening_count = elg_bank_opening_count;
    }

    public Integer getElg_guarantee_opening_count() {
        return elg_guarantee_opening_count;
    }

    public void setElg_guarantee_opening_count(Integer elg_guarantee_opening_count) {
        this.elg_guarantee_opening_count = elg_guarantee_opening_count;
    }

    public Integer getAccount_interchange_count() {
        return account_interchange_count;
    }

    public void setAccount_interchange_count(Integer account_interchange_count) {
        this.account_interchange_count = account_interchange_count;
    }

    public Integer getMobile_ca_usage_count() {
        return mobile_ca_usage_count;
    }

    public void setMobile_ca_usage_count(Integer mobile_ca_usage_count) {
        this.mobile_ca_usage_count = mobile_ca_usage_count;
    }

    public Integer getSignature_code_login_count() {
        return signature_code_login_count;
    }

    public void setSignature_code_login_count(Integer signature_code_login_count) {
        this.signature_code_login_count = signature_code_login_count;
    }

    public Integer getSignature_count() {
        return signature_count;
    }

    public void setSignature_count(Integer signature_count) {
        this.signature_count = signature_count;
    }

    public Integer getEncrypt_count() {
        return encrypt_count;
    }

    public void setEncrypt_count(Integer encrypt_count) {
        this.encrypt_count = encrypt_count;
    }

    public Integer getDecrypt_count() {
        return decrypt_count;
    }

    public void setDecrypt_count(Integer decrypt_count) {
        this.decrypt_count = decrypt_count;
    }

    public Integer getCa_send_count() {
        return ca_send_count;
    }

    public void setCa_send_count(Integer ca_send_count) {
        this.ca_send_count = ca_send_count;
    }

    public Integer getVisit_count() {
        return visit_count;
    }

    public void setVisit_count(Integer visit_count) {
        this.visit_count = visit_count;
    }

    public Integer getSubscribe_count() {
        return subscribe_count;
    }

    public void setSubscribe_count(Integer subscribe_count) {
        this.subscribe_count = subscribe_count;
    }

    public Integer getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(Integer favorite_count) {
        this.favorite_count = favorite_count;
    }

    public Integer getChain_upload_project_app_count() {
        return chain_upload_project_app_count;
    }

    public void setChain_upload_project_app_count(Integer chain_upload_project_app_count) {
        this.chain_upload_project_app_count = chain_upload_project_app_count;
    }

    public Integer getChain_upload_data_count() {
        return chain_upload_data_count;
    }

    public void setChain_upload_data_count(Integer chain_upload_data_count) {
        this.chain_upload_data_count = chain_upload_data_count;
    }

    public Integer getChain_upload_project_count() {
        return chain_upload_project_count;
    }

    public void setChain_upload_project_count(Integer chain_upload_project_count) {
        this.chain_upload_project_count = chain_upload_project_count;
    }

    public Integer getError_count() {
        return error_count;
    }

    public void setError_count(Integer error_count) {
        this.error_count = error_count;
    }

    public Integer getProces_count() {
        return proces_count;
    }

    public void setProces_count(Integer proces_count) {
        this.proces_count = proces_count;
    }

    public Integer getRepair_count() {
        return repair_count;
    }

    public void setRepair_count(Integer repair_count) {
        this.repair_count = repair_count;
    }

    public Double getRepair_ratio() {
        return repair_ratio;
    }

    public void setRepair_ratio(Double repair_ratio) {
        this.repair_ratio = repair_ratio;
    }

    public Double getCorrect_score() {
        return correct_score;
    }

    public void setCorrect_score(Double correct_score) {
        this.correct_score = correct_score;
    }

    public Double getTimely_score() {
        return timely_score;
    }

    public void setTimely_score(Double timely_score) {
        this.timely_score = timely_score;
    }

    public Double getCompelete_score() {
        return compelete_score;
    }

    public void setCompelete_score(Double compelete_score) {
        this.compelete_score = compelete_score;
    }

    public Double getRepair_score() {
        return repair_score;
    }

    public void setRepair_score(Double repair_score) {
        this.repair_score = repair_score;
    }

    public Double getCompliance_score() {
        return compliance_score;
    }

    public void setCompliance_score(Double compliance_score) {
        this.compliance_score = compliance_score;
    }

    public Double getEntire_score() {
        return entire_score;
    }

    public void setEntire_score(Double entire_score) {
        this.entire_score = entire_score;
    }

    public Double getDay_end_ratio() {
        return day_end_ratio;
    }

    public void setDay_end_ratio(Double day_end_ratio) {
        this.day_end_ratio = day_end_ratio;
    }

    public Integer getShare_decrypt_count() {
        return share_decrypt_count;
    }

    public void setShare_decrypt_count(Integer share_decrypt_count) {
        this.share_decrypt_count = share_decrypt_count;
    }

    public LocalDateTime getStatistic_date() {
        return statistic_date;
    }

    public void setStatistic_date(LocalDateTime statistic_date) {
        this.statistic_date = statistic_date;
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
