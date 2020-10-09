package com.csy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类名: GateWayConfig
 *
 * @author CSY
 * @date 2020/9/20
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocator routeLocator= builder.routes()
                .route("path_route_csy",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routeLocator;
    }
}
