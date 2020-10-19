package com.chenglong.service;

import com.chenglong.pojo.Users;
import com.chenglong.pojo.bo.UserBO;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 15:27
 */


public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     * @param userBO
     * @return
     */
    Users createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登录
     * @param username
     * @param password
     * @return
     */
    Users queryUserForLogin(String username,String password);


}
