package com.rrii.gestionestudiantes.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rrii.gestionestudiantes.dto.LoginRequest;
import com.rrii.gestionestudiantes.model.UsuarioAuxiliar;
import com.rrii.gestionestudiantes.model.UsuarioEncargado;
import com.rrii.gestionestudiantes.repository.UsuarioAuxiliarRepository;
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioEncargadoRepository encargadoRepo;

    @Autowired
    private UsuarioAuxiliarRepository auxiliarRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req, HttpServletRequest request) {
        System.out.println("🔐 Intento de login con: " + req.getCorreo());

        // Buscar en encargados
        var encargado = encargadoRepo.findByCorreo(req.getCorreo());
        if (encargado.isPresent() && encargado.get().getContrasena().equals(req.getContrasena())) {
            request.getSession().setAttribute("usuario", encargado.get());
            request.getSession().setAttribute("rol", "encargado");
            System.out.println("✅ Login exitoso como ENCARGADO para: " + encargado.get().getCorreo());
            return ResponseEntity.ok(encargado.get());
        }

        // Buscar en auxiliares
        var auxiliar = auxiliarRepo.findByCorreo(req.getCorreo());
        if (auxiliar.isPresent() && auxiliar.get().getContrasena().equals(req.getContrasena())) {
            request.getSession().setAttribute("usuario", auxiliar.get());
            request.getSession().setAttribute("rol", "auxiliar");
            System.out.println("✅ Login exitoso como AUXILIAR para: " + auxiliar.get().getCorreo());
            return ResponseEntity.ok(auxiliar.get());
        }

        System.out.println("❌ Login fallido para: " + req.getCorreo());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }
}
