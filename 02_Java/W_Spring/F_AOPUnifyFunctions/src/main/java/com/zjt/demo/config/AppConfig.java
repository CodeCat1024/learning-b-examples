package com.zjt.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 为拦截器设置拦截规则
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntercept loginIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器设置
        registry.addInterceptor(loginIntercept).
                addPathPatterns("/**"). // 拦截所有的url
                excludePathPatterns("/user/login").  // 设置所有不拦截的url
                excludePathPatterns("/user/reg").
                excludePathPatterns("/login.html").
                excludePathPatterns("/**/*.js").
                excludePathPatterns("/**/*.css").
                excludePathPatterns("/**/*.png").
                excludePathPatterns("/**/*.jpg");

        // 有多个拦截器就继续写
        // registry.addInterceptor();
    }

    // 拓展：给所有的url加前缀（测试的时候拦截器会干扰到这个功能）
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("api", c -> true);
//    }
}
