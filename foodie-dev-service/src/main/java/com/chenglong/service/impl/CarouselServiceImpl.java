package com.chenglong.service.impl;

import com.chenglong.mapper.CarouselMapper;
import com.chenglong.pojo.Carousel;
import com.chenglong.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-18 21:06
 */

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow",isShow);

        List<Carousel> result =  carouselMapper.selectByExample(example);
        return result;
    }
}
