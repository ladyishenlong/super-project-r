package com.ladyishenlong.authoauth2sqr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 11:51
 */
@Configuration
@EnableAuthorizationServer //授权服务器
public class Oauth2AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("123").secret("123") //客户端 id/secret
                .authorizedGrantTypes("authorization_code") //授权码模式
                .scopes("app")
                .redirectUris("http://localhost:5003/getResource")
                .autoApprove(true) //自动审批
                .accessTokenValiditySeconds(36000)//有效期10hour
        ;
    }
}
