package com.livestock.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    return http
        .securityMatcher("/products", "/productImages/**", "/categories")
        .securityContext(securityContext -> securityContext
            .disable())
        .headers(headers -> headers
            .httpStrictTransportSecurity(hsts -> hsts
                .disable()))
        .cors(cors -> cors
            .disable())
        .csrf(csrf -> csrf
            .disable())
        .logout(logout -> logout
            .disable())
        .requestCache(requestCache -> requestCache
            .disable())
        .anonymous(anonymous -> anonymous
            .disable())
        .sessionManagement(sessionManagement -> sessionManagement
            .disable())
        .build();
  }
}
