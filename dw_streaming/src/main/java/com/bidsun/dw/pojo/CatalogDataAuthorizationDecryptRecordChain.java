package com.bidsun.dw.pojo;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className CatalogDataAuthorizationDecryptRecordChain
 * @description 数据项授权表
 * @date 2021/6/1 8:45
 */
public class CatalogDataAuthorizationDecryptRecordChain implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private String record_id;
    private String catalog_id;
    private Integer catalog_version;
    private String data_item_id;
    private String data_id;
    private String data_auth_id;
    private Integer auth_type;
    private Integer auth_category;
    private Integer data_item_public_type;
    private Integer decrypt_time;
    private String owner_node_id;
    private String auth_node_id;
    private String decrypt_node_id;
    private Integer up_chain_time;
    private String channel_name;
    private Integer block_height;
    private Integer mask;
    private String extension;
    private String ctime;
    private String mtime;

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    public Integer getCatalog_version() {
        return catalog_version;
    }

    public void setCatalog_version(Integer catalog_version) {
        this.catalog_version = catalog_version;
    }

    public String getData_item_id() {
        return data_item_id;
    }

    public void setData_item_id(String data_item_id) {
        this.data_item_id = data_item_id;
    }

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public String getData_auth_id() {
        return data_auth_id;
    }

    public void setData_auth_id(String data_auth_id) {
        this.data_auth_id = data_auth_id;
    }

    public Integer getAuth_type() {
        return auth_type;
    }

    public void setAuth_type(Integer auth_type) {
        this.auth_type = auth_type;
    }

    public Integer getAuth_category() {
        return auth_category;
    }

    public void setAuth_category(Integer auth_category) {
        this.auth_category = auth_category;
    }

    public Integer getData_item_public_type() {
        return data_item_public_type;
    }

    public void setData_item_public_type(Integer data_item_public_type) {
        this.data_item_public_type = data_item_public_type;
    }

    public Integer getDecrypt_time() {
        return decrypt_time;
    }

    public void setDecrypt_time(Integer decrypt_time) {
        this.decrypt_time = decrypt_time;
    }

    public String getOwner_node_id() {
        return owner_node_id;
    }

    public void setOwner_node_id(String owner_node_id) {
        this.owner_node_id = owner_node_id;
    }

    public String getAuth_node_id() {
        return auth_node_id;
    }

    public void setAuth_node_id(String auth_node_id) {
        this.auth_node_id = auth_node_id;
    }

    public String getDecrypt_node_id() {
        return decrypt_node_id;
    }

    public void setDecrypt_node_id(String decrypt_node_id) {
        this.decrypt_node_id = decrypt_node_id;
    }

    public Integer getUp_chain_time() {
        return up_chain_time;
    }

    public void setUp_chain_time(Integer up_chain_time) {
        this.up_chain_time = up_chain_time;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public Integer getBlock_height() {
        return block_height;
    }

    public void setBlock_height(Integer block_height) {
        this.block_height = block_height;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
    }
}
