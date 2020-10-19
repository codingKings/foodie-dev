package com.chenglong.service;

import com.chenglong.pojo.Category;
import com.chenglong.pojo.vo.CategoryVO;


import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-18 21:46
 */


public interface CategoryService {
    /**
     * 查询所有一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类Id查询子分类的信息
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 查询首页中每个一级分类下的6条最新商品数据
     * @param rootCatId
     * @return
     */
    List getSixNewItemsLazy(Integer rootCatId);
}
