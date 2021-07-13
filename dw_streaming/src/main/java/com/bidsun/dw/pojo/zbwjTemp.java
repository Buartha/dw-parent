package com.bidsun.dw.pojo;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className zbwjTemp
 * @description 中间表
 * @date 2021/6/1 8:45
 */
public class zbwjTemp implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String id;
    private String tenderProjectCode;
    private String sectionCode;
    private String marginAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMarginAmount() {
        return marginAmount;
    }

    public void setMarginAmount(String marginAmount) {
        this.marginAmount = marginAmount;
    }
}
