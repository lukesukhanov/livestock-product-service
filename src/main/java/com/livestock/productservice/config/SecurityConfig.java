package com.livestock.productservice.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

  @Value("${app.security.cors-origins}")
  private String[] corsOrigins;
  
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
            .configurationSource(defaultCorsConfigurationSource()))
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

  @Bean
  CorsConfigurationSource defaultCorsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of(this.corsOrigins));
    configuration.setAllowedMethods(List.of(HttpMethod.GET.toString()));
    configuration.setAllowedHeaders(List.of(HttpHeaders.ACCEPT));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/products", configuration);
    source.registerCorsConfiguration("/productImages/**", configuration);
    source.registerCorsConfiguration("/categories", configuration);
    return source;
  }
}
