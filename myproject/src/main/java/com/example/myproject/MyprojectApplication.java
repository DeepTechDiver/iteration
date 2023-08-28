package com.example.myproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.myproject.mapper")
@SpringBootApplication
public class MyprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyprojectApplication.class, args);
    }
}