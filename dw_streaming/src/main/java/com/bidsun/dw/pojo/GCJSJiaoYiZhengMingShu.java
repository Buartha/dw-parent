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
 * @className jyzms
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSJiaoYiZhengMingShu implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String tenderProjectCode;
    private String projectName;
    private String sectionName;
    private String sectionCode;
    private String winBidderName;
    private String winBidderCode;
    private String UNION_BIDDER_IF;
    private String UNION_BIDDER_INFO;
    private Integer WIN_bidder_ORDER;
    private Double CONTRACT_AMOUNT;
    private String CONTRACT_CURRENCY;
    private String CONTRACT_CURRENCYUNIT;
    private String UNIT_BID_PRICE;
    private String RATE_BID_PRICE;
    private String OTHER_BID_PRICE;
    private String certNo;
    private Date certDate;
    private String traAgencyName;
    private String traAgencyCode;
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
