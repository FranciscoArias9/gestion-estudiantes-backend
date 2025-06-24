package com.rrii.gestionestudiantes.model;

import jakarta.persistence.*;

/**
 * Entidad que representa a un usuario encargado del sistema,
 * el cual puede tener permisos administrativos u operativos.
 */
@Entity
public class UsuarioEncargado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del encargado
    private String nombre;

    // Correo único del usuario (usado para login y notificaciones)
    @Column(unique = true)
    private String correo;

    // Contraseña (actualmente almacenada como texto plano; no recomendado en producción)
    private String contrasena;

    // Apellidos del encargado
    private String apellidos;

    // Puesto o cargo que ocupa (ej: Coordinador, Asistente, etc.)
    private String puesto;

    /**
     * Clasificación del encargado:
     * - "usuario_jefe": acceso completo
     * - "usuario_auxiliar": acceso limitado (ver y editar, pero no registrar)
     */
    @Column(name = "clasificacion")
    private String clasificacion;

    // ====== Getters y Setters ======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
