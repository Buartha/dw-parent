package com.bidsun.dw.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSZhongBiaoHouXuanRen {
    private String pid;
    private String ebidsun_data_id;
    private String tenderProjectCode_1;
    private String sectionCode;
    private String bidderName;
    //投标价格
    private String CONTRACT_AMOUNT;
    //机构代码
    private String PLATFORM_CODE;
    private String PLATFORM_NAME;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;
}
