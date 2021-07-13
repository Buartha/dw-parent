package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Wangyg
 * @className tbbzjjn
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSTouBiaoBaoZhengJinJiaoNa implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String tenderProjectCode;
    private String sectionCode;
    private String bidderName;
    private String bidderOrgCode;
    private String UNION_BIDDER_IF;
    private String UNION_BIDDER_INFO;
    private String marginPayForm;
    private String marginPayType;
    private String accountName;
    private String accountCode;
    private BigDecimal marginPrice;
   // private LocalDateTime marginPayTime;
   // private LocalDateTime marginUseTime;
    private String guaranteeLegalName;
    private String guaranteeLegalCode;
    private String creditTotal;
    //private LocalDateTime guaranteeApplyTime;
    //private LocalDateTime guaranteeApproveTime;
    //private LocalDateTime guaranteeEffectiveTime;
    //private LocalDateTime guaranteeInvalidTime;
   // private LocalDateTime guaranteeSubmitTime;
    private BigDecimal guaranteeAmount;
    private String contractCurrency;
    private String paymentState;
    private String guaranteeName;
    //private LocalDateTime TransDate;
    private String guaranteeType;
    private String APPLY_TYPE;
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
