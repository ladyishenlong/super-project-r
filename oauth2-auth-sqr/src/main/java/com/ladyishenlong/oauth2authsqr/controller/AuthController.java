package com.ladyishenlong.oauth2authsqr.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ruanchenhao
 * @Date 2019-07-02 09:07
 */
@Deprecated
@Slf4j
@RestController
public class AuthController {


    /**
     * 获取验证的code
     *
     * http://localhost:5002/oauth/authorize?client_id=123&
     * response_type=code&redirect_uri=http://localhost:5002/getCode
     *
     * @param code
     * @return
     */
    @GetMapping("/getCode")
    public String getCode(@RequestParam("code") String code) {
        return code;
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello 验证服务器";
    }



}
