package com.example.teruzushi_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Habilita CORS para todas las rutas
                .allowedOrigins("http://localhost:8100")  // Permite solicitudes desde Ionic
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
                .allowedHeaders("*")  // Permite todas las cabeceras
                .allowCredentials(true);  // Permite el envío de cookies o credenciales
    }
}