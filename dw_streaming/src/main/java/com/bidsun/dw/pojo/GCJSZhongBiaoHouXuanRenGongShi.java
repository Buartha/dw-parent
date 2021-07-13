package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className zbhxrgs
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSZhongBiaoHouXuanRenGongShi implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String tenderProjectCode;
    private String sectionCode;
    private String evaluationResult;
    private String publicityContent;
    private LocalDateTime publicityStartTime;
    private LocalDateTime publicityEndTime;
    private String publicityType;
    private LocalDateTime publicitySubmitTime;
    private String scoreResult;
    private String unifiedDealCode;
    private String publicityName;
    private String noticeMedia;
    private String url;
    private String objectionWay;
    private String elseContent;
    private String responsibleName;
    private String verifierName;
    private String PLATFORM_NAME;
    private String PLATFORM_CODE;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;
}
