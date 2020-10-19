package com.chenglong.service;

import com.chenglong.pojo.Stu;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 9:22
 */


public interface StuService {

    public Stu getSutInfo(int id);

    public void saveStu();

    public void updateStu(int id);

    public void deleteStu(int id);

    public void saveParent();

    public void saveChild();

}
