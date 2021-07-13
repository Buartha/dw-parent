package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Niuxy
 * @className LocalTransactionInfo
 * @description 上链数据
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalTransactionInfo implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;

    private String platform_id;
    private String chain_name;
    private String block_height;
    private String tx_id;
    private String tx_type;
    private String tx_end_point;
    private String tx_size;
    private String block_num;
    private String tx_create_time;
    private String tx_valid;
    private String tx_func_name;
    private String tx_count;
    private String extension;
    private String mask;
    private String ctime;
    private String mtime;

   /* public String getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(String platform_id) {
        this.platform_id = platform_id;
    }

    public String getChain_name() {
        return chain_name;
    }

    public void setChain_name(String chain_name) {
        this.chain_name = chain_name;
    }

    public String getBlock_height() {
        return block_height;
    }

    public void setBlock_height(String block_height) {
        this.block_height = block_height;
    }

    public String getTx_id() {
        return tx_id;
    }

    public void setTx_id(String tx_id) {
        this.tx_id = tx_id;
    }

    public String getTx_type() {
        return tx_type;
    }

    public void setTx_type(String tx_type) {
        this.tx_type = tx_type;
    }

    public String getTx_end_point() {
        return tx_end_point;
    }

    public void setTx_end_point(String tx_end_point) {
        this.tx_end_point = tx_end_point;
    }

    public String getTx_size() {
        return tx_size;
    }

    public void setTx_size(String tx_size) {
        this.tx_size = tx_size;
    }

    public String getBlock_num() {
        return block_num;
    }

    public void setBlock_num(String block_num) {
        this.block_num = block_num;
    }

    public String getTx_create_time() {
        return tx_create_time;
    }

    public void setTx_create_time(String tx_create_time) {
        this.tx_create_time = tx_create_time;
    }

    public String getTx_valid() {
        return tx_valid;
    }

    public void setTx_valid(String tx_valid) {
        this.tx_valid = tx_valid;
    }

    public String getTx_func_name() {
        return tx_func_name;
    }

    public void setTx_func_name(String tx_func_name) {
        this.tx_func_name = tx_func_name;
    }

    public String getTx_count() {
        return tx_count;
    }

    public void setTx_count(String tx_count) {
        this.tx_count = tx_count;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }*/
}
