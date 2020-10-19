package com.chenglong.controller;

import com.chenglong.enums.YesOrNo;
import com.chenglong.pojo.Carousel;
import com.chenglong.pojo.Category;
import com.chenglong.pojo.vo.CategoryVO;
import com.chenglong.service.CarouselService;
import com.chenglong.service.CategoryService;
import com.chenglong.util.CHENGLONGJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-18 21:11
 */

@Api(value = "首页",tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表",notes = "获取首页轮播图列表",httpMethod = "GET")
    @GetMapping("/carousel")
    public CHENGLONGJSONResult carousel( ){
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return CHENGLONGJSONResult.ok(list);
    }

    /**
     * 首页分类展示需求：
     * 1，第一次刷新主页查询大分类，渲染展示到首页
     * 2，如果鼠标上移到大分类，则加载其子分类的内容，如果已经存在子分类，则不需要加载
     */

    @ApiOperation(value = "获取商品分类（一级分类）",notes = "获取商品分类（一级分类）",httpMethod = "GET")
    @GetMapping("/cats")
    public CHENGLONGJSONResult cats(){

        List<Category> list = categoryService.queryAllRootLevelCat();
        return CHENGLONGJSONResult.ok(list);
    }

    @ApiOperation(value = "获取商品子分类",notes = "获取商品子分类",httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public CHENGLONGJSONResult subCat(@ApiParam(name = "rootCatId",value = "一级分类id",required = true)
                                          @PathVariable Integer rootCatId){

        if (rootCatId==null){
            return CHENGLONGJSONResult.errorMsg("分类不存在");
        }

        List<CategoryVO> list = categoryService.getSubCatList(rootCatId);

        return CHENGLONGJSONResult.ok(list);
    }

}