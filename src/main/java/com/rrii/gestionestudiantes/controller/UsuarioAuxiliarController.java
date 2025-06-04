package com.rrii.gestionestudiantes.controller;

import com.rrii.gestionestudiantes.model.UsuarioAuxiliar;
import com.rrii.gestionestudiantes.repository.UsuarioAuxiliarRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auxiliar")
public class UsuarioAuxiliarController {

    @Autowired
    private UsuarioAuxiliarRepository repo;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAuxiliar> get(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAuxiliar> update(@PathVariable Long id, @RequestBody UsuarioAuxiliar u) {
        return repo.findById(id).map(aux -> {
            u.setId(aux.getId());
            return ResponseEntity.ok(repo.save(u));
        }).orElse(ResponseEntity.notFound().build());
    }

    
}
