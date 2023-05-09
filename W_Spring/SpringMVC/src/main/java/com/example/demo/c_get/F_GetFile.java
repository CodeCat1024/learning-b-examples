package com.example.demo.c_get;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 接收文件
 */
@RestController
public class F_GetFile {
    @PostMapping("/getfile")
    public String getFile(Integer id, @RequestPart("添加一小段正文文字.png") MultipartFile file) {
        try {
            // 1.获取源文件名
            String fileName = file.getOriginalFilename();

            // 2.生成唯一文件名
            //fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));

            // 3.将文件存放到本地中
            file.transferTo(new File("D:\\" + fileName));

            // 4.返回响应给前端
            return "上传文件成功！";
        } catch (IOException e) {
            return "上传文件失败！";
        }
    }
}
