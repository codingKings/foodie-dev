package com.chenglong.controller;

import com.chenglong.pojo.Items;
import com.chenglong.pojo.ItemsImg;
import com.chenglong.pojo.ItemsParam;
import com.chenglong.pojo.ItemsSpec;
import com.chenglong.pojo.vo.CommentLevelCountsVO;
import com.chenglong.pojo.vo.ItemInfoVO;
import com.chenglong.pojo.vo.ShopcatVO;
import com.chenglong.service.ItemService;
import com.chenglong.util.CHENGLONGJSONResult;
import com.chenglong.util.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-21 17:15
 */

@Api(value = "商品接口", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController extends BaseController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public CHENGLONGJSONResult info(@ApiParam(name = "itemId", value = "商品id", required = true)
                                    @PathVariable String itemId) {

        if (StringUtils.isBlank(itemId)) {
            return CHENGLONGJSONResult.errorMsg(null);
        }

        Items item = itemService.queryItemById(itemId);
        List<ItemsImg> itemsImgList = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemService.queryItemParamList(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItems(item);
        itemInfoVO.setItemsImgList(itemsImgList);
        itemInfoVO.setItemsSpecList(itemsSpecList);
        itemInfoVO.setItemsParam(itemsParam);

        return CHENGLONGJSONResult.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public CHENGLONGJSONResult commentLevel(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId
    ) {
        if (StringUtils.isBlank(itemId)) {
            return CHENGLONGJSONResult.errorMsg(null);
        }
        CommentLevelCountsVO commentLevelCountsVO = itemService.queryCommentCounts(itemId);
        return CHENGLONGJSONResult.ok(commentLevelCountsVO);
    }

    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
    @GetMapping("/comments")
    public CHENGLONGJSONResult comments(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId,
            @ApiParam(name = "level", value = "评价等级", required = false)
            @RequestParam Integer level,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示条数", required = false)
            @RequestParam Integer pageSize
    ) {
        if (StringUtils.isBlank(itemId)) {
            return CHENGLONGJSONResult.errorMsg(null);
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = COMMENT_PAGE_SIZE;
        }

        PagedGridResult grid = itemService.queryPagedItemComments(itemId, level, page, pageSize);

        return CHENGLONGJSONResult.ok(grid);
    }

    @ApiOperation(value = "搜索商品列表", notes = "搜索商品列表", httpMethod = "GET")
    @GetMapping("/search")
    public CHENGLONGJSONResult search(
            @ApiParam(name = "keywords", value = "关键字", required = true)
            @RequestParam String keywords,
            @ApiParam(name = "sort", value = "排序", required = false)
            @RequestParam String sort,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示条数", required = false)
            @RequestParam Integer pageSize
    ) {
        if (StringUtils.isBlank(keywords)) {
            return CHENGLONGJSONResult.errorMsg(null);
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        PagedGridResult grid = itemService.searhItems(keywords, sort, page, pageSize);

        return CHENGLONGJSONResult.ok(grid);
    }

    @ApiOperation(value = "通过分类id搜索商品列表", notes = "通过分类id搜索商品列表", httpMethod = "GET")
    @GetMapping("/catItems")
    public CHENGLONGJSONResult catItems(
            @ApiParam(name = "catId", value = "分类id", required = true)
            @RequestParam String catId,
            @ApiParam(name = "sort", value = "排序", required = false)
            @RequestParam String sort,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示条数", required = false)
            @RequestParam Integer pageSize
    ) {
        if (StringUtils.isBlank(catId)) {
            return CHENGLONGJSONResult.errorMsg(null);
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        PagedGridResult grid = itemService.searhItemsByThirdCat(catId, sort, page, pageSize);

        return CHENGLONGJSONResult.ok(grid);
    }

    /**
     * 用于用户长时间未登录网站，刷新购物车中的数据（主要是商品价格），类似京东淘宝
     *
     * @param itemSpecIds
     * @return
     */
    @ApiOperation(value = "根据商品规格ids查找最新的商品数据", notes = "通过分类id搜索商品列表", httpMethod = "GET")
    @GetMapping("/refresh")
    public CHENGLONGJSONResult refresh(
            @ApiParam(name = "itemSpecIds", value = "拼接的规格ids", required = true, example = "1001,1003,1005")
            @RequestParam String itemSpecIds
    ) {
        if (StringUtils.isBlank(itemSpecIds)) {
            return CHENGLONGJSONResult.ok();
        }

        List<ShopcatVO> list = itemService.queryItemBySpecIds(itemSpecIds);

        return CHENGLONGJSONResult.ok(list);
    }


}
