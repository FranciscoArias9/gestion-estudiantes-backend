package com.rrii.gestionestudiantes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de enviar correos electrónicos desde el sistema.
 * En este caso, se usa para enviar contraseñas a los usuarios encargados.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Envía un correo al usuario con su contraseña.
     *
     * @param correoDestino Dirección de correo electrónico del destinatario
     * @param contrasena Contraseña actual del usuario
     *
     * ⚠️ En producción, no se recomienda enviar contraseñas en texto plano.
     *     En su lugar, debería enviarse un enlace de recuperación con un token temporal.
     */
    public void enviarContrasenaPorCorreo(String correoDestino, String contrasena) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correoDestino);
        mensaje.setSubject("Recuperación de contraseña");
        mensaje.setText("Tu contraseña actual es: " + contrasena);

        mailSender.send(mensaje);
    }
}
