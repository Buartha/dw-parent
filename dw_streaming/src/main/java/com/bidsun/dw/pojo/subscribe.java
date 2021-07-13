package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * @author Wangyg
 * @className subscribe
 * @description 订阅量
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class subscribe implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;

    private String subscribe_id;
    private String user_id;
    private String keywords;
    private String trade_center;
    private String industry_type;
    private String guaranteeType;
    private String prev_time;
    private String extension;
    private String mask;
    private String mtime;
    private String ctime;
    private  String Platform_codes;
    private String Platform_code;


}
