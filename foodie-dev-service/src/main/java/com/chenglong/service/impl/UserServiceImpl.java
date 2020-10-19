package com.chenglong.service.impl;

import com.chenglong.enums.Sex;
import com.chenglong.mapper.UsersMapper;
import com.chenglong.pojo.Users;
import com.chenglong.pojo.bo.UserBO;
import com.chenglong.service.UserService;
import com.chenglong.util.DateUtil;
import com.chenglong.util.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 15:42
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String USER_FACE="http://localhost...";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(userExample);

        return result==null ? false : true;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        //测试AOP
//        try {
//            Thread.sleep(2500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        userCriteria.andEqualTo("password",password);

        Users result = usersMapper.selectOneByExample(userExample);

        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {

        //测试AOP
//        try {
//            Thread.sleep(3500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //-------------结束测试AOP

        Users user = new Users();
        user.setId(sid.nextShort());
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 默认用户昵称为用户名
        user.setNickname(userBO.getUsername());
        // 默认用户头像
        user.setFace(USER_FACE);
        // 默认的出生日期
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));

        // 默认性别：保密
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);
        return user;
    }
}
