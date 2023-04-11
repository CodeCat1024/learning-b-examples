package com.zjt.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntercept loginIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器设置
        registry.addInterceptor();

        //
    }
}
