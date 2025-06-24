package com.rrii.gestionestudiantes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Indica que esta clase es una entidad JPA y será mapeada a una tabla en la base de datos
public class UsuarioEncargado {

    @Id // Define el campo 'id' como la clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se genera automáticamente (auto-incremental)
    private Long id;

    // Nombre del encargado
    private String nombre;

    @Column(unique = true) // El campo 'correo' debe ser único en la base de datos (no se permiten duplicados)
    private String correo;

    // Contraseña del usuario encargado (idealmente debería cifrarse antes de almacenarse)
    private String contrasena;

    // Apellidos del encargado
    private String apellidos;

    // Puesto que ocupa el encargado (ejemplo: Coordinador, Asistente, etc.)
    private String puesto;

    @Column(name = "clasificacion") // Nombre explícito de columna en BD
    private String clasificacion; // Puede ser 'usuario_jefe' o 'usuario_auxiliar'

    // ================== Getters y Setters ==================

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

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
}
