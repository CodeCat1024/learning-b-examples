package com.zjt.demo.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class MyExceptionAdvice {


    // 处理算术异常
    @ExceptionHandler(ArithmeticException.class)
    public HashMap<String, Object> arithmeticExceptionAdvice(ArithmeticException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("msg", "算术异常：" + e.getMessage());
        return result;
    }

    // 处理空指针异常
    @ExceptionHandler(NullPointerException.class)
    public HashMap<String, Object> nullPointerExceptionAdvice(NullPointerException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("msg", "空指针：" + e.getMessage());
        return result;
    }

    // 但一个一个写太累了，所以我们可以设置所有异常的父类
    @ExceptionHandler(Exception.class)
    public HashMap<String, Object> exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("msg", "异常：" + e.getMessage());
        return result;
    }
}
