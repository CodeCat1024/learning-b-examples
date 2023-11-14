package com.example.demo.c_get;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收 JSON 对象
 * JSON 对象只能存放在 POST 请求的 body 中
 * 所以我们可以使用 @RequestBody
 */
@RestController
public class E_GetJsonParameter {
    @RequestMapping("/getjsonparameter")
    public String getJsonParameter(@RequestBody UserInfo userInfo) {
        return "接收到的JSON对象为： " + userInfo;
    }
}
