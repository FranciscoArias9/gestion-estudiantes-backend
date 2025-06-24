package com.rrii.gestionestudiantes.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarContrasenaPorCorreo(String correoDestino, String contrasena) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correoDestino);
        mensaje.setSubject("Recuperación de contraseña");
        mensaje.setText("Tu contraseña actual es: " + contrasena);
        mailSender.send(mensaje);
    }
}
