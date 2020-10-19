package com.chenglong;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: 程龙
 * @Date: 2020-10-15 15:24
 */

@SpringBootApplication
@MapperScan(basePackages = "com.chenglong.mapper")//扫描mybatis通用mapper所在的包
@ComponentScan(basePackages = {"com.chenglong","org.n3r.idworker"})//扫描所有包已经相关组件包
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
