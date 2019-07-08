package com.ladyishenlong.oauth2clientsqr.controller;

import com.ladyishenlong.oauth2clientsqr.config.BanRedirectStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ruanchenhao
 * @Date 2019-07-08 15:34
 *
 * oauth2协议下的登录方式
 * 1. 输入账号密码，获取token
 * 2. 从第三方获得code，再获取token
 * 3. 请求头传入token，通过验证
 */
@Slf4j
@RestController
public class OAuth2Controller {

    @Autowired
    RestTemplate restTemplate;



    @GetMapping("/login2")
    public ResponseEntity login(){


        String oauthUrl = "http://localhost:5002/oauth/authorize?client_id=123&response_type=code&redirect_uri=http://localhost:5003/getCode";


        ResponseEntity<String> result = restTemplate.getForEntity(oauthUrl, String.class);

        log.info("重定向："+result);
        return result;
    }



}
