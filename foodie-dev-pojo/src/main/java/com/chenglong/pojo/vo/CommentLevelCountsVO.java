package com.chenglong.pojo.vo;

/**
 * @Author: 程龙
 * @Date: 2020-10-22 15:47
 * <p>
 * 用于展示商品评价数的VO
 */


public class CommentLevelCountsVO {

    private Integer totalCounts;
    private Integer goodCounts;

    private Integer normalCounts;

    private Integer badCounts;

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public void setGoodCounts(Integer goodCounts) {
        this.goodCounts = goodCounts;
    }

    public void setNormalCounts(Integer normalCounts) {
        this.normalCounts = normalCounts;
    }

    public void setBadCounts(Integer badCounts) {
        this.badCounts = badCounts;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public Integer getGoodCounts() {
        return goodCounts;
    }

    public Integer getNormalCounts() {
        return normalCounts;
    }

    public Integer getBadCounts() {
        return badCounts;
    }
}
