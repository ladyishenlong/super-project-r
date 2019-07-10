package com.ladyishenlong.oauth2clientsqr.controller;

import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * @Author ruanchenhao
 * @Date 2019-07-08 15:34
 * <p>
 * oauth2协议下的登录方式
 * 1. 输入账号密码，获取token
 * 2. 从第三方获得code，再获取token
 * 3. 请求头传入token，通过验证
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RestTemplate restTemplate;


    /**
     * 前端接入的登录接口
     *
     * 需要改为post请求，传入用户名和密码
     *
     *
     * @throws Exception
     */
    @GetMapping("/login")
    public ResponseEntity login() throws Exception {

        //spring-cloud-oauth2 登录验证的地址
        URI oauthUrl = new URIBuilder("http://localhost:5002/oauth/authorize")
                .addParameter("client_id", "123")
                .addParameter("response_type", "code")
                .addParameter("redirect_uri", "http://localhost:5003/user/code")
                .build();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //http 配置信息
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000) // 设置连接超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)// 设置请求超时时间(单位毫秒)
                .setSocketTimeout(5000)// socket读写超时时间(单位毫秒)
                .setRedirectsEnabled(false)// 设置是否允许重定向(默认为true)
                .build();


        HttpGet oauthHttpGet = new HttpGet(oauthUrl);
        oauthHttpGet.setConfig(requestConfig);//将上面的配置信息 运用到这个Get请求里

        //响应模型 由客户端执行(发送)Get请求
        CloseableHttpResponse response = httpClient.execute(oauthHttpGet);


        //返回的是重定向302
        if (response.getStatusLine().getStatusCode() == HttpStatus.FOUND.value()) {

            //获取Set-Cookie成为登录页面的cookie
            String setCookie = response.getFirstHeader("Set-Cookie").getValue();
            String cookie = setCookie.substring(0, setCookie.indexOf(";"));

            //登录页面获取token
            MultiValueMap<String, String> loginParams = new LinkedMultiValueMap<>();
            loginParams.add("username", "123");
            loginParams.add("password", "123");

            //添加cookie
            HttpHeaders loginHeader = new HttpHeaders();
            loginHeader.set("Cookie", cookie);

            HttpEntity<MultiValueMap<String, String>> loginEntity =
                    new HttpEntity<>(loginParams, loginHeader);

            String loginUrl = "http://localhost:5002/login";


            ResponseEntity<String> loginResult = restTemplate.
                    postForEntity(loginUrl, loginEntity, String.class);

            log.info("---- 登录请求结果：{} ----", loginResult);

            return loginResult;

        }

        // 释放资源
        httpClient.close();
        response.close();

        return null;
    }


    /**
     * 获取授权码code，再请求获取token
     *
     * @param code
     * @return
     */
    @GetMapping("/code")
    public ResponseEntity code(@RequestParam("code") String code) {

        log.info("---- 获取授权码：{} ----", code);

        MultiValueMap<String, String> tokenParams = new LinkedMultiValueMap<>();
        tokenParams.add("grant_type", "authorization_code");
        tokenParams.add("code", code);
        tokenParams.add("client_id", "123");
        tokenParams.add("client_secret", "123");
        tokenParams.add("redirect_uri", "http://localhost:5003/user/code");
        tokenParams.add("scope", "all");

        HttpHeaders tokenHeader = new HttpHeaders();
        tokenHeader.set("Content-Type", "multipart/form-data");
        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<>(tokenParams, tokenHeader);

        ResponseEntity<String> tokenResult = restTemplate.postForEntity(
                "http://localhost:5002/oauth/token", requestEntity, String.class);


        log.info("---- 获取token结果：{} ----", tokenResult);


        String token = new JsonParser().parse(tokenResult.getBody()).
                getAsJsonObject().get("access_token").getAsString();

        log.info("---- access_token：{} ----", token);

        //访问资源服务，仅仅能用来验证登录效果
        HttpHeaders resourceHeader = new HttpHeaders();
        resourceHeader.set("Authorization", "Bearer " + token);

        ResponseEntity<String> resourceResult = restTemplate.exchange(
                "http://localhost:5004/getResource", HttpMethod.GET,
                new HttpEntity<String>(null, resourceHeader), String.class);

        log.info("获取资源的结果：{}", resourceResult);

        return tokenResult;
    }


}
