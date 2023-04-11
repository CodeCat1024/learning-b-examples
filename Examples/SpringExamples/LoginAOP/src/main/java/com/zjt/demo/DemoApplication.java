package com.zjt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * a.实现自定义拦截器，实现Spring中的HandlerInterceptor接口中的preHandler方法
 * b.将自定义拦截器加入到框架的配置中，并且设置拦截规则
 *   1.给当前的类添加@Configuration注解
 *   2.实现WebMvcConfiguration接口
 *   3.重写addInterceptors方法
 */

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
