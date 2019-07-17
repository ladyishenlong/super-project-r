package com.ladyishenlong.superprojectr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-07-11 08:27
 */
@RestController
public class Controller {

    @GetMapping("/superProjectR")
    public String superProjectR() {
        return "hello superProjectR";
    }

}
