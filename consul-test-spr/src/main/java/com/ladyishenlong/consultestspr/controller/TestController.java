package com.ladyishenlong.consultestspr.controller;

import com.ladyishenlong.consultestspr.bean.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.PhantomReference;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 10:31
 */
@Slf4j
@RestController
public class TestController {


    @Autowired
    private Config config;

    @GetMapping("/getProjectName")
    public String getProjectName() {
        return config.getProjectName();
    }
}
