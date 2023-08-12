package com.example.myproject.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/setGet")
    public String setGetvalue(String key,String value) {
        redisTemplate.opsForValue().set(key,value);
        return (String) redisTemplate.opsForValue().get(key);
    }
}
