package com.ladyishenlong.gatewaysqr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-07-18 10:52
 */
@RestController
public class Controller {

    @GetMapping("/gatewayHystrix")
    public String gatewayHystrix(){
        return "熔断器熔断";
    }

}
