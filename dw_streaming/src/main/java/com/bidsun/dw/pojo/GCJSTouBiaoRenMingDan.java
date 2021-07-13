package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Niuxy
 * @className GCJSTouBiaoRenMingDan
 * @description TODO
 * @date 2021/6/16 19:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GCJSTouBiaoRenMingDan implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String pid;
    //招标标段
    private String sectionCode;
    //
    private String bidderName_1;
    //招标项目
    private String tenderProjectCode;
    //机构代码
    private String PLATFORM_CODE;
    //总价形式报价金额
    private Double CONTRACT_AMOUNT;
    //投标文件递交时间
    private String checkinTime;

    private String PLATFORM_NAME;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;


}
