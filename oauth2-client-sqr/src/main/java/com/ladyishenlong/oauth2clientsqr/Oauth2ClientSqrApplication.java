package com.ladyishenlong.oauth2clientsqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 客户访问的服务器
 *
 * 与资源服务器和授权服务器不在同一个注册中心
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2ClientSqrApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientSqrApplication.class, args);
    }

}
