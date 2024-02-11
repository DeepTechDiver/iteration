package com.example.myproject.result.IpAnalyzeAddress;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author fengjiaqi
 * @description 详细内容
 * @date 2023/11/11 20:50
 */
@Data
public class IpAnalyzeContent implements Serializable {

    /**
     * 简要地址
     */
    private String address;

    /**
     * 详细地址信息
     */
    @JsonProperty("address_detail")
    private IpAnalyzeAddressDetail addressDetail;

    /**
     *  百度经纬度坐标值
     */
    @JsonProperty("point")
    private IpAnalyzePoint point;

}