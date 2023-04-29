package com.example.demo.c_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求转发
 * 转发发生在服务端，在客户端看不出区别
 * forward 可以省略，也就是跟返回静态页面是一样的
 */
@Controller
public class D_Forward {
    @RequestMapping("/forward")
    public String forward() {
        return "forward:/index.html";
    }
}
