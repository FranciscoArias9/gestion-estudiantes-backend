package com.rrii.gestionestudiantes.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("programa_maestria")
    private String programaMaestria;

    @JsonProperty("anio_admision")
    private int anioAdmision;

    @JsonProperty("numero_promocion")
    private String numeroPromocion;

    private String modalidad;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String genero;

    @JsonProperty("numero_identificacion")
    private String numeroIdentificacion;

    private String telefono;
    private String correo;

    @JsonProperty("lugar_residencia")
    private String lugarResidencia;

    @JsonProperty("universidad_origen")
    private String universidadOrigen;


    @JsonProperty("grado_academico")
    private String gradoAcademico;

    @JsonProperty("carreras_universitarias")
    private String carrerasUniversitarias;

    @JsonProperty("lugar_trabajo")
    private String lugarTrabajo;

    @JsonProperty("funcion_trabajo")
    private String funcionTrabajo;

    @JsonProperty("tipo_empadronamiento")
    private String tipoEmpadronamiento;

    @JsonProperty("solicitud_exoneracion")
    private String solicitudExoneracion;

    @JsonProperty("comentario_exoneracion")
    private String comentarioExoneracion;

    @JsonProperty("motivacion_objetivos")
    private int motivacionObjetivos;

    @JsonProperty("experiencia_previa")
    private int experienciaPrevia;

    private int adaptabilidad;
    private int comunicacion;

    @JsonProperty("estado_estudiante")
    private String estadoEstudiante;

    @JsonProperty("anotaciones_estado")
    private String anotacionesEstado;

    @JsonProperty("otras_observaciones")
    private String otrasObservaciones;

    @JsonProperty("notas_adicionales")
    private String notasAdicionales;

    @Column(name = "ultimo_campo_modificado")
    private String ultimoCampoModificado;

    @Column(name = "fecha_ultimo_cambio")
    private LocalDateTime fechaUltimoCambio;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Tfg> tfgs;


    public String getUltimoCampoModificado() {
        return ultimoCampoModificado;
    }

    public void setUltimoCampoModificado(String ultimoCampoModificado) {
        this.ultimoCampoModificado = ultimoCampoModificado;
    }

    public LocalDateTime getFechaUltimoCambio() {
        return fechaUltimoCambio;
    }

    public void setFechaUltimoCambio(LocalDateTime fechaUltimoCambio) {
        this.fechaUltimoCambio = fechaUltimoCambio;
    }

    private String fotoUrl;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramaMaestria() {
        return programaMaestria;
    }

    public void setProgramaMaestria(String programaMaestria) {
        this.programaMaestria = programaMaestria;
    }

    public int getAnioAdmision() {
        return anioAdmision;
    }

    public void setAnioAdmision(int anioAdmision) {
        this.anioAdmision = anioAdmision;
    }

    public String getNumeroPromocion() {
        return numeroPromocion;
    }

    public void setNumeroPromocion(String numeroPromocion) {
        this.numeroPromocion = numeroPromocion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getUniversidadOrigen() {
        return universidadOrigen;
    }

    public void setUniversidadOrigen(String universidadOrigen) {
        this.universidadOrigen = universidadOrigen;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getCarrerasUniversitarias() {
        return carrerasUniversitarias;
    }

    public void setCarrerasUniversitarias(String carrerasUniversitarias) {
        this.carrerasUniversitarias = carrerasUniversitarias;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getFuncionTrabajo() {
        return funcionTrabajo;
    }

    public void setFuncionTrabajo(String funcionTrabajo) {
        this.funcionTrabajo = funcionTrabajo;
    }

    public String getTipoEmpadronamiento() {
        return tipoEmpadronamiento;
    }

    public void setTipoEmpadronamiento(String tipoEmpadronamiento) {
        this.tipoEmpadronamiento = tipoEmpadronamiento;
    }

    public String isSolicitudExoneracion() {
        return solicitudExoneracion;
    }

    public void setSolicitudExoneracion(String solicitudExoneracion) {
        this.solicitudExoneracion = solicitudExoneracion;
    }

    public String getComentarioExoneracion() {
        return comentarioExoneracion;
    }

    public void setComentarioExoneracion(String comentarioExoneracion) {
        this.comentarioExoneracion = comentarioExoneracion;
    }

    public int getMotivacionObjetivos() {
        return motivacionObjetivos;
    }

    public void setMotivacionObjetivos(int motivacionObjetivos) {
        this.motivacionObjetivos = motivacionObjetivos;
    }

    public int getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(int experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    public int getAdaptabilidad() {
        return adaptabilidad;
    }

    public void setAdaptabilidad(int adaptabilidad) {
        this.adaptabilidad = adaptabilidad;
    }

    public int getComunicacion() {
        return comunicacion;
    }

    public void setComunicacion(int comunicacion) {
        this.comunicacion = comunicacion;
    }

    public String getEstadoEstudiante() {
        return estadoEstudiante;
    }

    public void setEstadoEstudiante(String estadoEstudiante) {
        this.estadoEstudiante = estadoEstudiante;
    }

    public String getAnotacionesEstado() {
        return anotacionesEstado;
    }

    public void setAnotacionesEstado(String anotacionesEstado) {
        this.anotacionesEstado = anotacionesEstado;
    }

    public String getOtrasObservaciones() {
        return otrasObservaciones;
    }

    public void setOtrasObservaciones(String otrasObservaciones) {
        this.otrasObservaciones = otrasObservaciones;
    }

    public String getNotasAdicionales() {
        return notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    @JsonProperty("tipo_maestria")
    private String tipoMaestria;

    public String getTipoMaestria() {
        return tipoMaestria;
    }

    public void setTipoMaestria(String tipoMaestria) {
        this.tipoMaestria = tipoMaestria;
    }

}
