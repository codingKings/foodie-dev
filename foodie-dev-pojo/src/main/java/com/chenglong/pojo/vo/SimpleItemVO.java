package com.chenglong.pojo.vo;

/**
 * @Author: 程龙
 * @Date: 2020-10-19 15:09
 * 6个最新商品的简单数据类型
 */


public class SimpleItemVO {

    private String itemId;
    private String itemName;
    private String itemUrl;

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }
}
