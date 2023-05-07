package com.example.demo.b_get;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收单个参数，参数重命名，设置参数非必传
 * 获取整型时请使用 Integer
 */
@RestController
public class A_GetParameter {
    @RequestMapping("/getparameter")
    public String getId(String id) {
        return "接收到的id为： " + id;
    }

    @RequestMapping("/rename")
    public String reName(@RequestParam("id") String myId) {
        return "接收到的id为： " + myId;
    }

    // 设置了参数重命名之后，默认参数必传，使用 required 参数可以设置是否必须传递
    @RequestMapping("/mustpass")
    public String mustPass(@RequestParam(value = "id", required = false) String myId) {
        return "接收到的id为： " + myId;
    }
}
