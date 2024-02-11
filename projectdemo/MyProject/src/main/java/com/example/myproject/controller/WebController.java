package com.example.myproject.controller;

import cn.hutool.core.lang.Dict;
import com.example.myproject.result.Result;
import com.example.myproject.service.impl.LocationServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@Log4j2
@RestController
@RequestMapping("/web")
public class WebController {

    @Autowired
    LocationServiceImpl locationService;

    @GetMapping("/test")
    @ApiOperation("获取位置信息")
    public Result get(@RequestParam String ipaddress) throws Exception{
        Dict info = locationService.getAddress(ipaddress);
        return Result.success(info);
    }


}
