package com.example.demo.c_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求转发，发生在服务端，在客户端看不出区别
 * 服务器收到请求后，从一个服务器资源跳转到另一个服务器资源，forward:可以省略不写
 * 也就是拿到服务器的来信之后，再把信转交给别人
 */
@Controller
public class D_Forward {
    @RequestMapping("/forward")
    public String forward() {
        //return "forward:/index.html";
        //return "forward:/hello";
        return "/hello";
    }
}
