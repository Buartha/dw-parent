package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Wangyg
 * @className cjjggs
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZFCGChengJiaoJieGuoGongShi implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String purchaseProjectCode;
    private String purchaseSectionCode;
    private String winBidBulletinTitle;
    private String url;
    private String noticeMedia;
    private String publicityContent;
    private String publicityStartTime;
    private String publicityEndTime;
    private String publicityType;
    private String publicitySubmitTime;
    private String winTime;
    private String traPlaceCode;
    private String purchaserAgencyName;
    private String purchaserAgencyCode;
    private String unifiedDealCode;
    private String creator;
    private String purchaseSectionInfo;
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
