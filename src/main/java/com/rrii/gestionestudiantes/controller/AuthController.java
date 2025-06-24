package com.rrii.gestionestudiantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rrii.gestionestudiantes.dto.LoginRequest;
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository;

@RestController
@RequestMapping("/auth") // Ruta base para las peticiones relacionadas con autenticación
public class AuthController {

    @Autowired
    private UsuarioEncargadoRepository usuarioEncargadoRepository;

    /**
     * Endpoint para iniciar sesión.
     * Recibe un objeto LoginRequest con correo y contraseña, y verifica si el usuario existe y coincide la contraseña.
     *
     * @param request Datos del usuario (correo y contraseña)
     * @return 200 OK con los datos del usuario si las credenciales son correctas,
     *         401 UNAUTHORIZED si falla la autenticación
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        System.out.println("🔐 Intento de login con: " + request.getCorreo());

        // Busca el usuario por correo
        var usuario = usuarioEncargadoRepository.findByCorreo(request.getCorreo());

        // Verifica que exista y que la contraseña coincida
        if (usuario.isPresent() && usuario.get().getContrasena().equals(request.getContrasena())) {
            System.out.println("✅ Login exitoso para: " + usuario.get().getCorreo());
            return ResponseEntity.ok(usuario);
        } else {
            System.out.println("❌ Login fallido para: " + request.getCorreo());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
