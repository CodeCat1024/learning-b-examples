package com.example.demo.c_get;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收对象
 */

@RestController
public class C_GetObject {
    @RequestMapping("/getuserinfo")
    public String getUserInfo(UserInfo userInfo){
        return "接收到的对象为：" + userInfo;
    }
}
