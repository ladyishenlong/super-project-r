package com.ladyishenlong.gatewaysqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * gateway 网关服务
 *
 * 参考 https://windmt.com/2018/05/07/spring-cloud-13-spring-cloud-gateway-router/
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewaySqrApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySqrApplication.class, args);
    }

}
