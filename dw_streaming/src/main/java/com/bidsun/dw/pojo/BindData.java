package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className BindData
 * @description 绑定关系链上数据
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BindData implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String id;
    private String chain_name;
    private Integer block_height;
    private String record_id;
    private String platform_Id;
    private String open_id;
    private String app_id;
    private String third_id;
    private String name;
    private Integer sex;
    private String id_card_num;
    private String telephone;
    private String org_code;
    private String license;
    private String company_name;
    private String trade_company_name;
    private String bind_extension;
    private String extension;
    private Integer mask;
    //private LocalDateTime ctime;
    //private LocalDateTime mtime;
    private String company_id;
    private String account_id;
    //private LocalDateTime upload_time;


}
