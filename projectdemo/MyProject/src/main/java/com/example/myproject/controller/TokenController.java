package com.example.myproject.controller;

import com.example.myproject.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TokenController {

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping("/token")
    public String getToken() {
        String userInfo = "Test";
        return tokenUtil.createJWT(userInfo, String.valueOf(System.currentTimeMillis()));
    }

    @PostMapping("/test")
    public String test(@RequestHeader(value = "token") String token) {
        boolean result = tokenUtil.parseJWT(token);
        return result ? "正常调用" : "重复调用";
    }

}