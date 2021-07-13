package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Wangyg
 * @className pbbg
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSPingBiaoBaoGao implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String tenderProjectCode;
    private String sectionCode;
    private String evaluationContent;
  //  private LocalDateTime submitTime;
    private String judgeLeader;
    private String judgeName;
    private String judgeResult;
    private String unifiedDealCode;
    private String noticeName;
    private String bidFailureReasons;
    private String evaluationBidWitnessName;
    private String evaluationBidWitnessPhone;
    private String enteredEvalRoomMembers;
    private String enteredEvalRoomCode;
    private String enteredEvalRoomReason;
    private String evaluatingAddress;
    private String begiinTime;
    private String endTime;
    private String url;
    private String evaluatingType;
    private String isSetSimilarPer;
    private BigDecimal controlPrice;
    private BigDecimal bidEvaluationPrice;
    private String isSetSimilarPlus;
    private String noticefile;
    private String Noticefiledata;
    private String PLATFORM_NAME;
    private String PLATFORM_CODE;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;

    /*public String getPid() {
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

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public String getJudgeLeader() {
        return judgeLeader;
    }

    public void setJudgeLeader(String judgeLeader) {
        this.judgeLeader = judgeLeader;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    public String getJudgeResult() {
        return judgeResult;
    }

    public void setJudgeResult(String judgeResult) {
        this.judgeResult = judgeResult;
    }

    public String getUnifiedDealCode() {
        return unifiedDealCode;
    }

    public void setUnifiedDealCode(String unifiedDealCode) {
        this.unifiedDealCode = unifiedDealCode;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getBidFailureReasons() {
        return bidFailureReasons;
    }

    public void setBidFailureReasons(String bidFailureReasons) {
        this.bidFailureReasons = bidFailureReasons;
    }

    public String getEvaluationBidWitnessName() {
        return evaluationBidWitnessName;
    }

    public void setEvaluationBidWitnessName(String evaluationBidWitnessName) {
        this.evaluationBidWitnessName = evaluationBidWitnessName;
    }

    public String getEvaluationBidWitnessPhone() {
        return evaluationBidWitnessPhone;
    }

    public void setEvaluationBidWitnessPhone(String evaluationBidWitnessPhone) {
        this.evaluationBidWitnessPhone = evaluationBidWitnessPhone;
    }

    public String getEnteredEvalRoomMembers() {
        return enteredEvalRoomMembers;
    }

    public void setEnteredEvalRoomMembers(String enteredEvalRoomMembers) {
        this.enteredEvalRoomMembers = enteredEvalRoomMembers;
    }

    public String getEnteredEvalRoomCode() {
        return enteredEvalRoomCode;
    }

    public void setEnteredEvalRoomCode(String enteredEvalRoomCode) {
        this.enteredEvalRoomCode = enteredEvalRoomCode;
    }

    public String getEnteredEvalRoomReason() {
        return enteredEvalRoomReason;
    }

    public void setEnteredEvalRoomReason(String enteredEvalRoomReason) {
        this.enteredEvalRoomReason = enteredEvalRoomReason;
    }

    public String getEvaluatingAddress() {
        return evaluatingAddress;
    }

    public void setEvaluatingAddress(String evaluatingAddress) {
        this.evaluatingAddress = evaluatingAddress;
    }

    public LocalDateTime getBegiinTime() {
        return begiinTime;
    }

    public void setBegiinTime(LocalDateTime begiinTime) {
        this.begiinTime = begiinTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEvaluatingType() {
        return evaluatingType;
    }

    public void setEvaluatingType(String evaluatingType) {
        this.evaluatingType = evaluatingType;
    }

    public String getIsSetSimilarPer() {
        return isSetSimilarPer;
    }

    public void setIsSetSimilarPer(String isSetSimilarPer) {
        this.isSetSimilarPer = isSetSimilarPer;
    }

    public BigDecimal getControlPrice() {
        return controlPrice;
    }

    public void setControlPrice(BigDecimal controlPrice) {
        this.controlPrice = controlPrice;
    }

    public BigDecimal getBidEvaluationPrice() {
        return bidEvaluationPrice;
    }

    public void setBidEvaluationPrice(BigDecimal bidEvaluationPrice) {
        this.bidEvaluationPrice = bidEvaluationPrice;
    }

    public String getIsSetSimilarPlus() {
        return isSetSimilarPlus;
    }

    public void setIsSetSimilarPlus(String isSetSimilarPlus) {
        this.isSetSimilarPlus = isSetSimilarPlus;
    }

    public String getNoticefile() {
        return noticefile;
    }

    public void setNoticefile(String noticefile) {
        this.noticefile = noticefile;
    }

    public String getNoticefiledata() {
        return Noticefiledata;
    }

    public void setNoticefiledata(String noticefiledata) {
        Noticefiledata = noticefiledata;
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
    }*/
}
