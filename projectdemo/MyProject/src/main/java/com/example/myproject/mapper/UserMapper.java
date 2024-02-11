package com.example.myproject.mapper;

import com.example.myproject.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 根据userId查询用户
     * @param userId
     */
    @Select("select * from user where id = #{id}")
    User getById(Long userId);

    Integer countByMap(Map map);
}
