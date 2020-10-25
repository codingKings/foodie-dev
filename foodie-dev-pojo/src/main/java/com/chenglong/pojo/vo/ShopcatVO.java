package com.chenglong.pojo.vo;

/**
 * @Author: 程龙
 * @Date: 2020-10-24 21:35
 */


public class ShopcatVO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private String priceDiscount;
    private String priceNormal;

    public String getItemId() {
        return itemId;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSpecId() {
        return specId;
    }

    public String getSpecName() {
        return specName;
    }

    public String getPriceDiscount() {
        return priceDiscount;
    }

    public String getPriceNormal() {
        return priceNormal;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public void setPriceDiscount(String priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public void setPriceNormal(String priceNormal) {
        this.priceNormal = priceNormal;
    }
}
