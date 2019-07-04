package com.ladyishenlong.oauth2resourcesqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 参考
 * https://kefeng.wang/2018/04/06/oauth2-sso/
 * http://www.iocoder.cn/Spring-Security/OAuth2-learning/?vip
 *
 * 用get方法获取code，然后用code获取tokenId
 *
 * 尝试参考
 * https://blog.csdn.net/weixin_41833171/article/details/86570278
 *
 */
@SpringBootApplication
public class Oauth2ResourceSqrApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ResourceSqrApplication.class, args);
    }

}
