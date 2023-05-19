package com.zjt.demo.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

/**
 * 返回统一的数据格式
 */
@ControllerAdvice
public class MyResponseAdvice implements ResponseBodyAdvice {
    /**
     * 返回一个boolean值
     * true表示返回数据之前对数据进行重写，也就是会进入下面的方法再返回
     * false表示对结果不进行任何处理，直接返回
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", 1);
        result.put("data", body);
        result.put("msg", "");

        return result;
    }
}
