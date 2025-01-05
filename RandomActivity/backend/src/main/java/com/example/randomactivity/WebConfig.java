package com.example.randomactivity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Zezwól na żądania do endpointów API
                .allowedOrigins("http://frontend:8080", "http://localhost:8081")
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Metody HTTP
                .allowedHeaders("*") // Zezwól na wszystkie nagłówki
                .allowCredentials(true); // Zezwól na ciasteczka i uwierzytelnianie
    }
}
