package com.bidsun.dw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className SubscribeFavorites
 * @description 收藏量
 * @date 2021/6/1 8:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeFavorites implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;

    private String favorites_id;
    private String user_id;
    private String section_id;
    private String extension;
    private Integer mask;
    private String mtime;
    private String ctime;
    private String Platform_id;

   /* public String getFavorites_id() {
        return favorites_id;
    }

    public void setFavorites_id(String favorites_id) {
        this.favorites_id = favorites_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }*/
}
