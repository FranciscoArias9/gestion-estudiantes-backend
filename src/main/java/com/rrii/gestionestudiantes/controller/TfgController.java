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

import com.rrii.gestionestudiantes.model.Tfg;
import com.rrii.gestionestudiantes.repository.EstudianteRepository;
import com.rrii.gestionestudiantes.repository.TfgRepository;

@RestController
@RequestMapping("/tfgs")
public class TfgController {

    @Autowired
    private TfgRepository tfgRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public List<Tfg> getAll() {
        return tfgRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Tfg> crearTfg(@RequestBody Tfg tfg) {
        // Validamos que el estudiante exista
        if (!estudianteRepository.existsById(tfg.getEstudiante().getId())) {
            return ResponseEntity.badRequest().build();
        }

        Tfg saved = tfgRepository.save(tfg);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tfg> getById(@PathVariable Long id) {
        return tfgRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tfg> update(@PathVariable Long id, @RequestBody Tfg tfg) {
        return tfgRepository.findById(id).map(existing -> {
            tfg.setId(existing.getId());
            return ResponseEntity.ok(tfgRepository.save(tfg));
        }).orElse(ResponseEntity.notFound().build());
    }
}
