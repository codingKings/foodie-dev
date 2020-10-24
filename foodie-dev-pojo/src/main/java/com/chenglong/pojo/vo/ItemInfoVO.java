package com.chenglong.pojo.vo;

import com.chenglong.pojo.Items;
import com.chenglong.pojo.ItemsImg;
import com.chenglong.pojo.ItemsParam;
import com.chenglong.pojo.ItemsSpec;

import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-23 10:24
 * <p>
 * 商品详情VO
 */


public class ItemInfoVO {

    private Items items;

    private List<ItemsImg> itemsImgList;

    private List<ItemsSpec> itemsSpecList;

    private ItemsParam itemsParam;

    public void setItems(Items items) {
        this.items = items;
    }

    public void setItemsImgList(List<ItemsImg> itemsImgList) {
        this.itemsImgList = itemsImgList;
    }

    public void setItemsSpecList(List<ItemsSpec> itemsSpecList) {
        this.itemsSpecList = itemsSpecList;
    }

    public void setItemsParam(ItemsParam itemsParam) {
        this.itemsParam = itemsParam;
    }

    public Items getItems() {
        return items;
    }

    public List<ItemsImg> getItemsImgList() {
        return itemsImgList;
    }

    public List<ItemsSpec> getItemsSpecList() {
        return itemsSpecList;
    }

    public ItemsParam getItemsParam() {
        return itemsParam;
    }
}
