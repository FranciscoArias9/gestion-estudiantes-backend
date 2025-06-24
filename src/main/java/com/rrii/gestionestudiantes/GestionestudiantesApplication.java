package com.rrii.gestionestudiantes;

// 🚀 Importa la clase que permite iniciar la aplicación Spring Boot
import org.springframework.boot.SpringApplication;
// 📦 Importa la anotación que marca esta clase como punto de entrada principal
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación.
 * Esta clase arranca el servidor y carga el contexto de Spring Boot.
 */
@SpringBootApplication // 🔧 Marca esta clase como una aplicación Spring Boot (incluye @Configuration, @EnableAutoConfiguration, @ComponentScan)
public class GestionestudiantesApplication {

    /**
     * Método main: punto de entrada de la aplicación.
     * SpringApplication.run() inicializa el contexto de Spring y levanta el servidor embebido.
     */
    public static void main(String[] args) {
        SpringApplication.run(GestionestudiantesApplication.class, args);
    }

}
