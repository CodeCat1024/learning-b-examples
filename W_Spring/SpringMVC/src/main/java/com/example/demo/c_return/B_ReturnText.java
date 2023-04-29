package com.example.demo.c_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 返回 text/html
 */

// @RestController
@ResponseBody
@Controller
public class B_ReturnText {
    @RequestMapping("/returntext")
    public String returnText() {
        return "<h1>Hello World!</h1>";
    }
}
