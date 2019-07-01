package com.ladyishenlong.consultestspr.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 10:31
 */
@Slf4j
@RestController
public class TestController {

    @Value("${project-name}")
    private String projectName;

    @GetMapping("/getProjectName")
    public String getProjectName() {
        return projectName;
    }
}
