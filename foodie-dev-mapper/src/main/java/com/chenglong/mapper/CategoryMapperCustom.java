package com.chenglong.mapper;

import com.chenglong.pojo.vo.CategoryVO;

import java.util.List;


public interface CategoryMapperCustom {

    List<CategoryVO> getSubCatList(Integer rootCatId);
}