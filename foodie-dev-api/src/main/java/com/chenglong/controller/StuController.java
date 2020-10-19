package com.chenglong.controller;

import com.chenglong.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 9:27
 */
@ApiIgnore
@RestController
public class StuController {
    @Autowired
    private StuService stuService;

    @GetMapping("/getStu")
    public Object getStu(int id){
        return stuService.getSutInfo(id);
    }
}
