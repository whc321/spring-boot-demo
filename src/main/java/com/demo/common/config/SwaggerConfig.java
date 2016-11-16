package com.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by wang_haichun on 2016/11/15.
 */
@Configuration
//@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths(or(regex("/api/.*")))
                .build()
                .apiInfo(demoApiInfo());
    }
    private ApiInfo demoApiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "SPRING BOOT AND SWAGGER TEST API",//大标题
                "Test REST API, all the applications could access the Object model data via JSON.",//小标题
                "1.0",//版本
                "NO terms of service",//服务条款
                "493275399@qq.com",//作者
                "Spring Boot Demo",//链接显示文字
                "http://localhost:8180/demo/"//网站链接
        );
        return apiInfo;
    }
}
