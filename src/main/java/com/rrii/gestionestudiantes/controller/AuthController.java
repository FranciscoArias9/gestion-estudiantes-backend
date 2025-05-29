package com.rrii.gestionestudiantes.controller;

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
    @Autowired private UsuarioEncargadoRepository repo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        var user = repo.findByCorreo(req.getCorreo());
        if (user.isPresent() && user.get().getContrasena().equals(req.getContrasena())) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}