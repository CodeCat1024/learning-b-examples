package com.example.demo.b_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class B_NoResponseBody {
    @RequestMapping("noresponsebody")
    public String noResponseBody() {
        //return "forward:/index.html";
        return "forward:/responsebody";
    }
}
