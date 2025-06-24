package com.rrii.gestionestudiantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rrii.gestionestudiantes.model.UsuarioEncargado;
import com.rrii.gestionestudiantes.repository.UsuarioEncargadoRepository;

@RestController
@RequestMapping("/encargado") // Ruta base para operaciones sobre usuarios encargados
public class UsuarioEncargadoController {

    @Autowired
    private UsuarioEncargadoRepository usuarioEncargadoRepository;

    /**
     * Obtiene los datos de un usuario encargado por su ID.
     *
     * @param id ID del usuario encargado
     * @return 200 OK con el usuario encontrado, 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEncargado> get(@PathVariable Long id) {
        return usuarioEncargadoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Actualiza la información de un usuario encargado por su ID.
     *
     * @param id ID del usuario encargado
     * @param usuarioNuevo Objeto con los datos actualizados
     * @return 200 OK con el usuario actualizado, 404 si no existe
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEncargado> update(@PathVariable Long id, @RequestBody UsuarioEncargado usuarioNuevo) {
        return usuarioEncargadoRepository.findById(id).map(encargadoExistente -> {
            usuarioNuevo.setId(encargadoExistente.getId()); // Se asegura de mantener el mismo ID
            return ResponseEntity.ok(usuarioEncargadoRepository.save(usuarioNuevo));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuevo usuario encargado.
     *
     * @param nuevoEncargado Objeto con la información del nuevo usuario
     * @return 200 OK con el usuario creado
     */
    @PostMapping
    public ResponseEntity<UsuarioEncargado> create(@RequestBody UsuarioEncargado nuevoEncargado) {
        UsuarioEncargado guardado = usuarioEncargadoRepository.save(nuevoEncargado);
        return ResponseEntity.ok(guardado);
    }
}
