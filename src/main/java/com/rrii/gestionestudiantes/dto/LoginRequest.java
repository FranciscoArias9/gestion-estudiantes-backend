package com.rrii.gestionestudiantes.dto;

/**
 * DTO (Data Transfer Object) utilizado para recibir las credenciales
 * de un usuario encargado en el proceso de inicio de sesión (login).
 *
 * Contiene solamente el correo y la contraseña.
 */
public class LoginRequest {

    // Correo electrónico del usuario que intenta iniciar sesión
    private String correo;

    // Contraseña del usuario
    private String contrasena;

    // Getter para correo
    public String getCorreo() {
        return correo;
    }

    // Setter para correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getter para contraseña
    public String getContrasena() {
        return contrasena;
    }

    // Setter para contraseña
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
