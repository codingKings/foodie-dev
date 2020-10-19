package com.chenglong.pojo.vo;

import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-18 22:42
 * 二级分类
 */


public class CategoryVO {
    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;

    //三级分类vo list
    private List<SubCategoryVO> subCatList;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public void setSubCatList(List<SubCategoryVO> subCatList) {
        this.subCatList = subCatList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public List<SubCategoryVO> getSubCatList() {
        return subCatList;
    }
}
