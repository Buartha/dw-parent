package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Niuxy
 * @className EbidsunEvent
 * @description TODO
 * @date 2021/6/16 13:59
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbidsunEvent implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String tableName;
    private String eventBody;

}
