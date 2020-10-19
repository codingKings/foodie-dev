package com.chenglong.pojo.vo;

import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-19 15:03
 * 最新商品VO
 */


public class NewItemsVO {

    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;

    private List<SimpleItemVO> simpleItemList;

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public void setSimpleItemList(List<SimpleItemVO> simpleItemList) {
        this.simpleItemList = simpleItemList;
    }

    public Integer getRootCatId() {
        return rootCatId;
    }

    public String getRootCatName() {
        return rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getCatImage() {
        return catImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public List<SimpleItemVO> getSimpleItemList() {
        return simpleItemList;
    }
}
