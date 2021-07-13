package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className tbyqs
 * @description TODO
 * @LocalDateTime 2021/6/1 8:45
 */
public class GCJSTouBiaoYaoQingShu implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String tenderProjectCode;
    private String bidSectionCode;
    private String unifiedDealCode;
    private String bidQualification;
    private LocalDateTime tenderDocGetTime;
    private String tenderDocGetMethod;
    private LocalDateTime bidDocReferEndTime;
    private String bidDocReferMethod;
    private LocalDateTime bidInviteEndTime;
    private LocalDateTime bidInviteIssueTime;
    private String bidInviteIssueContent;
    private String bulletinDuty;
    private String bidInviteIssueInfo;
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

    public String getBidSectionCode() {
        return bidSectionCode;
    }

    public void setBidSectionCode(String bidSectionCode) {
        this.bidSectionCode = bidSectionCode;
    }

    public String getUnifiedDealCode() {
        return unifiedDealCode;
    }

    public void setUnifiedDealCode(String unifiedDealCode) {
        this.unifiedDealCode = unifiedDealCode;
    }

    public String getBidQualification() {
        return bidQualification;
    }

    public void setBidQualification(String bidQualification) {
        this.bidQualification = bidQualification;
    }

    public LocalDateTime getTenderDocGetTime() {
        return tenderDocGetTime;
    }

    public void setTenderDocGetTime(LocalDateTime tenderDocGetTime) {
        this.tenderDocGetTime = tenderDocGetTime;
    }

    public String getTenderDocGetMethod() {
        return tenderDocGetMethod;
    }

    public void setTenderDocGetMethod(String tenderDocGetMethod) {
        this.tenderDocGetMethod = tenderDocGetMethod;
    }

    public LocalDateTime getBidDocReferEndTime() {
        return bidDocReferEndTime;
    }

    public void setBidDocReferEndTime(LocalDateTime bidDocReferEndTime) {
        this.bidDocReferEndTime = bidDocReferEndTime;
    }

    public String getBidDocReferMethod() {
        return bidDocReferMethod;
    }

    public void setBidDocReferMethod(String bidDocReferMethod) {
        this.bidDocReferMethod = bidDocReferMethod;
    }

    public LocalDateTime getBidInviteEndTime() {
        return bidInviteEndTime;
    }

    public void setBidInviteEndTime(LocalDateTime bidInviteEndTime) {
        this.bidInviteEndTime = bidInviteEndTime;
    }

    public LocalDateTime getBidInviteIssueTime() {
        return bidInviteIssueTime;
    }

    public void setBidInviteIssueTime(LocalDateTime bidInviteIssueTime) {
        this.bidInviteIssueTime = bidInviteIssueTime;
    }

    public String getBidInviteIssueContent() {
        return bidInviteIssueContent;
    }

    public void setBidInviteIssueContent(String bidInviteIssueContent) {
        this.bidInviteIssueContent = bidInviteIssueContent;
    }

    public String getBulletinDuty() {
        return bulletinDuty;
    }

    public void setBulletinDuty(String bulletinDuty) {
        this.bulletinDuty = bulletinDuty;
    }

    public String getBidInviteIssueInfo() {
        return bidInviteIssueInfo;
    }

    public void setBidInviteIssueInfo(String bidInviteIssueInfo) {
        this.bidInviteIssueInfo = bidInviteIssueInfo;
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
