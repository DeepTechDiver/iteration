package com.example.myproject.result.IpAnalyzeAddress;

import lombok.Data;
import java.io.Serializable;


/**
 * @author fengjiaqi
 * @description 百度经纬度坐标值
 * @date 2023/11/11 20:43
 */
@Data
public class IpAnalyzePoint implements Serializable {

    private String x;

    private String y;
}