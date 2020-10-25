package com.chenglong.mapper;


import com.chenglong.pojo.vo.ItemCommentVO;
import com.chenglong.pojo.vo.SearchItemsVO;
import com.chenglong.pojo.vo.ShopcatVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 程龙
 * @Date: 2020-10-23 14:16
 */


public interface ItemsMapperCustom {

    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    List<SearchItemsVO> searhItems(@Param("paramsMap") Map<String, Object> map);

    List<SearchItemsVO> searhItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);

    List<ShopcatVO> queryItemsBySpecIds(@Param("paramsList") List specIdsList);
}
