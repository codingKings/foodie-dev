package com.chenglong.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 13:52
 *
 * 自定义相应数据结构，可以提供H5,IOS,安卓，公众号，小程序使用
 * 前端接收此类数据后，可自行根据业务实现相关功能
 *
 * 200：表示成功
 * 500：表示错误，错误信息在msg字段中
 * 501：bean验证错误，不管多少个错误，都以map形式返回
 * 502：拦截器拦截到用户token出错
 * 555：异常抛出信息
 * 556：用户qq校验异常
 *
 */


public class CHENGLONGJSONResult {

    //定义jsckson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    @JsonIgnore
    private String ok;//暂时不使用

    public CHENGLONGJSONResult(Integer status, String msg,  Object data,String ok) {
        this.status=status;
        this.msg=msg;
        this.data=data;
        this.ok=ok;
    }

    public CHENGLONGJSONResult(Object data) {
        this.status=200;
        this.msg="OK";
        this.data=data;
    }

    public Boolean isOK(){
        return this.status==200;
    }

    public Integer getStatus(){
        return status;
    }
    public void setStatus(Integer status){
        this.status=status;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg=msg;
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data=data;
    }

    public String getOk(){
        return ok;
    }
    public void setOK(String ok){
        this.ok=ok;
    }
    public CHENGLONGJSONResult(Integer status, String msg, Object data) {
        this.status=status;
        this.msg=msg;
        this.data=data;
    }

    public CHENGLONGJSONResult(){}

    public static CHENGLONGJSONResult build(Integer status,String msg,Object data){
        return new CHENGLONGJSONResult(status,msg, data);
    }

    public static CHENGLONGJSONResult build(Integer status,String msg,Object data,String ok){
        return new CHENGLONGJSONResult(status,msg,data,ok);
    }

    public static CHENGLONGJSONResult ok(Object data){
        return new CHENGLONGJSONResult(data);
    }

    public static CHENGLONGJSONResult ok(){
        return new CHENGLONGJSONResult(null);
    }

    public static CHENGLONGJSONResult errorMsg(String msg){
        return new CHENGLONGJSONResult(500,msg,null);
    }

    public static CHENGLONGJSONResult errorMap(Object data){
        return new CHENGLONGJSONResult(501,"error",data);
    }

    public static CHENGLONGJSONResult errorTokenMsg(String msg){
        return new CHENGLONGJSONResult(502,msg,null);
    }

    public static CHENGLONGJSONResult errorException(String msg){
        return new CHENGLONGJSONResult(555,msg,null);
    }

    public static CHENGLONGJSONResult errorUserQQ(String msg){
        return new CHENGLONGJSONResult(556,msg,null);
    }
}
