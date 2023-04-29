package com.example.demo.b_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 返回静态页面
 * 写成 index 会获取失败，也可以直接写 index.html
 * 静态页面要放在 static 里面
 */
@Controller
public class A_RetrunPage {
    @RequestMapping("/returnpage")
    public String returnPage() {
        return "/index.html";
    }
}
