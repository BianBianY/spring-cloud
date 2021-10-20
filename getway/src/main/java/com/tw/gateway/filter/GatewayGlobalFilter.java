package com.tw.gateway.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author yang.bian
 * @create 2021/9/7 15:12
 */
@Component
@Log4j2
public class GatewayGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*******************come :" + LocalDateTime.now());
        exchange.getAttributes().put("asd","asdda");
        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
