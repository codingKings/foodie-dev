package com.chenglong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author: 程龙
 * @Date: 2020-10-15 15:28
 */
@ApiIgnore
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Object hello(){
        return "hello world";
    }
}
