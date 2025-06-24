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

import com.rrii.gestionestudiantes.model.UsuarioEncargado;
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository;

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/encargado") // Define la ruta base para todas las peticiones relacionadas a encargados
public class UsuarioEncargadoController {

    // Inyección automática del repositorio de usuarios encargados
    @Autowired
    private UsuarioEncargadoRepository repo;

    // Método para obtener un usuario encargado por su ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEncargado> get(@PathVariable Long id) {
        // Si se encuentra el usuario, lo retorna con status 200, si no, retorna 404
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Método para actualizar un usuario encargado existente
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEncargado> update(@PathVariable Long id, @RequestBody UsuarioEncargado u) {
        return repo.findById(id).map(enc -> {
            // Se asegura de mantener el ID existente
            u.setId(enc.getId());
            // Guarda y retorna el usuario actualizado
            return ResponseEntity.ok(repo.save(u));
        }).orElse(ResponseEntity.notFound().build()); // Si no se encuentra, retorna 404
    }

    // Método para crear un nuevo usuario encargado
    @PostMapping
    public ResponseEntity<UsuarioEncargado> create(@RequestBody UsuarioEncargado nuevoEncargado) {
        // Guarda el nuevo encargado en la base de datos
        UsuarioEncargado guardado = repo.save(nuevoEncargado);
        // Retorna el encargado guardado con status 200
        return ResponseEntity.ok(guardado);
    }

}
