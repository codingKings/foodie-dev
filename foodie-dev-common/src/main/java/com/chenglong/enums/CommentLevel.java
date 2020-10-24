package com.chenglong.enums;

/**
 * @Author: 程龙
 * @Date: 2020-10-22 16:00
 * <p>
 * 商品评价等级
 */


public enum CommentLevel {

    GOOD(1, "好评"),
    NORMAL(2, "是"),
    BAD(3, "差评");

    public final Integer type;
    public final String value;

    CommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
