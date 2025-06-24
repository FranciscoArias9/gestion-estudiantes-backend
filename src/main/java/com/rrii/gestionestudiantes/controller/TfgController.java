package com.rrii.gestionestudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rrii.gestionestudiantes.model.Tfg;
import com.rrii.gestionestudiantes.repository.EstudianteRepository;
import com.rrii.gestionestudiantes.repository.TfgRepository;

@RestController
@RequestMapping("/tfgs") // Ruta base para operaciones sobre trabajos finales de graduación
public class TfgController {

    @Autowired
    private TfgRepository tfgRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    /**
     * Obtiene la lista de todos los TFGs registrados.
     */
    @GetMapping
    public List<Tfg> getAll() {
        return tfgRepository.findAll();
    }

    /**
     * Crea un nuevo TFG, validando primero que el estudiante asociado exista.
     *
     * @param tfg Objeto TFG recibido en el cuerpo de la solicitud
     * @return 200 OK si fue guardado, 400 Bad Request si el estudiante no existe
     */
    @PostMapping
    public ResponseEntity<Tfg> crearTfg(@RequestBody Tfg tfg) {
        if (!estudianteRepository.existsById(tfg.getEstudiante().getId())) {
            return ResponseEntity.badRequest().build(); // Estudiante no encontrado
        }

        Tfg guardado = tfgRepository.save(tfg);
        return ResponseEntity.ok(guardado);
    }

    /**
     * Obtiene un TFG específico por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tfg> getById(@PathVariable Long id) {
        return tfgRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Actualiza un TFG existente con los datos recibidos.
     *
     * @param id  ID del TFG a actualizar
     * @param tfg Objeto con la nueva información
     * @return 200 OK con el TFG actualizado, o 404 si no se encuentra el ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<Tfg> update(@PathVariable Long id, @RequestBody Tfg tfg) {
        return tfgRepository.findById(id).map(tfgExistente -> {
            tfg.setId(tfgExistente.getId()); // Asegura que se actualice y no se cree uno nuevo
            return ResponseEntity.ok(tfgRepository.save(tfg));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Elimina un TFG por su ID si existe.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!tfgRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tfgRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
