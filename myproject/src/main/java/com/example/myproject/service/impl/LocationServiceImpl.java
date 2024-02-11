package com.example.myproject.service.impl;

import cn.hutool.core.lang.Dict;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.myproject.Exception.GetAddressException;
import com.example.myproject.Exception.LoginFailedException;
import com.example.myproject.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class LocationServiceImpl {

    public static String URL = "https://api.map.baidu.com/location/ip?";

    @Value("${baidu.ak}")
    private String AK;

    public Dict getAddress(String url) throws Exception{
        Map map = new HashMap();
        map.put("ip", url);
        map.put("coor", "bd09ll");
        map.put("ak", AK);
        String res = HttpClientUtil.doGet(URL, map);
        JSONObject jsonObject = JSON.parseObject(res);

        Dict result = new Dict();
        if (jsonObject.getString("status").equals("0")) {
            //数据解析经纬度
            JSONObject location = jsonObject.getJSONObject("content");
            String x = location.getJSONObject("point").getString("x");
            String y = location.getJSONObject("point").getString("y");
            String city = location.getString("address");
            result.set("address", city);
            result.set("x", x);
            result.set("y", y);
        }
        if (jsonObject.getString("status").equals("1")) {
            String message = jsonObject.getString("message");
            result.set("message", message);
        }
        return result;
    }


}