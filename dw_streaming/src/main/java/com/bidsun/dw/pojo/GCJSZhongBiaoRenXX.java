package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSZhongBiaoRenXX {
    //标段（包）编号
    private String ebidsun_data_id;
    //中标人名称
    private String winBidderName;
    //中标投标人代码
    private String winBidderCode;
    //总价形式报价金额
    private Double CONTRACT_AMOUNT;

    private String pid;
    private String tenderProjectCode;
    //机构代码
    private String PLATFORM_CODE;
    private String sectionCode;
    private String idCard_1;
    private String PLATFORM_NAME;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;
}
