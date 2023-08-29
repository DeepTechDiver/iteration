package com.example.myproject.controller;


import cn.hutool.core.lang.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class WebController {
    private static final String UPLOADED_FOLDER = System.getProperty("/upload") + "/upload";

    @RequestMapping("/user")
    public Dict getUser(){
        Dict user = new Dict();
        user.set("姓名", "张三");
        user.set("密码", "123");
        return user;
    }

    @ApiOperation(value = "上传文件",notes = "通过form-data上传文件")
    @PostMapping("/up")
    public String upload(String nickname, MultipartFile f) throws IOException {
        System.out.println("文件大小:"+f.getSize());
        System.out.println(f.getContentType());
        System.out.println(f.getOriginalFilename());
        System.out.println(System.getProperty(""));
        saveFile(f);
        return "上传成功";
    }

    //保存文件方法
    public void saveFile(MultipartFile f) throws IOException {
        File upDir = new File(UPLOADED_FOLDER);
        if(!upDir.exists()){
            upDir.mkdir();
        }
        File file = new File(UPLOADED_FOLDER+f.getOriginalFilename());
        f.transferTo(file);
    }
}
