package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Wangyg
 * @className bd
 * @description TODO
 * @date 2021/6/1 8:45
 */
public class ZFCGBiaoDuan implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String purchaseProjectCode;
    private String purchaseSectionCode;
    private String sectionName;
    private String Tenderprojectcode;
    private Integer tenderTime;
    private String FormersectionName;
    private String sectionContent;
    private BigDecimal contractReckonPrice;
    private String priceUnit;
    private BigDecimal programBudget;
    private String budgetCurrency;
    private String unitBudget;
    private String otherProgramBudget;
    private String regionCode;
    private String traPlaceCode;
    private String bidQualification;
    private String sectionAddress;
    private Object PURCHASE_info;
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

    public String getTenderprojectcode() {
        return Tenderprojectcode;
    }

    public void setTenderprojectcode(String tenderprojectcode) {
        Tenderprojectcode = tenderprojectcode;
    }

    public Integer getTenderTime() {
        return tenderTime;
    }

    public void setTenderTime(Integer tenderTime) {
        this.tenderTime = tenderTime;
    }

    public String getFormersectionName() {
        return FormersectionName;
    }

    public void setFormersectionName(String formersectionName) {
        FormersectionName = formersectionName;
    }

    public String getSectionContent() {
        return sectionContent;
    }

    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }

    public BigDecimal getContractReckonPrice() {
        return contractReckonPrice;
    }

    public void setContractReckonPrice(BigDecimal contractReckonPrice) {
        this.contractReckonPrice = contractReckonPrice;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public BigDecimal getProgramBudget() {
        return programBudget;
    }

    public void setProgramBudget(BigDecimal programBudget) {
        this.programBudget = programBudget;
    }

    public String getBudgetCurrency() {
        return budgetCurrency;
    }

    public void setBudgetCurrency(String budgetCurrency) {
        this.budgetCurrency = budgetCurrency;
    }

    public String getUnitBudget() {
        return unitBudget;
    }

    public void setUnitBudget(String unitBudget) {
        this.unitBudget = unitBudget;
    }

    public String getOtherProgramBudget() {
        return otherProgramBudget;
    }

    public void setOtherProgramBudget(String otherProgramBudget) {
        this.otherProgramBudget = otherProgramBudget;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getTraPlaceCode() {
        return traPlaceCode;
    }

    public void setTraPlaceCode(String traPlaceCode) {
        this.traPlaceCode = traPlaceCode;
    }

    public String getBidQualification() {
        return bidQualification;
    }

    public void setBidQualification(String bidQualification) {
        this.bidQualification = bidQualification;
    }

    public String getSectionAddress() {
        return sectionAddress;
    }

    public void setSectionAddress(String sectionAddress) {
        this.sectionAddress = sectionAddress;
    }

    public Object getPURCHASE_info() {
        return PURCHASE_info;
    }

    public void setPURCHASE_info(Object PURCHASE_info) {
        this.PURCHASE_info = PURCHASE_info;
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
