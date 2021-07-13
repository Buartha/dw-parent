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
public class AdsGzhDataApplicationDaily implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String	id	;
    private String	platform_code	;
    private String	platform_name	;
    private int	visit_count	;
    private int	subscribe_count	;
    private int	favorite_count	;
    private int	share_count	;
    private String	statistic_date	;
    private String	extention	;
    private int	mask	;
    private String	ctime	;
    private String	mtime	;



}
