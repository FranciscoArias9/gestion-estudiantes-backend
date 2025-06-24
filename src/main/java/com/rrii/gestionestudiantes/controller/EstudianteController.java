package com.rrii.gestionestudiantes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rrii.gestionestudiantes.model.Estudiante;
import com.rrii.gestionestudiantes.repository.EstudianteRepository;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    // Inyección del repositorio para acceder a los datos de estudiantes
    @Autowired
    private EstudianteRepository repo;

    // Obtener lista de todos los estudiantes
    @GetMapping
    public List<Estudiante> getAll() {
        return repo.findAll();
    }

    // Crear un estudiante desde un JSON sin foto
    @PostMapping
    public Estudiante crear(@RequestBody Estudiante e) {
        return repo.save(e);
    }

    // Obtener un estudiante por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getById(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /*
    Método PUT actualizado: permite editar un estudiante y además registra cuál fue el último campo modificado.
    Si no hay diferencias detectadas, se marca "sin cambios detectados".
    También se actualiza la fecha del último cambio.
    */
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable Long id, @RequestBody Estudiante e) {
        return repo.findById(id).map(est -> {
            e.setId(est.getId());

            // Detección del campo modificado comparando campo por campo
            if (!Objects.equals(e.getProgramaMaestria(), est.getProgramaMaestria())) {
                e.setUltimoCampoModificado("programaMaestria");
            } else if (!Objects.equals(e.getAnioAdmision(), est.getAnioAdmision())) {
                e.setUltimoCampoModificado("anioAdmision");
            } else if (!Objects.equals(e.getNumeroPromocion(), est.getNumeroPromocion())) {
                e.setUltimoCampoModificado("numeroPromocion");
            } else if (!Objects.equals(e.getModalidad(), est.getModalidad())) {
                e.setUltimoCampoModificado("modalidad");
            } else if (!Objects.equals(e.getNombre(), est.getNombre())) {
                e.setUltimoCampoModificado("nombre");
            } else if (!Objects.equals(e.getApellidos(), est.getApellidos())) {
                e.setUltimoCampoModificado("apellidos");
            } else if (!Objects.equals(e.getNacionalidad(), est.getNacionalidad())) {
                e.setUltimoCampoModificado("nacionalidad");
            } else if (!Objects.equals(e.getGenero(), est.getGenero())) {
                e.setUltimoCampoModificado("genero");
            } else if (!Objects.equals(e.getNumeroIdentificacion(), est.getNumeroIdentificacion())) {
                e.setUltimoCampoModificado("numeroIdentificacion");
            } else if (!Objects.equals(e.getTelefono(), est.getTelefono())) {
                e.setUltimoCampoModificado("telefono");
            } else if (!Objects.equals(e.getCorreo(), est.getCorreo())) {
                e.setUltimoCampoModificado("correo");
            } else if (!Objects.equals(e.getLugarResidencia(), est.getLugarResidencia())) {
                e.setUltimoCampoModificado("lugarResidencia");
            } else if (!Objects.equals(e.getUniversidadOrigen(), est.getUniversidadOrigen())) {
                e.setUltimoCampoModificado("universidadOrigen");
            } else if (!Objects.equals(e.getGradoAcademico(), est.getGradoAcademico())) {
                e.setUltimoCampoModificado("gradoAcademico");
            } else if (!Objects.equals(e.getCarrerasUniversitarias(), est.getCarrerasUniversitarias())) {
                e.setUltimoCampoModificado("carrerasUniversitarias");
            } else if (!Objects.equals(e.getLugarTrabajo(), est.getLugarTrabajo())) {
                e.setUltimoCampoModificado("lugarTrabajo");
            } else if (!Objects.equals(e.getFuncionTrabajo(), est.getFuncionTrabajo())) {
                e.setUltimoCampoModificado("funcionTrabajo");
            } else if (!Objects.equals(e.getTipoEmpadronamiento(), est.getTipoEmpadronamiento())) {
                e.setUltimoCampoModificado("tipoEmpadronamiento");
            } else if (!Objects.equals(e.isSolicitudExoneracion(), est.isSolicitudExoneracion())) {
                e.setUltimoCampoModificado("solicitudExoneracion");
            } else if (!Objects.equals(e.getComentarioExoneracion(), est.getComentarioExoneracion())) {
                e.setUltimoCampoModificado("comentarioExoneracion");
            } else if (!Objects.equals(e.getMotivacionObjetivos(), est.getMotivacionObjetivos())) {
                e.setUltimoCampoModificado("motivacionObjetivos");
            } else if (!Objects.equals(e.getExperienciaPrevia(), est.getExperienciaPrevia())) {
                e.setUltimoCampoModificado("experienciaPrevia");
            } else if (!Objects.equals(e.getAdaptabilidad(), est.getAdaptabilidad())) {
                e.setUltimoCampoModificado("adaptabilidad");
            } else if (!Objects.equals(e.getComunicacion(), est.getComunicacion())) {
                e.setUltimoCampoModificado("comunicacion");
            } else if (!Objects.equals(e.getEstadoEstudiante(), est.getEstadoEstudiante())) {
                e.setUltimoCampoModificado("estadoEstudiante");
            } else if (!Objects.equals(e.getAnotacionesEstado(), est.getAnotacionesEstado())) {
                e.setUltimoCampoModificado("anotacionesEstado");
            } else if (!Objects.equals(e.getOtrasObservaciones(), est.getOtrasObservaciones())) {
                e.setUltimoCampoModificado("otrasObservaciones");
            } else if (!Objects.equals(e.getNotasAdicionales(), est.getNotasAdicionales())) {
                e.setUltimoCampoModificado("notasAdicionales");
            } else if (!Objects.equals(e.getTipoMaestria(), e.getTipoMaestria())) {
                e.setUltimoCampoModificado("tipoMaestria");
            } else {
                e.setUltimoCampoModificado("sin cambios detectados");
            }

            // Guardar la fecha y hora del último cambio
            e.setFechaUltimoCambio(LocalDateTime.now());

            return ResponseEntity.ok(repo.save(e));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar estudiante por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear estudiante junto con su foto (upload)
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
                estudiante.setFotoUrl(nombreArchivo); // Guardar solo el nombre del archivo
            } catch (IOException e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        Estudiante guardado = repo.save(estudiante);
        return ResponseEntity.ok(guardado);
    }

    // Actualizar solo la foto de un estudiante existente
    @PostMapping("/{id}/foto")
    public ResponseEntity<?> actualizarFoto(@PathVariable Long id, @RequestPart("foto") MultipartFile foto) {
        return repo.findById(id).map(estudiante -> {
            if (foto != null && !foto.isEmpty()) {
                String nombreArchivo = System.currentTimeMillis() + "_" + foto.getOriginalFilename();
                Path ruta = Paths.get("uploads/" + nombreArchivo);
                try {
                    Files.createDirectories(ruta.getParent());
                    Files.copy(foto.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
                    estudiante.setFotoUrl(nombreArchivo);
                    repo.save(estudiante);
                    return ResponseEntity.ok().body(java.util.Map.of("filename", nombreArchivo));
                } catch (IOException e) {
                    return ResponseEntity.internalServerError().body("Error al guardar la foto.");
                }
            } else {
                return ResponseEntity.badRequest().body("No se recibió ninguna foto.");
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    // Obtener una foto almacenada en la carpeta /uploads
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
