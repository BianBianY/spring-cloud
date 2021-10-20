package com.tw.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yang.bian
 * @create 2021/9/7 13:58
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_baidu",
                predicateSpec -> predicateSpec.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route_baidu",
                predicateSpec -> predicateSpec.path("/")
                        .uri("http://news.baidu.com/")).build();
        routes.route("path_route_baidu",
                predicateSpec -> predicateSpec.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
