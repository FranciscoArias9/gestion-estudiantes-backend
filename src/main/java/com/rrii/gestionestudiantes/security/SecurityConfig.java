package com.rrii.gestionestudiantes.security;

// Importa las clases necesarias para configurar la seguridad web
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * Clase de configuración de seguridad para definir cómo se protegen los endpoints de la API.
 * Se desactiva CSRF, se permiten ciertos endpoints públicamente y se configura CORS.
 */
@Configuration
public class SecurityConfig {

    /**
     * Define el filtro principal de seguridad de Spring Security.
     * Configura permisos de acceso, CORS, CSRF y autenticación básica.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception {
        http
            // 🔒 Desactiva CSRF ya que no es necesario para APIs REST (y evita problemas con POST desde frontend)
            .csrf(csrf -> csrf.disable())

            // 🔐 Define las reglas de autorización para las solicitudes HTTP
            .authorizeHttpRequests(auth -> auth
                // Estas rutas se permiten sin autenticación
                .requestMatchers(
                    "/auth/**",                // Login y recuperación de contraseña
                    "/estudiantes/**",         // Gestión de estudiantes
                    "/estudiantes/fotos/**",   // Ver fotos
                    "/tfgs/**",                // Gestión de TFGs
                    "/encargado/**"            // Gestión de usuarios encargados
                ).permitAll()

                // Cualquier otra ruta necesita autenticación
                .anyRequest().authenticated()
            )

            // 🔄 Habilita CORS usando la configuración definida en CorsConfig
            .cors(cors -> cors.configurationSource(corsConfigurationSource)) // 👈 ¡Este es el cambio clave!

            // 🔐 Habilita autenticación básica HTTP (útil para pruebas rápidas o proteger rutas con usuario/contraseña)
            .httpBasic(Customizer.withDefaults());

        // 🧱 Devuelve la cadena de filtros construida
        return http.build();
    }
}
