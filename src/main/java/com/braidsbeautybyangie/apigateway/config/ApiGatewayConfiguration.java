package com.braidsbeautybyangie.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/v1/product-service/**")
                        .uri("lb://product-service"))
                .route(p -> p.path("/v1/payment-service/**")
                        .uri("lb://payment-service"))
                .route(p -> p.path("/v1/reservation-service/**")
                        .uri("lb://reservation-service"))
                .route(p -> p.path("/v1/credit-card/**")
                        .uri("lb://credit-card-processor-service"))
                .route(p -> p.path("/v1/orders-service/**")
                        .uri("lb://orders-service"))
                .build();

    }

}
