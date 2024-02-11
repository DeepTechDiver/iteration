package com.example.myproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author FengJiaqi
 * @since 2023-08-17
 */
@Getter
@Setter
@Builder
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //微信用户唯一标识
    @TableField("openid")
    private String openid;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    //注册时间
    @TableField("createTime")
    private LocalDateTime createTime;
}
