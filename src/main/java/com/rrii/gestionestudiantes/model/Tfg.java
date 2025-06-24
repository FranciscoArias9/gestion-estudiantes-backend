package com.rrii.gestionestudiantes.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad que representa un Trabajo Final de Graduación (TFG)
 * asociado a un estudiante.
 */
@Entity
public class Tfg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Relación muchos-a-uno con la entidad Estudiante.
     * Cada TFG está asociado a un único estudiante.
     */
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    // Tema o título del TFG
    private String tema;

    // Modalidad de maestría: académica o profesional
    private String modalidadMaestria;

    // Tipo de TFG: tesis, proyecto, seminario o práctica
    private String modalidadTfg;

    // Fecha en la que fue aprobado el tema
    private LocalDate fechaAprobacion;

    // Nombres del equipo asesor asignado al TFG
    private String equipoAsesor;

    // Fecha límite para concluir el TFG
    private LocalDate fechaVencimiento;

    // Estado del TFG: No solicitado, vigente, con prórroga, vencido, etc.
    private String status;

    // Notas internas o comentarios de seguimiento
    private String notasSeguimiento;

    // ====== Getters y Setters ======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getModalidadMaestria() {
        return modalidadMaestria;
    }

    public void setModalidadMaestria(String modalidadMaestria) {
        this.modalidadMaestria = modalidadMaestria;
    }

    public String getModalidadTfg() {
        return modalidadTfg;
    }

    public void setModalidadTfg(String modalidadTfg) {
        this.modalidadTfg = modalidadTfg;
    }

    public LocalDate getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDate fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getEquipoAsesor() {
        return equipoAsesor;
    }

    public void setEquipoAsesor(String equipoAsesor) {
        this.equipoAsesor = equipoAsesor;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotasSeguimiento() {
        return notasSeguimiento;
    }

    public void setNotasSeguimiento(String notasSeguimiento) {
        this.notasSeguimiento = notasSeguimiento;
    }
}
