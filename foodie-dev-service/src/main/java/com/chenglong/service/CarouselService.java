package com.chenglong.service;

import com.chenglong.pojo.Carousel;

import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-18 21:01
 */


public interface CarouselService {

    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);
}
