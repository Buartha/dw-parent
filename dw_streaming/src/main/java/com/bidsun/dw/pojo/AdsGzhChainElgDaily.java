package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: wangyg
 * @Date: 2021/6/29 20:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdsGzhChainElgDaily implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String	id	;
    private String	platform_code	;
    private String	platform_name	;
    private double	release_pressure_enterprise_capital	;
    private int	elg_opening_count	;
    private double	elg_opening_amount	;
    private int	financial_institutions_count	;
    private int	financial_institutions_value	;
    private int	service_bidding_enterprise_count	;
    private int	service_bidding_enterprise_value	;
    private int	elg_insurance_opening_count	;
    private int	elg_bank_opening_count	;
    private int	elg_guarantee_opening_count	;
    private String	statistic_date	;
    private String	extention	;
    private int	mask	;
    private String	ctime	;
    private String	mtime	;

}
