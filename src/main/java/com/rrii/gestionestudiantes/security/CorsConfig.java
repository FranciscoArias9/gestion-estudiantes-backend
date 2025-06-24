package com.rrii.gestionestudiantes.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Configuración global de CORS (Cross-Origin Resource Sharing).
 *
 * Permite que el frontend (por ejemplo en Vercel o localhost) pueda comunicarse
 * con este backend sin ser bloqueado por políticas de seguridad del navegador.
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Permite solicitudes desde estos orígenes específicos
        configuration.setAllowedOriginPatterns(Arrays.asList(
            "http://localhost:5173", // Para desarrollo local
            "https://gestion-estudiantes-frontend.vercel.app" // Frontend en producción
        ));

        // Métodos HTTP permitidos
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Cabeceras permitidas desde el frontend
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // Permite enviar cookies y encabezados de autorización
        configuration.setAllowCredentials(true);

        // Cabeceras que el navegador puede acceder desde la respuesta
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Access-Control-Allow-Origin"));

        System.out.println("✅ CORS config aplicada correctamente");

        // Aplica la configuración a todas las rutas del backend
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
