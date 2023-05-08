package com.example.demo.a_connection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC创建连接中的三个注解示例
 * 类和方法都可以加上注解，若类加上注解则路径变为：/hello/request
 * RequestMapping 可以接收所有的请求方法
 * 也可以设置只接收某个方法 @RequestMapping(value = "/sayHi", method = RequestMethod.POST)
 * GetMapping 只能接收 Get方法，PostMapping 只能接收 Post 方法
 */

// 1.收到来信  2.处理来信  3.写回信并寄出
@Controller
public class Mapping {
    @RequestMapping("/request")
    public String sayHi() {
        return "/index.html";
    }

    @GetMapping("/get")
    public String sayHi2() {
        return "Hello Get";
    }

    @PostMapping("/post")
    public String sayHi3() {
        return "Hello Post";
    }
}
