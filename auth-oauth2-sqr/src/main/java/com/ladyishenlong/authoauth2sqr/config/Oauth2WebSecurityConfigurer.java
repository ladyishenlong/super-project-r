package com.ladyishenlong.authoauth2sqr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 11:54
 */
@EnableWebSecurity
public class Oauth2WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                //需要放行登录和身份验证的地址
                .antMatchers("/login/**", "/oauth/**")
                .and().authorizeRequests().anyRequest().authenticated()
                .and().formLogin().permitAll();
    }

}
