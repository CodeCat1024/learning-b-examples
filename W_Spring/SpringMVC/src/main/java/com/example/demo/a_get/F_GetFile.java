package com.example.demo.a_get;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class F_GetFile {
    public String getFile(Integer id, @RequestPart("img") MultipartFile file) {
        return "接收到的文件为：" ;
    }
}