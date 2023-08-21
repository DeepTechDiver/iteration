package com.example.myproject.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.myproject.result.ResponseResult;
import com.example.myproject.result.ResponseStatus;
import com.example.myproject.result.bo.UpPasswdBO;
import com.example.myproject.result.bo.UserLoginBO;
import com.example.myproject.entity.User;
import com.example.myproject.mapper.UserMapper;
import com.example.myproject.result.bo.UserRegisterBO;
import com.example.myproject.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author FengJiaqi
 * @since 2023-08-17
 */
@Service
@Log4j2
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    /**
     * 登录
     *
     * @param userLoginBO 登录Bean
     * @return true：成功 false：失败
     */
    public boolean isLogin(UserLoginBO userLoginBO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        userLoginBO.setPassword(SecureUtil.md5(userLoginBO.getPassword()));
        queryWrapper.eq("username", userLoginBO.getUsername())
                .eq("password", userLoginBO.getPassword());
        User user = userMapper.selectOne(queryWrapper);
        return user != null ? true : false;
    }

    public ResponseResult register(UserRegisterBO userRegisterBO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userRegisterBO.getUsername())
                .eq("nickname", userRegisterBO.getNickname())
                .eq("password", userRegisterBO.getPassword());
        User userOne = userMapper.selectOne(queryWrapper);
        if (userOne != null){
            log.info("注册失败：用户注册信息上链失败");
            return ResponseResult.fail(ResponseStatus.resgister_fail,null);
        }
        //拷贝对象
        User user = new User();
        BeanUtils.copyProperties(userRegisterBO, user);
        user.setPassword(SecureUtil.md5(user.getPassword()));//md5加密密码

        //Mysql插入user数据
        int result = userMapper.insert(user);
        return result > 0 ? ResponseResult.success() : ResponseResult.fail("数据插入失败");
    }

    //从数据库查询获取账户地址
    public ResponseResult updatePassword(UpPasswdBO upPasswdBO) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", upPasswdBO.getUsername());

        User userOne = userMapper.selectOne(queryWrapper);
        if (userOne == null) {
            log.info("修改失败：用户不存在");
            return ResponseResult.fail(ResponseStatus.USER_NOT_EXIST, "修改失败：用户不存在");
        }
        if (!userOne.getPassword().equals(SecureUtil.md5(upPasswdBO.getPassword()))) {
            log.info("修改失败：密码错误");
            return ResponseResult.fail(ResponseStatus.USER_CREDENTIALS_ERROR, "修改失败：密码错误");
        }
        User updateUser = new User();
        updateUser.setId(userOne.getId());
        updateUser.setPassword(SecureUtil.md5(upPasswdBO.getNewPassword()));
        int result = userMapper.update(updateUser, queryWrapper);
        return result > 0 ? ResponseResult.success() : ResponseResult.fail("更新数据失败");
    }
}
