package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className pbbg
 * @description TODO
 * @date 2021/6/1 8:45
 */
public class ZFCGPingBiaoBaoGao implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String purchaseProjectCode;
    private String purchaseSectionCode;
    private String evaluationContent;
    private LocalDateTime submitTime;
    private String judgeLeader;
    private String judgeName;
    private String judgeResult;
    private String bidFailureReasons;
    private String evaluationBidWitnessName;
    private String evaluationBidWitnessPhone;
    private String evaluatingAddress;
    private String noticeName;
    private LocalDateTime endTime;
    private LocalDateTime evalOpenTime;
    private String enteredEvalRoomMembers;
    private String enteredEvalRoomCode;
    private String enteredEvalRoomReason;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getEvaluatingAddress() {
        return evaluatingAddress;
    }

    public void setEvaluatingAddress(String evaluatingAddress) {
        this.evaluatingAddress = evaluatingAddress;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEvalOpenTime() {
        return evalOpenTime;
    }

    public void setEvalOpenTime(LocalDateTime evalOpenTime) {
        this.evalOpenTime = evalOpenTime;
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
    }
}
