package com.bidsun.dw.pojo;

import java.io.Serializable;

/**
 * @author Wangyg
 * @className SLMatchingField
 * @description 数澜字段反馈
 * @date 2021/6/1 8:45
 */
public class SLMatchingField implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private Integer id;
    private String chainid;
    private String englishsourcetable;
    private String chinesesourcetable;
    private String sourceid;
    private String tender_project_name;
    private String tender_project_code;
    private String section_name;
    private String section_code;
    private String problemfield;
    private String problemfieldcontent;
    private String filefieldcontent;
    private String businesstype;
    private String top3;
    private String sourceversion;
    private String platform_code;
    private String filename;
    private Integer pagenum;
    private String url;
    private double accuratescore;
    private String uploadtime;
    private String createtime;
    private String updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChainid() {
        return chainid;
    }

    public void setChainid(String chainid) {
        this.chainid = chainid;
    }

    public String getEnglishsourcetable() {
        return englishsourcetable;
    }

    public void setEnglishsourcetable(String englishsourcetable) {
        this.englishsourcetable = englishsourcetable;
    }

    public String getChinesesourcetable() {
        return chinesesourcetable;
    }

    public void setChinesesourcetable(String chinesesourcetable) {
        this.chinesesourcetable = chinesesourcetable;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    public String getTender_project_name() {
        return tender_project_name;
    }

    public void setTender_project_name(String tender_project_name) {
        this.tender_project_name = tender_project_name;
    }

    public String getTender_project_code() {
        return tender_project_code;
    }

    public void setTender_project_code(String tender_project_code) {
        this.tender_project_code = tender_project_code;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSection_code() {
        return section_code;
    }

    public void setSection_code(String section_code) {
        this.section_code = section_code;
    }

    public String getProblemfield() {
        return problemfield;
    }

    public void setProblemfield(String problemfield) {
        this.problemfield = problemfield;
    }

    public String getProblemfieldcontent() {
        return problemfieldcontent;
    }

    public void setProblemfieldcontent(String problemfieldcontent) {
        this.problemfieldcontent = problemfieldcontent;
    }

    public String getFilefieldcontent() {
        return filefieldcontent;
    }

    public void setFilefieldcontent(String filefieldcontent) {
        this.filefieldcontent = filefieldcontent;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public String getTop3() {
        return top3;
    }

    public void setTop3(String top3) {
        this.top3 = top3;
    }

    public String getSourceversion() {
        return sourceversion;
    }

    public void setSourceversion(String sourceversion) {
        this.sourceversion = sourceversion;
    }

    public String getPlatform_code() {
        return platform_code;
    }

    public void setPlatform_code(String platform_code) {
        this.platform_code = platform_code;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getAccuratescore() {
        return accuratescore;
    }

    public void setAccuratescore(double accuratescore) {
        this.accuratescore = accuratescore;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
