package com.chenglong.service.impl;

import com.chenglong.mapper.CategoryMapper;
import com.chenglong.mapper.CategoryMapperCustom;
import com.chenglong.pojo.Category;
import com.chenglong.pojo.vo.CategoryVO;
import com.chenglong.pojo.vo.NewItemsVO;
import com.chenglong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 程龙
 * @Date: 2020-10-18 21:47
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);

        List<Category> result = categoryMapper.selectByExample(example);

        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapperCustom.getSubCatList(rootCatId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {

        Map<String,Object> map = new HashMap<>();
        map.put("rootCatId",rootCatId);

        return categoryMapperCustom.getSixNewItemsLazy(map);
    }
}
