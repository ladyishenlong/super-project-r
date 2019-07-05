package com.ladyishenlong.oauth2clientsqr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ruanchenhao
 * @Date 2019-07-03 17:19
 */
@RestController
public class HelloController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello oath2 client";
    }

    @GetMapping("/getResource")
    public String getResource() {
        return restTemplate.getForObject("http://localhost:5004/getResource",String.class);
    }

}
