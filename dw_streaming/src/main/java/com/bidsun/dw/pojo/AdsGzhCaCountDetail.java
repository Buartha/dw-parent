package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className BindData
 * @description 绑定关系链上数据
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdsGzhCaCountDetail implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String    	id	;
    private String	platform_code	;
    private String	platform_name	;
    private int	account_interchange_count	;
    private int	mobile_ca_usage_count	;
    private int	signature_code_login_count	;
    private int	signature_count	;
    private int	encrypt_decrypt_count	;
    private double	ca_share_company	;
    private String	statistic_date	;
    private String	extention	;
    private int	mask	;
    private String	ctime	;
    private String	mtime	;


}
