package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Wangyg
 * @className subscribe
 * @description 大数据返回的反馈表
 * @date 2021/6/1 8:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDataGzhCalc implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String   id               	;
    private String hive_table_name  	;
    private String ebidsun_data_id  	;
    private int  calc_nonRequired 	;
    private double  complete_score   	;
    private String calc_time        	;
    private int mask	;
    private String extension        	;
    private String ctime            	;
    private String mtime            	;

}
