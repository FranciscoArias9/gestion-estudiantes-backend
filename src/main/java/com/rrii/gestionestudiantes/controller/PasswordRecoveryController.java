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

    // Inyecta el repositorio de usuarios encargados para acceder a la base de datos
    @Autowired
    private UsuarioEncargadoRepository usuarioEncargadoRepository;

    // Inyecta el servicio que permite enviar correos electrónicos
    @Autowired
    private EmailService emailService;

    /**
     * Endpoint para recuperar la contraseña de un usuario encargado.
     * Recibe un correo como parámetro y, si existe un usuario asociado,
     * envía la contraseña actual al correo proporcionado.
     * 
     * @param correo el correo electrónico del usuario que solicita recuperación
     * @return respuesta HTTP con mensaje de éxito o error
     */
    @PostMapping("/recuperar")
    public ResponseEntity<String> recuperarContrasena(@RequestParam String correo) {
        // Buscar el usuario por correo
        Optional<UsuarioEncargado> usuarioOpt = usuarioEncargadoRepository.findByCorreo(correo);
        
        // Si existe, enviar la contraseña por correo
        if (usuarioOpt.isPresent()) {
            UsuarioEncargado usuario = usuarioOpt.get();
            emailService.enviarContrasenaPorCorreo(usuario.getCorreo(), usuario.getContrasena());
            return ResponseEntity.ok("Contraseña enviada al correo.");
        } else {
            // Si no se encuentra el usuario, retornar error 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
    }
}
