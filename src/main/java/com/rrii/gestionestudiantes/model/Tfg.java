package com.rrii.gestionestudiantes.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity // Marca esta clase como una entidad de base de datos que será mapeada a una tabla
public class Tfg {

    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID (auto-incremental)
    private Long id;

    // Relación muchos-a-uno: varios TFGs pueden estar ligados a un mismo estudiante
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false) // Define la columna que actúa como clave foránea
    private Estudiante estudiante;

    // Título o tema del TFG
    private String tema;

    // Tipo de maestría del estudiante (ej. académica o profesional)
    private String modalidadMaestria;

    // Modalidad específica del TFG (tesis, proyecto, seminario, práctica, etc.)
    private String modalidadTfg;

    // Fecha en que el TFG fue aprobado
    private LocalDate fechaAprobacion;

    // Texto libre con los nombres del equipo asesor (puede ser uno o más asesores)
    private String equipoAsesor;

    // Fecha límite o vencimiento del TFG según reglamento institucional
    private LocalDate fechaVencimiento;

    // Estado del TFG: 
    // puede ser "No solicitado", "Vigente", "Vigente con prórroga", "Vencido", etc.
    private String status;

    // Campo para registrar notas o comentarios sobre el seguimiento del proceso del TFG
    private String notasSeguimiento;

    // ================== Getters y Setters ==================

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
