package com.chenglong.enums;

/**
 * @Author: 程龙
 * @Date: 2020-10-18 21:17
 */


public enum YesOrNo {
    NO(0,"否"),
    YES(1,"是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type,String value){
        this.type=type;
        this.value=value;
    }
}
