package com.chenglong.pojo.vo;

import java.util.Date;

/**
 * @Author: 程龙
 * @Date: 2020-10-23 14:53
 * <p>
 * 用于展示商品评价的VO
 */


public class ItemCommentVO {
    private Integer commentLevel;
    private String content;
    private String specName;
    private Date createdTime;
    private String userFace;
    private String nickName;

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public String getContent() {
        return content;
    }

    public String getSpecName() {
        return specName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public String getUserFace() {
        return userFace;
    }

    public String getNickName() {
        return nickName;
    }
}
