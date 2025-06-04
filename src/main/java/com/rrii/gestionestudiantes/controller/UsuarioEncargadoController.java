package com.rrii.gestionestudiantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;


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
    @PostMapping("/crear-usuario-encargado")
public ResponseEntity<?> crearUsuarioEncargado(@RequestBody UsuarioEncargado nuevoUsuario, Authentication auth) {
    //UsuarioEncargado actual = repo.findByCorreo(auth.getName());
     UsuarioEncargado actual = repo.findByCorreo(auth.getName()).orElse(null);

    if (actual == null || !"usuario_jefe".equals(actual.getClasificacion())) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para crear usuarios.");
    }

    return ResponseEntity.ok(repo.save(nuevoUsuario));
}


 


    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEncargado> update(@PathVariable Long id, @RequestBody UsuarioEncargado u) {
        return repo.findById(id).map(enc -> {
            u.setId(enc.getId());
            return ResponseEntity.ok(repo.save(u));
        }).orElse(ResponseEntity.notFound().build());
    }
}
