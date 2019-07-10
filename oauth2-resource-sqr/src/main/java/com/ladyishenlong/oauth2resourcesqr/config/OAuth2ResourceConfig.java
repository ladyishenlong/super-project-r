package com.ladyishenlong.oauth2resourcesqr.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 14:48
 *
 */
@EnableOAuth2Sso //添加这个注解才会跳转到授权服务器
@Configuration
@EnableResourceServer//资源服务器
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                //放行登录和身份验证接口
//                .antMatchers("/login").permitAll()
//                .antMatchers("/oauth/**").permitAll()
//                .antMatchers("/getCode").permitAll()
//                .and()
//                .formLogin().permitAll()
                ;
    }

}
