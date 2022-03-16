package br.com.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingHandlerConfig {

    public static final String VEICULOS_MS_HOST = "http://localhost:8089/";

    @Bean
    public RouteLocator custonRouteLocator(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r -> r
                        .path("/ms-veiculos/**")
                        .filters(f -> f.rewritePath("/ms-veiculos/(?<remains>.*)", "/${remains}"))
                        .uri(VEICULOS_MS_HOST)).build();
    }
}
