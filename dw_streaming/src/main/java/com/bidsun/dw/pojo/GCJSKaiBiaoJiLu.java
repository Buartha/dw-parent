package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className kbjl
 * @description TODO
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GCJSKaiBiaoJiLu implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;

    private String pid;
    private String tenderProjectCode;
    private String sectionCode;

    private String PLATFORM_CODE;
    private String BIDOPENINGTIME;
    private String PLATFORM_NAME;
    private String PLATFORM_DEPARTMENT;
    private String PLATFORM_RESPONSIBLE;
    private String PLATFORM_RESPONSIBLE_PHONE;
    private String PLATFORM_RESPONSIBLE_UNIT;
    private String DATA_RESPONSIBLE_CODE;
    private String DATA_RESPONSIBLE;
    private String DATA_RESPONSIBLE_PHONE;

}
