package com.ladyishenlong.oauth2resourcesqr.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 13:24
 */
@Slf4j
@RestController
public class ResourceController {

    @GetMapping("/getResource")
    public String getResource(Principal principal) {
        return "获取资源"+principal.getName();
    }


    @GetMapping("/getCode")
    public String getCode(@RequestParam("code")String code){
        log.info("获得code：{}",code);
        return code;
    }

}
