package com.rrii.gestionestudiantes.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",
                    "/estudiantes/**",
                    "/tfgs/**",
                    "/encargado/**"  // 👈 Agregado aquí
                ).permitAll()
                .anyRequest().authenticated()
            )
            .cors(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}



