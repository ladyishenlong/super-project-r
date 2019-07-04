package com.ladyishenlong.oauth2authsqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * oauth2 单点登录 授权服务器
 *
 * 参考地址：https://www.funtl.com/zh/spring-security-oauth2/
 *
 * <p>
 * （A）用户访问客户端，客户端将用户引导向认证服务器。
 * （B）用户选择是否给予客户端授权。
 * （C）如用户给予授权，认证服务器将用户引导向客户端指定的redirection uri，同时加上授权码code。
 * （D）客户端收到code后，通过后台的服务器向认证服务器发送code和redirection uri。
 * （E）认证服务器验证code和redirection uri，确认无误后，响应客户端访问令牌（access token）和刷新令牌（refresh token）
 *
 * 获取code的地址
 *
 * http://localhost:5002/oauth/
 * authorize?client_id=123&response_type=code&redirect_uri=http://localhost:5003/getCode
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2AuthSqrApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthSqrApplication.class, args);
    }

}
