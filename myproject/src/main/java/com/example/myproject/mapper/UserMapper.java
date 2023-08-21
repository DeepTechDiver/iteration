package com.example.myproject.mapper;

import com.example.myproject.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author FengJiaqi
 * @since 2023-08-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
