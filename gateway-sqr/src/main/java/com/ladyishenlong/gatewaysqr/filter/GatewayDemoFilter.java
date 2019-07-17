package com.ladyishenlong.gatewaysqr.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import sun.rmi.runtime.Log;

/**
 * @Author ruanchenhao
 * @Date 2019-07-17 17:10
 * <p>
 * GatewayFilter局部过滤器，需要在filterFactor注册
 */
@Slf4j
public class GatewayDemoFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("-------- 局部过滤器 --------");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
