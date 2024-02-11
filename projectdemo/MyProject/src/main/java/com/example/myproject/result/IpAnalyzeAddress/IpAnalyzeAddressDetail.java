package com.example.myproject.result.IpAnalyzeAddress;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fengjiaqi
 * @description 详细地址信息
 * @date 2023/11/11 20:43
 */
@Data
public class IpAnalyzeAddressDetail implements Serializable {

    /**
     * 城市
     */
    private String city;

    /**
     * 百度城市代码
     */
    @JsonProperty("city_code")
    private Integer cityCode;

    /**
     *  区县
     */
    private String district;

    /**
     *  省份
     */
    private String province;

    /**
     * 街道
     */
    private String street;

    /**
     * 门地址
     */
    @JsonProperty("street_number")
    private String streetNumber;

}