package com.demo.usermanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  系统配置文件类
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    // 加入自定义的登录拦截器
    @Autowired
    private LoginIntercept loginIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercept).
                addPathPatterns("/**").
                excludePathPatterns("/login").
                excludePathPatterns("/css/**").
                excludePathPatterns("/fonts/**").
                excludePathPatterns("/images/**").
                excludePathPatterns("/js/**").
                excludePathPatterns("/login.html");

    }
}
