package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className jyzms
 * @description TODO
 * @date 2021/6/1 8:45
 */
public class ZFCGJiaoYiZhengMingShu implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String purchaseProjectCode;
    private String purchaseSectionCode;
    private String sectionName;
    private String winBidderName;
    private String winBidderCode;
    private String UNION_BIDDER_IF;
    private String UNION_BIDDER_INFO;
    private BigDecimal bidAmount;
    private String bidCurrency;
    private String priceUnit;
    private String certNo;
    private LocalDateTime certDate;
    private String traAgencyName;
    private String traAgencyCode;
    private Integer WIN_bidder_ORDER;
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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWinBidderName() {
        return winBidderName;
    }

    public void setWinBidderName(String winBidderName) {
        this.winBidderName = winBidderName;
    }

    public String getWinBidderCode() {
        return winBidderCode;
    }

    public void setWinBidderCode(String winBidderCode) {
        this.winBidderCode = winBidderCode;
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

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getBidCurrency() {
        return bidCurrency;
    }

    public void setBidCurrency(String bidCurrency) {
        this.bidCurrency = bidCurrency;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public LocalDateTime getCertDate() {
        return certDate;
    }

    public void setCertDate(LocalDateTime certDate) {
        this.certDate = certDate;
    }

    public String getTraAgencyName() {
        return traAgencyName;
    }

    public void setTraAgencyName(String traAgencyName) {
        this.traAgencyName = traAgencyName;
    }

    public String getTraAgencyCode() {
        return traAgencyCode;
    }

    public void setTraAgencyCode(String traAgencyCode) {
        this.traAgencyCode = traAgencyCode;
    }

    public Integer getWIN_bidder_ORDER() {
        return WIN_bidder_ORDER;
    }

    public void setWIN_bidder_ORDER(Integer WIN_bidder_ORDER) {
        this.WIN_bidder_ORDER = WIN_bidder_ORDER;
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
