package com.ladyishenlong.resourceoauth2spr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 13:24
 */
@RestController
public class ResourceController {

    @GetMapping("/getResource")
    public String getResource() {
        return "获取资源";
    }

}
