package com.dragon.blog.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dragon
 * @Date 2023/5/12 17:07
 * @Description 发送外部请求工具类
 */
public class HttpUtil {

    public static JSONObject postReq(String url, Object o) {
        RestTemplate restTemplate = new RestTemplate();
        //创建请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        //此处相当于在header里头添加content-type等参数
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        JSONObject j = (JSONObject) JSONObject.toJSON(o);
        //创建请求体并添加数据
        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(j, httpHeaders);
        ResponseEntity<String> forEntity = restTemplate.postForEntity(url, httpEntity, String.class);//此处三个参数分别是请求地址、请求体以及返回参数类型

        return JSONObject.parseObject(forEntity.getBody());
    }

}
