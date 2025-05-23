package com.braidsbeautybyangie.apigateway.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfigDefault {

//    @Bean
//    SResponseProductListecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) throws Exception {
//
//        return http.authorizeExchange(authz -> {
//            authz.pathMatchers("/authorized", "/logout").permitAll()
//                    .pathMatchers(HttpMethod.GET, "/v1/orders-service/**", "/v1/product-service/**","/v1/reservation-service/**").permitAll()
//                    //.pathMatchers(HttpMethod.GET, "/api/items/{id}", "/api/products/{id}", "/v1/user-service/user/{id}")
//                    //.hasAnyRole("ADMIN", "USER")
//                    .pathMatchers(  "/v1/**").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
//                    .anyExchange().authenticated();
//        }).cors(cors -> cors.configurationSource(corsConfigurationSource()))
//                .oauth2Login(withDefaults())
//                .oauth2Client(withDefaults())
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(
//                        jwt -> jwt.jwtAuthenticationConverter(new Converter<OAuth2ResourceServerProperties.Jwt, Mono<AbstractAuthenticationToken>>() {
//
//                            @Override
//                            public Mono<AbstractAuthenticationToken> convert(OAuth2ResourceServerProperties.Jwt source) {
//                                Collection<String> roles = source.getClaimAsStringList("roles");
//                                Collection<GrantedAuthority> authorities = roles.stream()
//                                .map(SimpleGrantedAuthority::new)
//                                        .collect(Collectors.toList());
//
//                                return Mono.just(new JwtAuthenticationToken(source, authorities));
//                            }
//                        })))
//                .build();
//    }
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("*")); // Permitir todos los orígenes
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
@Bean
public CorsWebFilter corsFilter() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOriginPattern("*"); // o "http://localhost:3000"
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    return new CorsWebFilter(source);
}
}
