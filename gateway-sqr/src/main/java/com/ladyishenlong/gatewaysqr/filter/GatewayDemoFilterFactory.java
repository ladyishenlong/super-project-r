package com.ladyishenlong.gatewaysqr.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019-07-17 17:13
 */
@Component
public class GatewayDemoFilterFactory extends AbstractGatewayFilterFactory<Object> {
    @Override
    public GatewayFilter apply(Object config) {
        return new GatewayDemoFilter();
    }
}
