package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className AdsGzhCaDetail
 * @description 标段汇总表
 * @date 2021/6/1 8:45
 */
public class AdsGzhSectionGather implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;

    private String platform_code;
    private String platform_name;
    private String section_code;
    private String section_name;
    private Integer business_type;
    private String tender_project_code;
    private String tender_project_name;
    private String project_code;
    private String project_name;
    private Integer industries_type;
    private Integer tender_mode;
    private String tenderer_code;
    private String tenderer_name;
    private String tender_agency_code;
    private String tender_agency_name;
    private String sectionclassifycodetwo;
    private String projecttypetwo;
    private LocalDateTime bid_evaluation_end_time;
    private LocalDateTime bid_open_time;
    private LocalDateTime notice_send_time;
    private LocalDateTime result_send_time;
    private Integer is_exception;
    private BigDecimal contract_reckon_price;
    private BigDecimal trade_amount;
    private BigDecimal bid_count;
    private Integer candidate_count;
    private Integer win_count;
    private Integer bid_section_count;
    private BigDecimal elg_opening_amount;
    private Integer elg_opening_count;
    private Integer service_bidding_enterprise_count;
    private String apply_type;
    private Integer trade_days;
    private Integer trade_count;
    private Integer open_count;
    private Integer evaluation_count;
    private Integer exception_count;
    private BigDecimal save_amount;
    private double save_ratio;
    private Integer entrance_project_count;
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

    public Integer getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(Integer business_type) {
        this.business_type = business_type;
    }

    public String getTender_project_code() {
        return tender_project_code;
    }

    public void setTender_project_code(String tender_project_code) {
        this.tender_project_code = tender_project_code;
    }

    public String getTender_project_name() {
        return tender_project_name;
    }

    public void setTender_project_name(String tender_project_name) {
        this.tender_project_name = tender_project_name;
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

    public Integer getIndustries_type() {
        return industries_type;
    }

    public void setIndustries_type(Integer industries_type) {
        this.industries_type = industries_type;
    }

    public Integer getTender_mode() {
        return tender_mode;
    }

    public void setTender_mode(Integer tender_mode) {
        this.tender_mode = tender_mode;
    }

    public String getTenderer_code() {
        return tenderer_code;
    }

    public void setTenderer_code(String tenderer_code) {
        this.tenderer_code = tenderer_code;
    }

    public String getTenderer_name() {
        return tenderer_name;
    }

    public void setTenderer_name(String tenderer_name) {
        this.tenderer_name = tenderer_name;
    }

    public String getTender_agency_code() {
        return tender_agency_code;
    }

    public void setTender_agency_code(String tender_agency_code) {
        this.tender_agency_code = tender_agency_code;
    }

    public String getTender_agency_name() {
        return tender_agency_name;
    }

    public void setTender_agency_name(String tender_agency_name) {
        this.tender_agency_name = tender_agency_name;
    }

    public String getSectionclassifycodetwo() {
        return sectionclassifycodetwo;
    }

    public void setSectionclassifycodetwo(String sectionclassifycodetwo) {
        this.sectionclassifycodetwo = sectionclassifycodetwo;
    }

    public String getProjecttypetwo() {
        return projecttypetwo;
    }

    public void setProjecttypetwo(String projecttypetwo) {
        this.projecttypetwo = projecttypetwo;
    }

    public LocalDateTime getBid_evaluation_end_time() {
        return bid_evaluation_end_time;
    }

    public void setBid_evaluation_end_time(LocalDateTime bid_evaluation_end_time) {
        this.bid_evaluation_end_time = bid_evaluation_end_time;
    }

    public LocalDateTime getBid_open_time() {
        return bid_open_time;
    }

    public void setBid_open_time(LocalDateTime bid_open_time) {
        this.bid_open_time = bid_open_time;
    }

    public LocalDateTime getNotice_send_time() {
        return notice_send_time;
    }

    public void setNotice_send_time(LocalDateTime notice_send_time) {
        this.notice_send_time = notice_send_time;
    }

    public LocalDateTime getResult_send_time() {
        return result_send_time;
    }

    public void setResult_send_time(LocalDateTime result_send_time) {
        this.result_send_time = result_send_time;
    }

    public Integer getIs_exception() {
        return is_exception;
    }

    public void setIs_exception(Integer is_exception) {
        this.is_exception = is_exception;
    }

    public BigDecimal getContract_reckon_price() {
        return contract_reckon_price;
    }

    public void setContract_reckon_price(BigDecimal contract_reckon_price) {
        this.contract_reckon_price = contract_reckon_price;
    }

    public BigDecimal getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(BigDecimal trade_amount) {
        this.trade_amount = trade_amount;
    }

    public BigDecimal getBid_count() {
        return bid_count;
    }

    public void setBid_count(BigDecimal bid_count) {
        this.bid_count = bid_count;
    }

    public Integer getCandidate_count() {
        return candidate_count;
    }

    public void setCandidate_count(Integer candidate_count) {
        this.candidate_count = candidate_count;
    }

    public Integer getWin_count() {
        return win_count;
    }

    public void setWin_count(Integer win_count) {
        this.win_count = win_count;
    }

    public Integer getBid_section_count() {
        return bid_section_count;
    }

    public void setBid_section_count(Integer bid_section_count) {
        this.bid_section_count = bid_section_count;
    }

    public BigDecimal getElg_opening_amount() {
        return elg_opening_amount;
    }

    public void setElg_opening_amount(BigDecimal elg_opening_amount) {
        this.elg_opening_amount = elg_opening_amount;
    }

    public Integer getElg_opening_count() {
        return elg_opening_count;
    }

    public void setElg_opening_count(Integer elg_opening_count) {
        this.elg_opening_count = elg_opening_count;
    }

    public Integer getService_bidding_enterprise_count() {
        return service_bidding_enterprise_count;
    }

    public void setService_bidding_enterprise_count(Integer service_bidding_enterprise_count) {
        this.service_bidding_enterprise_count = service_bidding_enterprise_count;
    }

    public String getApply_type() {
        return apply_type;
    }

    public void setApply_type(String apply_type) {
        this.apply_type = apply_type;
    }

    public Integer getTrade_days() {
        return trade_days;
    }

    public void setTrade_days(Integer trade_days) {
        this.trade_days = trade_days;
    }

    public Integer getTrade_count() {
        return trade_count;
    }

    public void setTrade_count(Integer trade_count) {
        this.trade_count = trade_count;
    }

    public Integer getOpen_count() {
        return open_count;
    }

    public void setOpen_count(Integer open_count) {
        this.open_count = open_count;
    }

    public Integer getEvaluation_count() {
        return evaluation_count;
    }

    public void setEvaluation_count(Integer evaluation_count) {
        this.evaluation_count = evaluation_count;
    }

    public Integer getException_count() {
        return exception_count;
    }

    public void setException_count(Integer exception_count) {
        this.exception_count = exception_count;
    }

    public BigDecimal getSave_amount() {
        return save_amount;
    }

    public void setSave_amount(BigDecimal save_amount) {
        this.save_amount = save_amount;
    }

    public double getSave_ratio() {
        return save_ratio;
    }

    public void setSave_ratio(double save_ratio) {
        this.save_ratio = save_ratio;
    }

    public Integer getEntrance_project_count() {
        return entrance_project_count;
    }

    public void setEntrance_project_count(Integer entrance_project_count) {
        this.entrance_project_count = entrance_project_count;
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
