package com.example.demo.b_return;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 返回 json 对象
 */
@RestController
public class C_ReturnJSON {
    @RequestMapping("/returnjson")
    public HashMap<String, Object> returnJson() {
        HashMap<String, Object> result = new HashMap<String, Object>();

        int age = 18;
        String username = "张三";
        String sex = "男";

        result.put("age", age);
        result.put("username", username);
        result.put("sex", sex);

        return result;
    }
}
