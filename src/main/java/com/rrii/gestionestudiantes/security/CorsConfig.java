package com.rrii.gestionestudiantes.security;

// Importa utilidades necesarias para configurar CORS
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Clase de configuración que define las reglas CORS para el backend.
 * Permite que otros orígenes (como el frontend en Vercel o localhost)
 * puedan hacer peticiones al backend sin ser bloqueados por el navegador.
 */
@Configuration
public class CorsConfig {

    /**
     * Define un bean que provee la configuración de CORS para toda la aplicación.
     * Esta configuración permite el acceso cruzado desde orígenes específicos
     * y especifica qué métodos, cabeceras y credenciales se permiten.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Permite orígenes específicos para evitar errores de CORS en desarrollo o producción.
        // allowedOriginPatterns permite usar comodines o subdominios si es necesario.
        configuration.setAllowedOriginPatterns(Arrays.asList(
            "http://localhost:5173", // origen usado en desarrollo local (Vite)
            "https://gestion-estudiantes-frontend.vercel.app" // origen del frontend desplegado
        ));

        // Define los métodos HTTP permitidos
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Permite cualquier cabecera en la solicitud (por ejemplo, Authorization, Content-Type, etc.)
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // Permite enviar cookies o headers como Authorization
        configuration.setAllowCredentials(true);

        // Define qué cabeceras serán visibles desde el frontend en la respuesta
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Access-Control-Allow-Origin"));

        // Mensaje en consola para confirmar que CORS fue aplicado
        System.out.println("✅ CORS config aplicada correctamente");

        // Asocia la configuración con todas las rutas del backend
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // aplica a todos los endpoints

        return source;
    }
}
