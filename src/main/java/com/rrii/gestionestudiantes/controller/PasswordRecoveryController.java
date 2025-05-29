package com.rrii.gestionestudiantes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rrii.gestionestudiantes.model.UsuarioEncargado;
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository;
import com.rrii.gestionestudiantes.service.EmailService;

@RestController
@RequestMapping("/auth")
public class PasswordRecoveryController {

    @Autowired
    private UsuarioEncargadoRepository usuarioEncargadoRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/recuperar")
    public ResponseEntity<String> recuperarContrasena(@RequestParam String correo) {
        Optional<UsuarioEncargado> usuarioOpt = usuarioEncargadoRepository.findByCorreo(correo);
        if (usuarioOpt.isPresent()) {
            UsuarioEncargado usuario = usuarioOpt.get();
            emailService.enviarContrasenaPorCorreo(usuario.getCorreo(), usuario.getContrasena());
            return ResponseEntity.ok("Contraseña enviada al correo.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
    }
}
