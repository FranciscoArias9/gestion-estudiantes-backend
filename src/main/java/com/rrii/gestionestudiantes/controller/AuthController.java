package com.rrii.gestionestudiantes.controller;

// Importaciones necesarias para controladores y manejo de solicitudes/respuestas HTTP
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrii.gestionestudiantes.dto.LoginRequest; // DTO que representa los datos de inicio de sesión
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository; // Repositorio para acceder a los usuarios encargados

// Indica que esta clase es un controlador REST
@RestController
// Prefijo común para todas las rutas dentro de este controlador
@RequestMapping("/auth")
public class AuthController {

    // Inyección del repositorio que maneja los usuarios encargados
    @Autowired
    private UsuarioEncargadoRepository repo;

    // Endpoint POST que responde a /auth/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        // Mensaje de depuración en consola con el correo del intento de login
        System.out.println("🔐 Intento de login con: " + req.getCorreo());

        // Busca el usuario por correo
        var user = repo.findByCorreo(req.getCorreo());

        // Si el usuario existe y la contraseña coincide
        if (user.isPresent() && user.get().getContrasena().equals(req.getContrasena())) {
            System.out.println("✅ Login exitoso para: " + user.get().getCorreo());
            // Retorna el usuario como respuesta exitosa (200 OK)
            return ResponseEntity.ok(user);
        } else {
            // Si no coincide, retorna estado 401 Unauthorized
            System.out.println("❌ Login fallido para: " + req.getCorreo());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
