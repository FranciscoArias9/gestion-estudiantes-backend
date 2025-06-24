package com.rrii.gestionestudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del proyecto. Punto de entrada de la aplicación Spring Boot.
 *
 * La anotación @SpringBootApplication habilita:
 * - Configuración automática (auto-configuration)
 * - Escaneo de componentes (component scan)
 * - Configuración basada en anotaciones
 */
@SpringBootApplication
public class GestionestudiantesApplication {

    /**
     * Método main que inicia la aplicación Spring Boot.
     *
     * @param args Argumentos de línea de comandos (opcional)
     */
    public static void main(String[] args) {
        SpringApplication.run(GestionestudiantesApplication.class, args);
    }
}
