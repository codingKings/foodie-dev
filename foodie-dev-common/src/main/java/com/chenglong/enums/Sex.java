package com.chenglong.enums;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 16:55
 * 性别枚举
 */

public enum Sex {
    woman(0,"女"),man(1,"男"),secret(2,"保密");

    public final Integer type;
    public final String value;

    Sex(Integer type,String value){
        this.type=type;
        this.value=value;
    }
}
