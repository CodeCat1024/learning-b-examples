package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.mapper") // 扫描mapper包下，带@Mapper注解的接口
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
