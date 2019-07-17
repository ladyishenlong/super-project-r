package com.ladyishenlong.gatewaysqr.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-07-17 16:31
 *
 * 全局过滤器
 */
@Component
@Slf4j
public class GlobalDemoFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("START_TIME", System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute("START_TIME");
            if(startTime!=null){
                Long endTime = (System.currentTimeMillis() - startTime);
                log.info("-------------------------------------------------------");
                log.info("访问地址：{}",exchange.getRequest().getURI());
                log.info("访问耗时：{} ms",endTime);
                log.info("-------------------------------------------------------");
            }
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
