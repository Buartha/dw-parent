package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className ht
 * @description TODO
 * @date 2021/6/1 8:45
 */
public class ZFCGHeTong implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String purchaseProjectCode;
    private String purchaseSectionCode;
    private String tendererCode;
    private String bidderCode;
    private String UNION_BIDDER_IF;
    private String UNION_BIDDER_INFO;
    private BigDecimal contractPrice;
    private String priceUnit;
    private String contractContent;
    private LocalDateTime signTime;
    private String PRICE_FORM_CODE;
    private BigDecimal CONTRACT_AMOUNT;
    private String CONTRACT_CURRENCY;
    private String CONTRACT_CURRENCYUNIT;
    private String UNIT_BID_PRICE;
    private String RATE_BID_PRICE;
    private String OTHER_BID_PRICE;
    private String purchaseProjectName;
    private String unifiedDealCode;
    private String purchaserName;
    private String supplierName;
    private String WIN_bidder_ORDER;
    private String currencyCode;
    private Integer contractTerm;
    private String contractName;
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

    public String getTendererCode() {
        return tendererCode;
    }

    public void setTendererCode(String tendererCode) {
        this.tendererCode = tendererCode;
    }

    public String getBidderCode() {
        return bidderCode;
    }

    public void setBidderCode(String bidderCode) {
        this.bidderCode = bidderCode;
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

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public LocalDateTime getSignTime() {
        return signTime;
    }

    public void setSignTime(LocalDateTime signTime) {
        this.signTime = signTime;
    }

    public String getPRICE_FORM_CODE() {
        return PRICE_FORM_CODE;
    }

    public void setPRICE_FORM_CODE(String PRICE_FORM_CODE) {
        this.PRICE_FORM_CODE = PRICE_FORM_CODE;
    }

    public BigDecimal getCONTRACT_AMOUNT() {
        return CONTRACT_AMOUNT;
    }

    public void setCONTRACT_AMOUNT(BigDecimal CONTRACT_AMOUNT) {
        this.CONTRACT_AMOUNT = CONTRACT_AMOUNT;
    }

    public String getCONTRACT_CURRENCY() {
        return CONTRACT_CURRENCY;
    }

    public void setCONTRACT_CURRENCY(String CONTRACT_CURRENCY) {
        this.CONTRACT_CURRENCY = CONTRACT_CURRENCY;
    }

    public String getCONTRACT_CURRENCYUNIT() {
        return CONTRACT_CURRENCYUNIT;
    }

    public void setCONTRACT_CURRENCYUNIT(String CONTRACT_CURRENCYUNIT) {
        this.CONTRACT_CURRENCYUNIT = CONTRACT_CURRENCYUNIT;
    }

    public String getUNIT_BID_PRICE() {
        return UNIT_BID_PRICE;
    }

    public void setUNIT_BID_PRICE(String UNIT_BID_PRICE) {
        this.UNIT_BID_PRICE = UNIT_BID_PRICE;
    }

    public String getRATE_BID_PRICE() {
        return RATE_BID_PRICE;
    }

    public void setRATE_BID_PRICE(String RATE_BID_PRICE) {
        this.RATE_BID_PRICE = RATE_BID_PRICE;
    }

    public String getOTHER_BID_PRICE() {
        return OTHER_BID_PRICE;
    }

    public void setOTHER_BID_PRICE(String OTHER_BID_PRICE) {
        this.OTHER_BID_PRICE = OTHER_BID_PRICE;
    }

    public String getPurchaseProjectName() {
        return purchaseProjectName;
    }

    public void setPurchaseProjectName(String purchaseProjectName) {
        this.purchaseProjectName = purchaseProjectName;
    }

    public String getUnifiedDealCode() {
        return unifiedDealCode;
    }

    public void setUnifiedDealCode(String unifiedDealCode) {
        this.unifiedDealCode = unifiedDealCode;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getWIN_bidder_ORDER() {
        return WIN_bidder_ORDER;
    }

    public void setWIN_bidder_ORDER(String WIN_bidder_ORDER) {
        this.WIN_bidder_ORDER = WIN_bidder_ORDER;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Integer contractTerm) {
        this.contractTerm = contractTerm;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
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
