package com.rrii.gestionestudiantes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * Configuración de seguridad de Spring Security.
 * Define qué rutas están protegidas y cómo se manejan las políticas CORS y CSRF.
 */
@Configuration
public class SecurityConfig {

    /**
     * Define la cadena de filtros de seguridad que será aplicada al backend.
     *
     * - Desactiva CSRF para facilitar pruebas desde el frontend.
     * - Habilita CORS con la configuración definida en CorsConfig.
     * - Permite el acceso público a ciertos endpoints.
     * - Requiere autenticación básica para cualquier otro recurso no listado.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception {
        http
            // Desactiva la protección CSRF (se recomienda habilitar en producción con frontend seguro)
            .csrf(csrf -> csrf.disable())

            // Define reglas de autorización por ruta
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",                 // Login, recuperación de contraseña
                    "/estudiantes/**",          // CRUD de estudiantes y fotos
                    "/estudiantes/fotos/**",    // Acceso a fotos
                    "/tfgs/**",                 // CRUD de TFGs
                    "/encargado/**"             // CRUD de usuarios encargados
                ).permitAll() // Todas estas rutas no requieren autenticación
                .anyRequest().authenticated()  // Cualquier otra ruta sí requiere autenticación
            )

            // Habilita CORS usando la configuración definida en CorsConfig
            .cors(cors -> cors.configurationSource(corsConfigurationSource))

            // Usa autenticación básica HTTP (usuario/contraseña en headers)
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
