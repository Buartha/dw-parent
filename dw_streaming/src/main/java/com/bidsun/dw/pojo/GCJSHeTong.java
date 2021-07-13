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
public class GCJSHeTong implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String tenderProjectCode;
    private String sectionCode;
    private String tendererCode;
    private String bidderCode;
    private String UNION_BIDDER_IF;
    private String UNION_BIDDER_INFO;
    private BigDecimal contractPrice;
    private String priceUnit;
    private String contractContent;
    private LocalDateTime signTime;
    private String unifiedDealCode;
    private String priceFormCode;
    private String otherContractPrice;
    private String tendererName;
    private String bidderName;
    private Integer WIN_bidder_ORDER;
    private BigDecimal settlePrice;
    private String priceCurrency;
    private Integer limiteTime;
    private String qualityRequire;
    private String performChangeContent;
    private LocalDateTime finishTime;
    private Integer actuallyPeriod;
    private String performInfo;
    private LocalDateTime submitTime;
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

    public String getTenderProjectCode() {
        return tenderProjectCode;
    }

    public void setTenderProjectCode(String tenderProjectCode) {
        this.tenderProjectCode = tenderProjectCode;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
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

    public String getUnifiedDealCode() {
        return unifiedDealCode;
    }

    public void setUnifiedDealCode(String unifiedDealCode) {
        this.unifiedDealCode = unifiedDealCode;
    }

    public String getPriceFormCode() {
        return priceFormCode;
    }

    public void setPriceFormCode(String priceFormCode) {
        this.priceFormCode = priceFormCode;
    }

    public String getOtherContractPrice() {
        return otherContractPrice;
    }

    public void setOtherContractPrice(String otherContractPrice) {
        this.otherContractPrice = otherContractPrice;
    }

    public String getTendererName() {
        return tendererName;
    }

    public void setTendererName(String tendererName) {
        this.tendererName = tendererName;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public Integer getWIN_bidder_ORDER() {
        return WIN_bidder_ORDER;
    }

    public void setWIN_bidder_ORDER(Integer WIN_bidder_ORDER) {
        this.WIN_bidder_ORDER = WIN_bidder_ORDER;
    }

    public BigDecimal getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        this.settlePrice = settlePrice;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public Integer getLimiteTime() {
        return limiteTime;
    }

    public void setLimiteTime(Integer limiteTime) {
        this.limiteTime = limiteTime;
    }

    public String getQualityRequire() {
        return qualityRequire;
    }

    public void setQualityRequire(String qualityRequire) {
        this.qualityRequire = qualityRequire;
    }

    public String getPerformChangeContent() {
        return performChangeContent;
    }

    public void setPerformChangeContent(String performChangeContent) {
        this.performChangeContent = performChangeContent;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getActuallyPeriod() {
        return actuallyPeriod;
    }

    public void setActuallyPeriod(Integer actuallyPeriod) {
        this.actuallyPeriod = actuallyPeriod;
    }

    public String getPerformInfo() {
        return performInfo;
    }

    public void setPerformInfo(String performInfo) {
        this.performInfo = performInfo;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
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
