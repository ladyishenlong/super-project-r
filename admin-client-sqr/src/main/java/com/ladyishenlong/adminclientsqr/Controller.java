package com.ladyishenlong.adminclientsqr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-07-19 10:26
 */
@Slf4j
@RestController
public class Controller {

    @GetMapping("/adminClient")
    public String adminClient() {
        log.info("---- admin client ----");
        return "admin client";
    }
}
