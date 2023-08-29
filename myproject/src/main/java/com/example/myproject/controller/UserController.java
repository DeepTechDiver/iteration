package com.example.myproject.controller;


import com.example.myproject.entity.User;
import com.example.myproject.mapper.UserMapper;
import com.example.myproject.result.ResponseResult;
import com.example.myproject.result.ResponseStatus;
import com.example.myproject.result.bo.UserLoginBO;
import com.example.myproject.result.bo.UserRegisterBO;
import com.example.myproject.service.impl.UserServiceImpl;
import com.example.myproject.util.TokenUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "登录",notes = "输入用户名和密码登录")
    @ApiImplicitParam(name = "loginBean",value = "用户登录信息",required = true,dataType = "LoginBean")
    @PostMapping("/login")
    public ResponseResult login(@RequestBody UserLoginBO userLoginBO) {
        log.info(userLoginBO.toString());
        if (userService.isLogin(userLoginBO)) {
            //创建
            String token = TokenUtil.sign(userLoginBO.getUsername(),String.valueOf(System.currentTimeMillis()));

            return ResponseResult.success(token);
        } else {
            return ResponseResult.fail(ResponseStatus.USER_ACCOUNT_EXPIRED, null);
        }
    }

    @ApiOperation(value = "注册",notes = "根据填写信息注册")
    @ApiImplicitParam(name = "registerBean",value = "用户注册信息",required = true,dataType = "RegisterBean")
    @PostMapping("/register")
    public ResponseResult register(@RequestBody UserRegisterBO userRegisterBO) {
        log.info(userRegisterBO.toString());
        if (userService.register(userRegisterBO) != null) {
            return ResponseResult.success();
        } else {
            return ResponseResult.fail("注册失败");
        }
    }

    @GetMapping("/findAll")
    public List<User> query() {
        List<User> res =  userMapper.findAll();
        return res;
    }

}