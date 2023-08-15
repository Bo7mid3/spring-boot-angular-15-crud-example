package com.bezkoder.spring.jpa.h2.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    final String uiBaseUrl;

    public CorsConfiguration(@Value("${external.service.ui}") String uiBaseUrl) {
        this.uiBaseUrl = uiBaseUrl;
    }

    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(uiBaseUrl);
            }
        };
    }
}
