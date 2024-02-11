package com.example.myproject.result.IpAnalyzeAddress;

import com.example.myproject.result.IpAnalyzeAddress.IpAnalyzeContent;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


/**
 * @author fengjiaqi
 * @description 地址解析的结果
 * @date 2023/11/11 20:43
 */
@Data
@Builder
public class IpAnalyzeBaiduResponse implements Serializable {

    /**
     * 返回状态码
     */
    private Integer status;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 地址
     */
    private String address;

    /**
     * 详细内容
     */
    private IpAnalyzeContent content;

}