package com.rrii.gestionestudiantes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rrii.gestionestudiantes.model.UsuarioEncargado;
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository;
import com.rrii.gestionestudiantes.service.EmailService;

@RestController
@RequestMapping("/auth") // Ruta base para autenticación y recuperación
public class PasswordRecoveryController {

    @Autowired
    private UsuarioEncargadoRepository usuarioEncargadoRepository;

    @Autowired
    private EmailService emailService;

    /**
     * Endpoint para recuperar la contraseña de un usuario.
     * Se le envía por correo electrónico al usuario registrado si el correo existe.
     *
     * @param correo Correo electrónico del usuario que solicita recuperar su contraseña
     * @return 200 OK si el correo fue enviado, 404 si el usuario no existe
     */
    @PostMapping("/recuperar")
    public ResponseEntity<String> recuperarContrasena(@RequestParam String correo) {
        Optional<UsuarioEncargado> usuarioOpt = usuarioEncargadoRepository.findByCorreo(correo);

        // Verifica si el usuario existe
        if (usuarioOpt.isPresent()) {
            UsuarioEncargado usuario = usuarioOpt.get();

            // Envía la contraseña al correo registrado (⚠️ inseguro en producción)
            emailService.enviarContrasenaPorCorreo(usuario.getCorreo(), usuario.getContrasena());

            return ResponseEntity.ok("Contraseña enviada al correo.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
    }
}
