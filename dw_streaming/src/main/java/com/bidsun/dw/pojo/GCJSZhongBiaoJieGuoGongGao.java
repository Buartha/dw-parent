package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className zbjggg
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSZhongBiaoJieGuoGongGao implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String sectionCode;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String tenderProjectCode;
    private String bidSectionCode;
    private String unifiedDealCode;
    private String noticeName;
    private String noticeContent;
    //private LocalDateTime noticeSendTime;
    private String noticeMedia;
    private String url;
    private String noticeNature;
    private String bulletinType;
    private String regionCode;
    private String traPlaceCode;
    private String tenderAgencyName;
    private String tenderAgencyCode;
   // private LocalDateTime noticeBeginDate;
    private String WinningbidInfo;
    private String UNION_BIDDER_IF;
    private String UNION_BIDDER_INFO;
    private String complaintsUnit;
    private String complaintsPhone;
    private String elseContent;
    private String PLATFORM_NAME;
    private String PLATFORM_CODE;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;
    private Double CONTRACT_AMOUNT;

}
