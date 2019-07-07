package com.ladyishenlong.consultestspr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * consul 的key/value储存可以类比spring-cloud-config
 * 配置文件可以写在consul上使用
 *
 * 同样需要加入actuator检测健康状态
 *
 * consul使用docker部署集群
 *
 *  参考 https://www.jianshu.com/p/7487ef33ab8a
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulTestSprApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulTestSprApplication.class, args);
    }

}
