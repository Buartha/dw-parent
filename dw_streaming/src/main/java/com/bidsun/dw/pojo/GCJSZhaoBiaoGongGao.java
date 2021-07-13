package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Array;
import java.sql.Date;

/**
 * @author Niuxy
 * @className Zhaobgg
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSZhaoBiaoGongGao  implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String unifiedDealCodes;
    private String tenderProjectCode;
    private String sectionCode;
    private String noticeName;
    private String noticeContent;
    private String url;
    private String noticeMedia;
    private String tenderMode;
    private String qualType;
    private String tenderContent;
    private String bulletinType;
    private String noticeNature;
    private String QUAL_TYPE;
    private String docSellType;
    private String noticeSendTime;
    private int noticeBidNum;
    private String bidOpenMethod;
    private String docGetStartTime;
    private String docGetEndTime;
    private String tenderDocGetMethod;
    private String bidDocReferEndTime;
    private String bidDocReferMethod;
    private String TENDER_FILE;
    private String TENDER_FILE_DATA;
    //private Array BID_INFO;
    //private Array docInfo;
    private String PLATFORM_NAME;
    private String PLATFORM_CODE;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;

  /*  public String getPid() {
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

    public String getUnifiedDealCodes() {
        return unifiedDealCodes;
    }

    public void setUnifiedDealCodes(String unifiedDealCodes) {
        this.unifiedDealCodes = unifiedDealCodes;
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

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNoticeMedia() {
        return noticeMedia;
    }

    public void setNoticeMedia(String noticeMedia) {
        this.noticeMedia = noticeMedia;
    }

    public String getTenderMode() {
        return tenderMode;
    }

    public void setTenderMode(String tenderMode) {
        this.tenderMode = tenderMode;
    }

    public String getQualType() {
        return qualType;
    }

    public void setQualType(String qualType) {
        this.qualType = qualType;
    }

    public String getTenderContent() {
        return tenderContent;
    }

    public void setTenderContent(String tenderContent) {
        this.tenderContent = tenderContent;
    }

    public String getBulletinType() {
        return bulletinType;
    }

    public void setBulletinType(String bulletinType) {
        this.bulletinType = bulletinType;
    }

    public String getNoticeNature() {
        return noticeNature;
    }

    public void setNoticeNature(String noticeNature) {
        this.noticeNature = noticeNature;
    }

    public String getQUAL_TYPE() {
        return QUAL_TYPE;
    }

    public void setQUAL_TYPE(String QUAL_TYPE) {
        this.QUAL_TYPE = QUAL_TYPE;
    }

    public String getDocSellType() {
        return docSellType;
    }

    public void setDocSellType(String docSellType) {
        this.docSellType = docSellType;
    }

    public String getNoticeSendTime() {
        return noticeSendTime;
    }

    public void setNoticeSendTime(String noticeSendTime) {
        this.noticeSendTime = noticeSendTime;
    }

    public int getNoticeBidNum() {
        return noticeBidNum;
    }

    public void setNoticeBidNum(int noticeBidNum) {
        this.noticeBidNum = noticeBidNum;
    }

    public String getBidOpenMethod() {
        return bidOpenMethod;
    }

    public void setBidOpenMethod(String bidOpenMethod) {
        this.bidOpenMethod = bidOpenMethod;
    }

    public Date getDocGetStartTime() {
        return docGetStartTime;
    }

    public void setDocGetStartTime(Date docGetStartTime) {
        this.docGetStartTime = docGetStartTime;
    }

    public Date getDocGetEndTime() {
        return docGetEndTime;
    }

    public void setDocGetEndTime(Date docGetEndTime) {
        this.docGetEndTime = docGetEndTime;
    }

    public String getTenderDocGetMethod() {
        return tenderDocGetMethod;
    }

    public void setTenderDocGetMethod(String tenderDocGetMethod) {
        this.tenderDocGetMethod = tenderDocGetMethod;
    }

    public Date getBidDocReferEndTime() {
        return bidDocReferEndTime;
    }

    public void setBidDocReferEndTime(Date bidDocReferEndTime) {
        this.bidDocReferEndTime = bidDocReferEndTime;
    }

    public String getBidDocReferMethod() {
        return bidDocReferMethod;
    }

    public void setBidDocReferMethod(String bidDocReferMethod) {
        this.bidDocReferMethod = bidDocReferMethod;
    }

    public String getTENDER_FILE() {
        return TENDER_FILE;
    }

    public void setTENDER_FILE(String TENDER_FILE) {
        this.TENDER_FILE = TENDER_FILE;
    }

    public String getTENDER_FILE_DATA() {
        return TENDER_FILE_DATA;
    }

    public void setTENDER_FILE_DATA(String TENDER_FILE_DATA) {
        this.TENDER_FILE_DATA = TENDER_FILE_DATA;
    }

   *//* public Array getBID_INFO() {
        return BID_INFO;
    }

    public void setBID_INFO(Array BID_INFO) {
        this.BID_INFO = BID_INFO;
    }

    public Array getDocInfo() {
        return docInfo;
    }

    public void setDocInfo(Array docInfo) {
        this.docInfo = docInfo;
    }*//*

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

*/
}
