package com.rrii.gestionestudiantes.controller;

import jakarta.servlet.http.HttpServletRequest; // 👈 importar esto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrii.gestionestudiantes.dto.LoginRequest;
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioEncargadoRepository repo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req, HttpServletRequest request) {
        System.out.println("🔐 Intento de login con: " + req.getCorreo());

        var user = repo.findByCorreo(req.getCorreo());
        if (user.isPresent() && user.get().getContrasena().equals(req.getContrasena())) {
            request.getSession().setAttribute("usuario", user.get()); // ✅ clave para mantener sesión
            System.out.println("✅ Login exitoso para: " + user.get().getCorreo());
            return ResponseEntity.ok(user);
        } else {
            System.out.println("❌ Login fallido para: " + req.getCorreo());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
