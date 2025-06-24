package com.rrii.gestionestudiantes.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tfg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Estudiante
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    private String tema;
    private String modalidadMaestria; // académica / profesional
    private String modalidadTfg;      // tesis, proyecto, seminario, práctica
    private LocalDate fechaAprobacion;
    private String equipoAsesor;
    private LocalDate fechaVencimiento;
    private String status;            // No solicitado, vigente, vigente con prórroga, vencido
    private String notasSeguimiento;

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }

    public String getModalidadMaestria() { return modalidadMaestria; }
    public void setModalidadMaestria(String modalidadMaestria) { this.modalidadMaestria = modalidadMaestria; }

    public String getModalidadTfg() { return modalidadTfg; }
    public void setModalidadTfg(String modalidadTfg) { this.modalidadTfg = modalidadTfg; }

    public LocalDate getFechaAprobacion() { return fechaAprobacion; }
    public void setFechaAprobacion(LocalDate fechaAprobacion) { this.fechaAprobacion = fechaAprobacion; }

    public String getEquipoAsesor() { return equipoAsesor; }
    public void setEquipoAsesor(String equipoAsesor) { this.equipoAsesor = equipoAsesor; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotasSeguimiento() { return notasSeguimiento; }
    public void setNotasSeguimiento(String notasSeguimiento) { this.notasSeguimiento = notasSeguimiento; }
}
