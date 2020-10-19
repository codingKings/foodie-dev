package com.chenglong.service.impl;

import com.chenglong.service.StuService;
import com.chenglong.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 10:10
 */

@Service
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StuService stuService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testProgagationTrans() {
        stuService.saveChild();
        int i = 10/0;
        stuService.saveParent();
    }
}
