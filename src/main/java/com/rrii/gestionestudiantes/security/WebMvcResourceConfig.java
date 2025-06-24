package com.rrii.gestionestudiantes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

/**
 * Configuración adicional de Spring MVC para servir archivos estáticos
 * (en este caso, las fotos de los estudiantes que se almacenan localmente).
 */
@Configuration
public class WebMvcResourceConfig implements WebMvcConfigurer {

    /**
     * Agrega un manejador de recursos estáticos para exponer las fotos
     * almacenadas en la carpeta "uploads/" a través de una URL accesible.
     *
     * Por ejemplo, si una foto se llama `1234_foto.jpg` y está en la carpeta `uploads/`,
     * se podrá acceder con:
     *     http://localhost:8080/estudiantes/fotos/1234_foto.jpg
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Convierte la ruta 'uploads' a una URI absoluta
        String uploadPath = Paths.get("uploads").toAbsolutePath().toUri().toString();

        // Expone los archivos dentro de 'uploads/' mediante la ruta /estudiantes/fotos/**
        registry
            .addResourceHandler("/estudiantes/fotos/**")
            .addResourceLocations(uploadPath);
    }
}
