package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className tbbzjjn
 * @description TODO
 * @date 2021/6/1 8:45
 */
public class ZFCGTouBiaoBaoZhengJinJiaoNa implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String purchaseProjectCode;
    private String purchaseSectionCode;
    private String bidderName;
    private String bidderOrgCode;
    private String UNION_BIDDER_IF;
    private String UNION_BIDDER_INFO;
    private String marginPayType;
    private String marginPayForm;
    private String accountName;
    private String accountCode;
    private BigDecimal marginPrice;
    private LocalDateTime marginPayTime;
    private LocalDateTime marginUseTime;
    private String guaranteeLegalName;
    private String guaranteeLegalCode;
    private BigDecimal creditTotal;
    private LocalDateTime guaranteeApplyTime;
    private LocalDateTime guaranteeApproveTime;
    private LocalDateTime guaranteeEffectiveTime;
    private LocalDateTime guaranteeInvalidTime;
    private LocalDateTime guaranteeSubmitTime;
    private BigDecimal guaranteeAmount;
    private String contractCurrency;
    private String paymentState;
    private String guaranteeName;
    private LocalDateTime transDate;
    private String guaranteeType;
    private String APPLY_TYPE;
    private String PLATFORM_NAME;
    private String PLATFORM_CODE;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProjectIdentifierCode() {
        return projectIdentifierCode;
    }

    public void setProjectIdentifierCode(String projectIdentifierCode) {
        this.projectIdentifierCode = projectIdentifierCode;
    }

    public String getObjectIdentifierCode() {
        return objectIdentifierCode;
    }

    public void setObjectIdentifierCode(String objectIdentifierCode) {
        this.objectIdentifierCode = objectIdentifierCode;
    }

    public String getPurchaseProjectCode() {
        return purchaseProjectCode;
    }

    public void setPurchaseProjectCode(String purchaseProjectCode) {
        this.purchaseProjectCode = purchaseProjectCode;
    }

    public String getPurchaseSectionCode() {
        return purchaseSectionCode;
    }

    public void setPurchaseSectionCode(String purchaseSectionCode) {
        this.purchaseSectionCode = purchaseSectionCode;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public String getBidderOrgCode() {
        return bidderOrgCode;
    }

    public void setBidderOrgCode(String bidderOrgCode) {
        this.bidderOrgCode = bidderOrgCode;
    }

    public String getUNION_BIDDER_IF() {
        return UNION_BIDDER_IF;
    }

    public void setUNION_BIDDER_IF(String UNION_BIDDER_IF) {
        this.UNION_BIDDER_IF = UNION_BIDDER_IF;
    }

    public String getUNION_BIDDER_INFO() {
        return UNION_BIDDER_INFO;
    }

    public void setUNION_BIDDER_INFO(String UNION_BIDDER_INFO) {
        this.UNION_BIDDER_INFO = UNION_BIDDER_INFO;
    }

    public String getMarginPayType() {
        return marginPayType;
    }

    public void setMarginPayType(String marginPayType) {
        this.marginPayType = marginPayType;
    }

    public String getMarginPayForm() {
        return marginPayForm;
    }

    public void setMarginPayForm(String marginPayForm) {
        this.marginPayForm = marginPayForm;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public BigDecimal getMarginPrice() {
        return marginPrice;
    }

    public void setMarginPrice(BigDecimal marginPrice) {
        this.marginPrice = marginPrice;
    }

    public LocalDateTime getMarginPayTime() {
        return marginPayTime;
    }

    public void setMarginPayTime(LocalDateTime marginPayTime) {
        this.marginPayTime = marginPayTime;
    }

    public LocalDateTime getMarginUseTime() {
        return marginUseTime;
    }

    public void setMarginUseTime(LocalDateTime marginUseTime) {
        this.marginUseTime = marginUseTime;
    }

    public String getGuaranteeLegalName() {
        return guaranteeLegalName;
    }

    public void setGuaranteeLegalName(String guaranteeLegalName) {
        this.guaranteeLegalName = guaranteeLegalName;
    }

    public String getGuaranteeLegalCode() {
        return guaranteeLegalCode;
    }

    public void setGuaranteeLegalCode(String guaranteeLegalCode) {
        this.guaranteeLegalCode = guaranteeLegalCode;
    }

    public BigDecimal getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(BigDecimal creditTotal) {
        this.creditTotal = creditTotal;
    }

    public LocalDateTime getGuaranteeApplyTime() {
        return guaranteeApplyTime;
    }

    public void setGuaranteeApplyTime(LocalDateTime guaranteeApplyTime) {
        this.guaranteeApplyTime = guaranteeApplyTime;
    }

    public LocalDateTime getGuaranteeApproveTime() {
        return guaranteeApproveTime;
    }

    public void setGuaranteeApproveTime(LocalDateTime guaranteeApproveTime) {
        this.guaranteeApproveTime = guaranteeApproveTime;
    }

    public LocalDateTime getGuaranteeEffectiveTime() {
        return guaranteeEffectiveTime;
    }

    public void setGuaranteeEffectiveTime(LocalDateTime guaranteeEffectiveTime) {
        this.guaranteeEffectiveTime = guaranteeEffectiveTime;
    }

    public LocalDateTime getGuaranteeInvalidTime() {
        return guaranteeInvalidTime;
    }

    public void setGuaranteeInvalidTime(LocalDateTime guaranteeInvalidTime) {
        this.guaranteeInvalidTime = guaranteeInvalidTime;
    }

    public LocalDateTime getGuaranteeSubmitTime() {
        return guaranteeSubmitTime;
    }

    public void setGuaranteeSubmitTime(LocalDateTime guaranteeSubmitTime) {
        this.guaranteeSubmitTime = guaranteeSubmitTime;
    }

    public BigDecimal getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    public String getContractCurrency() {
        return contractCurrency;
    }

    public void setContractCurrency(String contractCurrency) {
        this.contractCurrency = contractCurrency;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    public LocalDateTime getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDateTime transDate) {
        this.transDate = transDate;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getAPPLY_TYPE() {
        return APPLY_TYPE;
    }

    public void setAPPLY_TYPE(String APPLY_TYPE) {
        this.APPLY_TYPE = APPLY_TYPE;
    }

    public String getPLATFORM_NAME() {
        return PLATFORM_NAME;
    }

    public void setPLATFORM_NAME(String PLATFORM_NAME) {
        this.PLATFORM_NAME = PLATFORM_NAME;
    }

    public String getPLATFORM_CODE() {
        return PLATFORM_CODE;
    }

    public void setPLATFORM_CODE(String PLATFORM_CODE) {
        this.PLATFORM_CODE = PLATFORM_CODE;
    }

    public String getPLATFORM_DEPARTMENT() {
        return PLATFORM_DEPARTMENT;
    }

    public void setPLATFORM_DEPARTMENT(String PLATFORM_DEPARTMENT) {
        this.PLATFORM_DEPARTMENT = PLATFORM_DEPARTMENT;
    }

    public String getPLATFORM_RESPONSIBLE() {
        return PLATFORM_RESPONSIBLE;
    }

    public void setPLATFORM_RESPONSIBLE(String PLATFORM_RESPONSIBLE) {
        this.PLATFORM_RESPONSIBLE = PLATFORM_RESPONSIBLE;
    }

    public String getPLATFORM_RESPONSIBLE_PHONE() {
        return PLATFORM_RESPONSIBLE_PHONE;
    }

    public void setPLATFORM_RESPONSIBLE_PHONE(String PLATFORM_RESPONSIBLE_PHONE) {
        this.PLATFORM_RESPONSIBLE_PHONE = PLATFORM_RESPONSIBLE_PHONE;
    }

    public String getPLATFORM_RESPONSIBLE_UNIT() {
        return PLATFORM_RESPONSIBLE_UNIT;
    }

    public void setPLATFORM_RESPONSIBLE_UNIT(String PLATFORM_RESPONSIBLE_UNIT) {
        this.PLATFORM_RESPONSIBLE_UNIT = PLATFORM_RESPONSIBLE_UNIT;
    }

    public String getDATA_RESPONSIBLE_CODE() {
        return DATA_RESPONSIBLE_CODE;
    }

    public void setDATA_RESPONSIBLE_CODE(String DATA_RESPONSIBLE_CODE) {
        this.DATA_RESPONSIBLE_CODE = DATA_RESPONSIBLE_CODE;
    }

    public String getDATA_RESPONSIBLE() {
        return DATA_RESPONSIBLE;
    }

    public void setDATA_RESPONSIBLE(String DATA_RESPONSIBLE) {
        this.DATA_RESPONSIBLE = DATA_RESPONSIBLE;
    }

    public String getDATA_RESPONSIBLE_PHONE() {
        return DATA_RESPONSIBLE_PHONE;
    }

    public void setDATA_RESPONSIBLE_PHONE(String DATA_RESPONSIBLE_PHONE) {
        this.DATA_RESPONSIBLE_PHONE = DATA_RESPONSIBLE_PHONE;
    }
}
