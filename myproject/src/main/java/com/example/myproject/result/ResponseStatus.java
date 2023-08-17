package com.example.myproject.result;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ResponseStatus {

    SUCCESS("200", "success"),
    FAIL("500", "failed"),

    HTTP_STATUS_200("200", "ok"),
    HTTP_STATUS_400("400", "request error"),
    HTTP_STATUS_401("401", "no authentication"),
    HTTP_STATUS_403("403", "no authorities"),
    HTTP_STATUS_500("500", "server error"),

//    /* 用户错误 */
    resgister_fail("2004","用户注册信息失败"),
    USER_NOT_EXIST("2001", "用户不存在"),
    USER_ACCOUNT_EXPIRED("2002", "账号已过期"),
    USER_CREDENTIALS_ERROR("2003", "密码错误");
//
//    ERROR("500", "失败"),
//    SYSTEM_ERROR("501", "系统错误"),
//    UNKNOWN_ERROR("502", "未知错误"),
//
//    /* 参数错误：1000～1999 */
//    PARAM_NOT_VALID("1001", "参数无效"),
//    PARAM_IS_BLANK("1002", "参数为空"),
//    PARAM_TYPE_ERROR("1003", "参数类型错误"),
//    PARAM_NOT_COMPLETE("1004", "参数缺失"),
//    PARAM_TYPE_REPEAT("1005","参数重复"),
//
//    /* 业务错误 */
//    NO_PERMISSION("3001", "没有权限"),
//    ADD_FAIL("3002", "新增失败"),
//    UPDATE_FAIL("3003", "更新失败"),
//    DELETE_FAIL("3004", "删除失败"),
//    QUERY_FAIL("3005", "查询失败"),
//    QUERY_EMPTY("3006", "查询为空"),
//    QUERY_NOT_EXIST("3007", "查询不存在");

    public static final List<ResponseStatus> HTTP_STATUS_ALL = Collections.unmodifiableList(
            Arrays.asList(HTTP_STATUS_200,
                    HTTP_STATUS_400,
                    HTTP_STATUS_401,
                    HTTP_STATUS_403,
                    HTTP_STATUS_500,
                    USER_NOT_EXIST,
                    USER_CREDENTIALS_ERROR,
                    USER_ACCOUNT_EXPIRED,
                    resgister_fail
            ));

    /**
     * response code
     */
    private final String responseCode;

    /**
     * description.
     */
    private final String description;

}