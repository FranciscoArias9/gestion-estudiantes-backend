package com.rrii.gestionestudiantes.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.rrii.gestionestudiantes.model.Estudiante;
import com.rrii.gestionestudiantes.repository.EstudianteRepository;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    /**
     * Obtiene la lista de todos los estudiantes registrados.
     */
    @GetMapping
    public List<Estudiante> getAll() {
        return estudianteRepository.findAll();
    }

    /**
     * Crea un nuevo estudiante a partir de un JSON recibido.
     */
    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    /**
     * Obtiene un estudiante por su ID.
     */
   

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getById(@PathVariable Long id) {
        return estudianteRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Actualiza los datos de un estudiante y guarda cuál fue el último campo modificado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable Long id, @RequestBody Estudiante estudianteNuevo) {
        return estudianteRepository.findById(id).map(estudianteExistente -> {
            estudianteNuevo.setId(estudianteExistente.getId());

            // Detecta qué campo fue modificado y lo registra
            if (!Objects.equals(estudianteNuevo.getProgramaMaestria(), estudianteExistente.getProgramaMaestria())) {
                estudianteNuevo.setUltimoCampoModificado("programaMaestria");
            } else if (!Objects.equals(estudianteNuevo.getAnioAdmision(), estudianteExistente.getAnioAdmision())) {
                estudianteNuevo.setUltimoCampoModificado("anioAdmision");
            } else if (!Objects.equals(estudianteNuevo.getNumeroPromocion(), estudianteExistente.getNumeroPromocion())) {
                estudianteNuevo.setUltimoCampoModificado("numeroPromocion");
            } else if (!Objects.equals(estudianteNuevo.getModalidad(), estudianteExistente.getModalidad())) {
                estudianteNuevo.setUltimoCampoModificado("modalidad");
            } else if (!Objects.equals(estudianteNuevo.getNombre(), estudianteExistente.getNombre())) {
                estudianteNuevo.setUltimoCampoModificado("nombre");
            } else if (!Objects.equals(estudianteNuevo.getApellidos(), estudianteExistente.getApellidos())) {
                estudianteNuevo.setUltimoCampoModificado("apellidos");
            } else if (!Objects.equals(estudianteNuevo.getNacionalidad(), estudianteExistente.getNacionalidad())) {
                estudianteNuevo.setUltimoCampoModificado("nacionalidad");
            } else if (!Objects.equals(estudianteNuevo.getGenero(), estudianteExistente.getGenero())) {
                estudianteNuevo.setUltimoCampoModificado("genero");
            } else if (!Objects.equals(estudianteNuevo.getNumeroIdentificacion(), estudianteExistente.getNumeroIdentificacion())) {
                estudianteNuevo.setUltimoCampoModificado("numeroIdentificacion");
            } else if (!Objects.equals(estudianteNuevo.getTelefono(), estudianteExistente.getTelefono())) {
                estudianteNuevo.setUltimoCampoModificado("telefono");
            } else if (!Objects.equals(estudianteNuevo.getCorreo(), estudianteExistente.getCorreo())) {
                estudianteNuevo.setUltimoCampoModificado("correo");
            } else if (!Objects.equals(estudianteNuevo.getLugarResidencia(), estudianteExistente.getLugarResidencia())) {
                estudianteNuevo.setUltimoCampoModificado("lugarResidencia");
            } else if (!Objects.equals(estudianteNuevo.getUniversidadOrigen(), estudianteExistente.getUniversidadOrigen())) {
                estudianteNuevo.setUltimoCampoModificado("universidadOrigen");
            } else if (!Objects.equals(estudianteNuevo.getGradoAcademico(), estudianteExistente.getGradoAcademico())) {
                estudianteNuevo.setUltimoCampoModificado("gradoAcademico");
            } else if (!Objects.equals(estudianteNuevo.getCarrerasUniversitarias(), estudianteExistente.getCarrerasUniversitarias())) {
                estudianteNuevo.setUltimoCampoModificado("carrerasUniversitarias");
            } else if (!Objects.equals(estudianteNuevo.getLugarTrabajo(), estudianteExistente.getLugarTrabajo())) {
                estudianteNuevo.setUltimoCampoModificado("lugarTrabajo");
            } else if (!Objects.equals(estudianteNuevo.getFuncionTrabajo(), estudianteExistente.getFuncionTrabajo())) {
                estudianteNuevo.setUltimoCampoModificado("funcionTrabajo");
            } else if (!Objects.equals(estudianteNuevo.getTipoEmpadronamiento(), estudianteExistente.getTipoEmpadronamiento())) {
                estudianteNuevo.setUltimoCampoModificado("tipoEmpadronamiento");
            } else if (!Objects.equals(estudianteNuevo.isSolicitudExoneracion(), estudianteExistente.isSolicitudExoneracion())) {
                estudianteNuevo.setUltimoCampoModificado("solicitudExoneracion");
            } else if (!Objects.equals(estudianteNuevo.getComentarioExoneracion(), estudianteExistente.getComentarioExoneracion())) {
                estudianteNuevo.setUltimoCampoModificado("comentarioExoneracion");
            } else if (!Objects.equals(estudianteNuevo.getMotivacionObjetivos(), estudianteExistente.getMotivacionObjetivos())) {
                estudianteNuevo.setUltimoCampoModificado("motivacionObjetivos");
            } else if (!Objects.equals(estudianteNuevo.getExperienciaPrevia(), estudianteExistente.getExperienciaPrevia())) {
                estudianteNuevo.setUltimoCampoModificado("experienciaPrevia");
            } else if (!Objects.equals(estudianteNuevo.getAdaptabilidad(), estudianteExistente.getAdaptabilidad())) {
                estudianteNuevo.setUltimoCampoModificado("adaptabilidad");
            } else if (!Objects.equals(estudianteNuevo.getComunicacion(), estudianteExistente.getComunicacion())) {
                estudianteNuevo.setUltimoCampoModificado("comunicacion");
            } else if (!Objects.equals(estudianteNuevo.getEstadoEstudiante(), estudianteExistente.getEstadoEstudiante())) {
                estudianteNuevo.setUltimoCampoModificado("estadoEstudiante");
            } else if (!Objects.equals(estudianteNuevo.getAnotacionesEstado(), estudianteExistente.getAnotacionesEstado())) {
                estudianteNuevo.setUltimoCampoModificado("anotacionesEstado");
            } else if (!Objects.equals(estudianteNuevo.getOtrasObservaciones(), estudianteExistente.getOtrasObservaciones())) {
                estudianteNuevo.setUltimoCampoModificado("otrasObservaciones");
            } else if (!Objects.equals(estudianteNuevo.getNotasAdicionales(), estudianteExistente.getNotasAdicionales())) {
                estudianteNuevo.setUltimoCampoModificado("notasAdicionales");
            } else if (!Objects.equals(estudianteNuevo.getTipoMaestria(), estudianteExistente.getTipoMaestria())) {
                estudianteNuevo.setUltimoCampoModificado("tipoMaestria");
            } else {
                estudianteNuevo.setUltimoCampoModificado("sin cambios detectados");
            }

            // Marca la fecha del cambio
            estudianteNuevo.setFechaUltimoCambio(LocalDateTime.now());

            return ResponseEntity.ok(estudianteRepository.save(estudianteNuevo));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Elimina un estudiante por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo estudiante con opción de cargar una foto.
     */
    @PostMapping("/con-foto")
    public ResponseEntity<Estudiante> crearConFoto(
            @RequestPart("estudiante") Estudiante estudiante,
            @RequestPart(value = "foto", required = false) MultipartFile foto) {

        if (foto != null && !foto.isEmpty()) {
            String nombreArchivo = System.currentTimeMillis() + "_" + foto.getOriginalFilename();
            Path ruta = Paths.get("uploads/" + nombreArchivo);
            try {
                Files.createDirectories(ruta.getParent());
                Files.copy(foto.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
                estudiante.setFotoUrl(nombreArchivo);
            } catch (IOException e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        Estudiante guardado = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(guardado);
    }

    /**
     * Actualiza la foto de un estudiante existente por ID.
     */
    @PostMapping("/{id}/foto")
    public ResponseEntity<?> actualizarFoto(@PathVariable Long id, @RequestPart("foto") MultipartFile foto) {
        return estudianteRepository.findById(id).map(estudiante -> {
            if (foto != null && !foto.isEmpty()) {
                String nombreArchivo = System.currentTimeMillis() + "_" + foto.getOriginalFilename();
                Path ruta = Paths.get("uploads/" + nombreArchivo);
                try {
                    Files.createDirectories(ruta.getParent());
                    Files.copy(foto.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
                    estudiante.setFotoUrl(nombreArchivo);
                    estudianteRepository.save(estudiante);
                    return ResponseEntity.ok().body(java.util.Map.of("filename", nombreArchivo));
                } catch (IOException e) {
                    return ResponseEntity.internalServerError().body("Error al guardar la foto.");
                }
            } else {
                return ResponseEntity.badRequest().body("No se recibió ninguna foto.");
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Devuelve una foto almacenada en el servidor a partir de su nombre de archivo.
     */
    @GetMapping("/fotos/{nombre}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombre) {
        try {
            Path ruta = Paths.get("uploads").resolve(nombre).toAbsolutePath();
            Resource recurso = new UrlResource(ruta.toUri());

            if (!recurso.exists() || !recurso.isReadable()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(recurso);
        } catch (MalformedURLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
