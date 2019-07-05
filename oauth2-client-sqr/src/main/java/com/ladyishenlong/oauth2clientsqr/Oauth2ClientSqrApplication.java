package com.ladyishenlong.oauth2clientsqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * 客户访问的服务器
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2ClientSqrApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientSqrApplication.class, args);
    }

}
