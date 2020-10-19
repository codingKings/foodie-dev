package com.test;

import com.chenglong.Application;
import com.chenglong.service.StuService;
import com.chenglong.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 10:04
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

    //@Test
    public void testProgagationTrans(){
        testTransService.testProgagationTrans();
    }
}
