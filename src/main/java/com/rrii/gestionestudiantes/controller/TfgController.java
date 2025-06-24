package com.rrii.gestionestudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.rrii.gestionestudiantes.model.Tfg;
import com.rrii.gestionestudiantes.repository.EstudianteRepository;
import com.rrii.gestionestudiantes.repository.TfgRepository;

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/tfgs") // Ruta base para todas las peticiones relacionadas a TFGs
public class TfgController {

    // Inyección automática del repositorio de TFGs
    @Autowired
    private TfgRepository tfgRepository;

    // Inyección del repositorio de estudiantes para validaciones relacionadas
    @Autowired
    private EstudianteRepository estudianteRepository;

    // Obtiene todos los TFGs existentes
    @GetMapping
    public List<Tfg> getAll() {
        return tfgRepository.findAll();
    }

    // Crea un nuevo TFG
    @PostMapping
    public ResponseEntity<Tfg> crearTfg(@RequestBody Tfg tfg) {
        // Verifica si el estudiante asignado al TFG existe
        if (!estudianteRepository.existsById(tfg.getEstudiante().getId())) {
            return ResponseEntity.badRequest().build(); // Si no existe, devuelve un 400
        }

        // Guarda el TFG en la base de datos
        Tfg saved = tfgRepository.save(tfg);
        return ResponseEntity.ok(saved); // Devuelve el TFG guardado con código 200
    }

    // Obtiene un TFG por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Tfg> getById(@PathVariable Long id) {
        return tfgRepository.findById(id)
                .map(ResponseEntity::ok) // Si existe, retorna el TFG con 200
                .orElse(ResponseEntity.notFound().build()); // Si no, retorna 404
    }

    // Actualiza un TFG existente
    @PutMapping("/{id}")
    public ResponseEntity<Tfg> update(@PathVariable Long id, @RequestBody Tfg tfg) {
        return tfgRepository.findById(id).map(existing -> {
            tfg.setId(existing.getId()); // Asegura que se use el ID existente
            return ResponseEntity.ok(tfgRepository.save(tfg)); // Guarda y retorna actualizado
        }).orElse(ResponseEntity.notFound().build()); // Si no existe, retorna 404
    }

    // Elimina un TFG por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!tfgRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Si no existe, 404
        }
        tfgRepository.deleteById(id); // Elimina el TFG
        return ResponseEntity.noContent().build(); // Retorna 204 sin contenido
    }

}
