package com.rrii.gestionestudiantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;

import com.rrii.gestionestudiantes.model.UsuarioEncargado;
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository;

@RestController
@RequestMapping("/encargado")
public class UsuarioEncargadoController {
    @Autowired private UsuarioEncargadoRepository repo;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEncargado> get(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEncargado> update(@PathVariable Long id, @RequestBody UsuarioEncargado u) {
        return repo.findById(id).map(enc -> {
            u.setId(enc.getId());
            return ResponseEntity.ok(repo.save(u));
        }).orElse(ResponseEntity.notFound().build());
    }
  
}
