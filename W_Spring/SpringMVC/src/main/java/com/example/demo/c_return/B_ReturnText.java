package com.example.demo.c_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 返回 text/html
 */

// @RestController = @ResponseBody + @Controller
@ResponseBody // 加上该注解则表示返回非静态页面，也就是直接返回字符串
@Controller
public class B_ReturnText {
    @RequestMapping("/return-text")
    public String returnText() {
        return "<h1>Hello World!</h1>";
    }
}
