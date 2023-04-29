package com.example.demo.a_get;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收 JSON 对象
 */
@RestController
public class D_GerJsonParameter {
    @RequestMapping("/getjsonparameter")
    public String getJsonParameter(@RequestBody UserInfo userInfo) {
        return "接收到的JSON对象为： " + userInfo;
    }
}
