package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Wangyg
 * @className zbgg
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZFCGZhaoBiaoGongGao implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String purchaseProjectCode;
    private String purchaseSectionCode;
    private String bulletinType;
    private Date docSellStartTime;
    private Date docSellEndTime;
    private BigDecimal docPrice;
    private String docPriceUnit;
    private Date bidOpenTime;
    private String bidOpenSite;
    private String noticeMedia;
    private Date noticeSendTime;
    private Integer bulletinBidNum;
    private String unifiedDealCode;
    private String bulletinTitle;
    private String bulletinContent;
    private String url;
    private Date bidPaymentTime;
    private String applicantRequire;
    private String applicantSpecialRequire;
    private String isSamplesShow;
    private String purchasePolicy;
    private String serviceSecurity;
    private String serviceLocation;
    private String otherMatters;
    private String SectionInfo;
    private String TENDER_FILE;
    private String TENDER_FILE_DATA;
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
