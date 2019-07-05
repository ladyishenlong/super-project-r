package com.ladyishenlong.oauth2authsqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * oauth2 单点登录 授权服务器
 * 参考地址：https://www.funtl.com/zh/spring-security-oauth2/
 *
 *
 *
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2AuthSqrApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthSqrApplication.class, args);
    }

}
