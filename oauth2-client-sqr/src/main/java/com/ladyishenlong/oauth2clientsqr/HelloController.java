package com.ladyishenlong.oauth2clientsqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-07-03 17:19
 */
@RestController
public class HelloController {

    @Autowired
    public String hello(){
        return "hello oath2 client";
    }

}
