package com.ladyishenlong.oauth2authsqr.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 11:54
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class Oauth2WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                //放行登录和身份验证接口
                .antMatchers("/login").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }

}
