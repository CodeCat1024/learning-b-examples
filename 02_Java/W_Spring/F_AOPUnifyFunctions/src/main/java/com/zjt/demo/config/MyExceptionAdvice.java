package com.zjt.demo.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * 统一异常处理
 */
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

    // 设置所有异常的父类，处理所有的异常
    @ExceptionHandler(Exception.class)
    public HashMap<String, Object> exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("msg", "异常：" + e.getMessage());
        return result;
    }
}
