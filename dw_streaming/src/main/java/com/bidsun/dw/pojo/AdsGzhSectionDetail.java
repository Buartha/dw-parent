package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className AdsGzhCaDetail
 * @description 标段明细表
 * @date 2021/6/1 8:45
 */
public class AdsGzhSectionDetail implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;

    private String section_code;
    private String section_name;
    private String business_type;
    private String platform_code;
    private String platform_name;
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
    private String bidder_org_code;
    private String bidder_code;
    private String bidder_name;
    private Integer guarantee_type;
    private Integer is_exception;
    private LocalDateTime guarantee_apply_time;
    private LocalDateTime guarantee_approve_time;
    private LocalDateTime guarantee_effective_time;
    private LocalDateTime guarantee_invalid_time;
    private LocalDateTime guarantee_submit_time;
    private BigDecimal guarantee_amount;
    private String guarantee_legal_code;
    private String guarantee_legal_name;
    private Integer payment_state;
    private String guarantee_name;
    private LocalDateTime evaluation_end_time;
    private LocalDateTime bid_open_time;
    private LocalDateTime notice_send_time;
    private LocalDateTime result_send_time;
    private Integer bid_section_count;
    private BigDecimal contract_reckon_price;
    private BigDecimal trade_amount;
    private BigDecimal margin_amount;
    private BigDecimal bid_price;
    private Integer is_win_bidder;
    private Integer is_open_valid;
    private String apply_type;
    private String marginpayform;
    private String sectionclassifycodeone;
    private String sectionclassifycodetwo;
    private String projecttypeone;
    private String projecttypetwo;
    private String extention;
    private Integer mask;
    private LocalDateTime ctime;
    private LocalDateTime mtime;

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

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
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

    public String getBidder_org_code() {
        return bidder_org_code;
    }

    public void setBidder_org_code(String bidder_org_code) {
        this.bidder_org_code = bidder_org_code;
    }

    public String getBidder_code() {
        return bidder_code;
    }

    public void setBidder_code(String bidder_code) {
        this.bidder_code = bidder_code;
    }

    public String getBidder_name() {
        return bidder_name;
    }

    public void setBidder_name(String bidder_name) {
        this.bidder_name = bidder_name;
    }

    public Integer getGuarantee_type() {
        return guarantee_type;
    }

    public void setGuarantee_type(Integer guarantee_type) {
        this.guarantee_type = guarantee_type;
    }

    public Integer getIs_exception() {
        return is_exception;
    }

    public void setIs_exception(Integer is_exception) {
        this.is_exception = is_exception;
    }

    public LocalDateTime getGuarantee_apply_time() {
        return guarantee_apply_time;
    }

    public void setGuarantee_apply_time(LocalDateTime guarantee_apply_time) {
        this.guarantee_apply_time = guarantee_apply_time;
    }

    public LocalDateTime getGuarantee_approve_time() {
        return guarantee_approve_time;
    }

    public void setGuarantee_approve_time(LocalDateTime guarantee_approve_time) {
        this.guarantee_approve_time = guarantee_approve_time;
    }

    public LocalDateTime getGuarantee_effective_time() {
        return guarantee_effective_time;
    }

    public void setGuarantee_effective_time(LocalDateTime guarantee_effective_time) {
        this.guarantee_effective_time = guarantee_effective_time;
    }

    public LocalDateTime getGuarantee_invalid_time() {
        return guarantee_invalid_time;
    }

    public void setGuarantee_invalid_time(LocalDateTime guarantee_invalid_time) {
        this.guarantee_invalid_time = guarantee_invalid_time;
    }

    public LocalDateTime getGuarantee_submit_time() {
        return guarantee_submit_time;
    }

    public void setGuarantee_submit_time(LocalDateTime guarantee_submit_time) {
        this.guarantee_submit_time = guarantee_submit_time;
    }

    public BigDecimal getGuarantee_amount() {
        return guarantee_amount;
    }

    public void setGuarantee_amount(BigDecimal guarantee_amount) {
        this.guarantee_amount = guarantee_amount;
    }

    public String getGuarantee_legal_code() {
        return guarantee_legal_code;
    }

    public void setGuarantee_legal_code(String guarantee_legal_code) {
        this.guarantee_legal_code = guarantee_legal_code;
    }

    public String getGuarantee_legal_name() {
        return guarantee_legal_name;
    }

    public void setGuarantee_legal_name(String guarantee_legal_name) {
        this.guarantee_legal_name = guarantee_legal_name;
    }

    public Integer getPayment_state() {
        return payment_state;
    }

    public void setPayment_state(Integer payment_state) {
        this.payment_state = payment_state;
    }

    public String getGuarantee_name() {
        return guarantee_name;
    }

    public void setGuarantee_name(String guarantee_name) {
        this.guarantee_name = guarantee_name;
    }

    public LocalDateTime getEvaluation_end_time() {
        return evaluation_end_time;
    }

    public void setEvaluation_end_time(LocalDateTime evaluation_end_time) {
        this.evaluation_end_time = evaluation_end_time;
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

    public Integer getBid_section_count() {
        return bid_section_count;
    }

    public void setBid_section_count(Integer bid_section_count) {
        this.bid_section_count = bid_section_count;
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

    public BigDecimal getMargin_amount() {
        return margin_amount;
    }

    public void setMargin_amount(BigDecimal margin_amount) {
        this.margin_amount = margin_amount;
    }

    public BigDecimal getBid_price() {
        return bid_price;
    }

    public void setBid_price(BigDecimal bid_price) {
        this.bid_price = bid_price;
    }

    public Integer getIs_win_bidder() {
        return is_win_bidder;
    }

    public void setIs_win_bidder(Integer is_win_bidder) {
        this.is_win_bidder = is_win_bidder;
    }

    public Integer getIs_open_valid() {
        return is_open_valid;
    }

    public void setIs_open_valid(Integer is_open_valid) {
        this.is_open_valid = is_open_valid;
    }

    public String getApply_type() {
        return apply_type;
    }

    public void setApply_type(String apply_type) {
        this.apply_type = apply_type;
    }

    public String getMarginpayform() {
        return marginpayform;
    }

    public void setMarginpayform(String marginpayform) {
        this.marginpayform = marginpayform;
    }

    public String getSectionclassifycodeone() {
        return sectionclassifycodeone;
    }

    public void setSectionclassifycodeone(String sectionclassifycodeone) {
        this.sectionclassifycodeone = sectionclassifycodeone;
    }

    public String getSectionclassifycodetwo() {
        return sectionclassifycodetwo;
    }

    public void setSectionclassifycodetwo(String sectionclassifycodetwo) {
        this.sectionclassifycodetwo = sectionclassifycodetwo;
    }

    public String getProjecttypeone() {
        return projecttypeone;
    }

    public void setProjecttypeone(String projecttypeone) {
        this.projecttypeone = projecttypeone;
    }

    public String getProjecttypetwo() {
        return projecttypetwo;
    }

    public void setProjecttypetwo(String projecttypetwo) {
        this.projecttypetwo = projecttypetwo;
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
