package com.bidsun.dw.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className SubscribeHistory
 * @description 访问量
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeHistory implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String history_id;
    private String user_id;
    private String section_id;
    private String extension;
    private String mask;
    private String mtime;
    private String ctime;
    private String platform_id;

}
