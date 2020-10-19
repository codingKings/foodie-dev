package com.chenglong.service.impl;

import com.chenglong.mapper.StuMapper;
import com.chenglong.pojo.Stu;
import com.chenglong.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 9:24
 */

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getSutInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveStu() {

    }

    @Override
    public void updateStu(int id) {

    }

    @Override
    public void deleteStu(int id) {

    }

    @Override
    public void saveParent() {
        Stu parent = new Stu();
        parent.setAge(10);
        parent.setName("ab");
        stuMapper.insert(parent);
    }

    @Override
    public void saveChild() {
        Stu child= new Stu();
        child.setName("bc");
        child.setAge(2);
        stuMapper.insert(child);
    }
}
