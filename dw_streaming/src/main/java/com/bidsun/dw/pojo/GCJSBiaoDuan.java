package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className bd
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSBiaoDuan implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    private String projectIdentifierCode;
    private String objectIdentifierCode;
    private String unifiedDealCode;
    private String tenderProjectCode;
    private String sectionCode;
    private String sectionName;
    private String projectCategory;
    private String sectionContent;
    private String sectionClassifyCode;
    private Double contractReckonPrice;
    private String priceUnit;
    private String bidQualification;
    private Integer bidEctionNum;
    private String bidTenderMode;
    private String regionCode;
    private String traPlaceCode;
    private String currencyCode;
    private Integer limiteTime;
    private String qualityClaim;
  //  private LocalDateTime sectionCreateTime;
    private BigDecimal programBudget;
    private String budgetCurrency;
    private String unitBudget;
    private String isRebid;
    private String Pre_sectionCode;
   //rivate LocalDateTime planStartTime;
  //private LocalDateTime planCompletedTime;
    private String descr;
    private String NA_AREA_COORDINATE;
    private String PLATFORM_NAME;
    private String PLATFORM_CODE;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;
    private Double save_amount;

}
