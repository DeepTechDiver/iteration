package com.example.myproject.controller;


import com.example.myproject.config.JwtProperties;
import com.example.myproject.entity.User;
import com.example.myproject.result.JwtResult;
import com.example.myproject.result.Result;
import com.example.myproject.result.dto.UserLoginDTO;
import com.example.myproject.result.vo.UserLoginVO;
import com.example.myproject.service.impl.UserServiceImpl;
import com.example.myproject.util.TokenUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtProperties jwtConfig;

    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("微信登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("微信用户登录：{}",userLoginDTO.getCode());

        //微信登录
        User user = userService.wxLogin(userLoginDTO);//后绪步骤实现

        //为微信用户生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtResult.USER_ID,user.getId());

//        String token = JwtUtil.createJWT(jwtConfig.getUserSecretKey(), jwtConfig.getUserTtl(), claims);
        String token = TokenUtil.createJWT(userLoginDTO.getCode(),String.valueOf(System.currentTimeMillis()));



        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .openid(user.getOpenid())
                .token(token)
                .build();
        return Result.success(userLoginVO);
    }


//    @GetMapping("/findAll")
//    public List<User> query() {
//        List<User> res =  userMapper.findAll();
//        return res;
//    }

}