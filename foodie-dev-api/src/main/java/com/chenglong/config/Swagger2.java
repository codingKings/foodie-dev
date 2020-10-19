package com.chenglong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: 程龙
 * @Date: 2020-10-16 20:29
 */

@Configuration
@EnableSwagger2
public class Swagger2 {
    //配置swagger2核心配置 docket  提供的是http://localhost:8088/swagger-ui.html,http://localhost:8088/doc.html
    @Bean
    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2) //指定api类型为swagger2
                .apiInfo(apiInfo())  //用于定义api文档汇总信息
                .select().apis(RequestHandlerSelectors.basePackage("com.chenglong.controller"))//指定的controller包
                .paths(PathSelectors.any()) //所有controller
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("我的电商平台接口api") //文档页标题
                .contact(new Contact("chenglong","https","abc@163.com"))
                .description("专为我的商城提供的api文档") //详细信息
                .version("1.0.0") //文档版本号
                .termsOfServiceUrl("http") //网站地址
                .build();
    }
}
