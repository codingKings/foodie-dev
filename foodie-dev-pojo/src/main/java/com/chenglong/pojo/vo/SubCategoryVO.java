package com.chenglong.pojo.vo;

/**
 * @Author: 程龙
 * @Date: 2020-10-18 22:46
 */


public class SubCategoryVO {

    private Integer subId;
    private String subType;
    private String subName;
    private Integer subFatherId;

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public void setSubFatherId(Integer subFatherId) {
        this.subFatherId = subFatherId;
    }

    public Integer getSubId() {
        return subId;
    }

    public String getSubType() {
        return subType;
    }

    public String getSubName() {
        return subName;
    }

    public Integer getSubFatherId() {
        return subFatherId;
    }
}
