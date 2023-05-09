package com.example.demo.c_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC中默认返回一个静态页面
 * 写成 index 会获取失败，也可以直接写 index.html
 * 静态页面要放在 static 里面
 */
@Controller
public class A_ReturnPage {
    @RequestMapping("/return-page")
    public String returnPage() {
        return "/index.html";
    }
}
