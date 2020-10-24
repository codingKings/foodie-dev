package com.chenglong.service;

import com.chenglong.pojo.Items;
import com.chenglong.pojo.ItemsImg;
import com.chenglong.pojo.ItemsParam;
import com.chenglong.pojo.ItemsSpec;
import com.chenglong.pojo.vo.CommentLevelCountsVO;
import com.chenglong.util.PagedGridResult;

import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-21 16:46
 */


public interface ItemService {

    /**
     * 根据商品id查询详情
     *
     * @param id
     * @return
     */
    public Items queryItemById(String id);

    /**
     * 根据商品id查询商品图片列表
     *
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     *
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     *
     * @param itemId
     * @return
     */
    public ItemsParam queryItemParamList(String itemId);

    /**
     * 查询商品评价
     *
     * @param itemId
     * @return
     */
    public CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * 根据商品id,查询商品评价（分页）
     *
     * @param itemId
     * @param level
     * @return
     */
    public PagedGridResult queryPagedItemComments(String itemId, Integer level, Integer page, Integer pageSize);
}
