package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: wangyg
 * @Date: 2021/6/24 16:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdsGzhTradeCountDaily implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String id;
    private String platform_code;
    private String platform_name;
    private String business_type;
    private String trade_type;
    private String project_type;
    private Double trade_amount;
    private Integer trade_count;
    private Integer trade_days;
    private Integer entrance_project_count;
    private Integer open_count;
    private Integer evaluation_count;
    private Integer exception_count;
    private Integer tender_count;
    private Double save_amount;
    private Double save_ratio;
    private Double contract_estimated_amount;
    private Integer chain_upload_project_count;
    private LocalDateTime statistic_date;
    private String extention;
    private Integer mask;
    private LocalDateTime ctime;
    private LocalDateTime mtime;

    public AdsGzhTradeCountDaily(String platform_code,Integer open_count){
        platform_code=this.platform_code;
        open_count=this.open_count;
    }


}
