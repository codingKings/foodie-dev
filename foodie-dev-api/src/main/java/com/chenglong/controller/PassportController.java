package com.chenglong.controller;

import com.chenglong.pojo.Users;
import com.chenglong.pojo.bo.UserBO;
import com.chenglong.service.UserService;
import com.chenglong.util.CHENGLONGJSONResult;
import com.chenglong.util.CookieUtils;
import com.chenglong.util.JsonUtils;
import com.chenglong.util.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 15:57
 */

@Api(value = "注册登录",tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在",notes = "查询用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public CHENGLONGJSONResult usernameIsExist(@RequestParam String username){

        // 1,判断用户名不能为空
        if(StringUtils.isBlank(username)){
            return CHENGLONGJSONResult.errorMsg("用户名不能为空");
        }

        // 2,查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if(isExist){
            return CHENGLONGJSONResult.errorMsg("用户名已经存在");
        }

        // 3,请求成功，用户名没有重复
        return CHENGLONGJSONResult.ok();
    }

    @ApiOperation(value = "用户注册",notes = "用于用户注册接口",httpMethod = "POST")
    @PostMapping("/regist")
    public CHENGLONGJSONResult regist(@RequestBody UserBO userBO){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0,判断用户名和密码必须不为空
        if(StringUtils.isBlank(username) ||
            StringUtils.isBlank(password) ||
            StringUtils.isBlank(confirmPwd)){
            return CHENGLONGJSONResult.errorMsg("用户名或者密码不能为空");
        }


        // 1，查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if(isExist){
            return CHENGLONGJSONResult.errorMsg("用户名已经存在");
        }

        // 2，密码长度不能少于6位
        if (password.length()<6){
            return CHENGLONGJSONResult.errorMsg("密码长度不能少于6位");
        }

        // 3，判断两次的密码是否一致
        if (!password.equals(confirmPwd)){
            return CHENGLONGJSONResult.errorMsg("两次密码输入不一致");
        }

        // 4，实现注册
        userService.createUser(userBO);

        return CHENGLONGJSONResult.ok();

    }

    @ApiOperation(value = "用户登录",notes = "用于用户登录接口",httpMethod = "POST")
    @PostMapping("/login")
    public CHENGLONGJSONResult login(@RequestBody UserBO userBO, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        String username = userBO.getUsername();
        String password = userBO.getPassword();


        // 0,判断用户名和密码必须不为空
        if(StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ){
            return CHENGLONGJSONResult.errorMsg("用户名或者密码不能为空");
        }



        // 1，实现登录
        Users result = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));

        if (result == null) {
            return CHENGLONGJSONResult.errorMsg("用户名或者密码不正确");
        }

        result=setNullProperty(result);

        //把用户信息设置到cookie中
       CookieUtils.setCookie(request,response,"user", JsonUtils.objectToJson(result),true);
        return CHENGLONGJSONResult.ok(result);

    }

    @ApiOperation(value = "用户退出登录",notes = "用户退出登录",httpMethod = "POST")
    @PostMapping("/logout")
    public CHENGLONGJSONResult logout(@RequestParam String userId,HttpServletRequest request,HttpServletResponse response){

        //清除用户相关的cookie信息
        CookieUtils.deleteCookie(request,response,"user");

        // 用户退出登录，需要清空购物车
        // 分布式会话中需要清除用户数据

        return CHENGLONGJSONResult.ok();
    }

    private Users setNullProperty(Users result){
        result.setPassword(null);
        result.setMobile(null);
        result.setEmail(null);
        result.setUpdatedTime(null);
        result.setCreatedTime(null);
        result.setBirthday(null);
        return result;
    }

}
