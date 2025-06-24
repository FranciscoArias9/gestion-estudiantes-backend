package com.rrii.gestionestudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rrii.gestionestudiantes.model.Tfg;

/**
 * Repositorio para la entidad Tfg (Trabajo Final de Graduación).
 * Permite realizar operaciones CRUD sobre la tabla TFG en la base de datos.
 *
 * - Tfg: entidad a gestionar.
 * - Long: tipo de dato del ID primario.
 *
 * Al extender JpaRepository, se obtienen métodos como:
 *   - findAll()
 *   - findById(id)
 *   - save(entity)
 *   - deleteById(id)
 *   - etc.
 */
public interface TfgRepository extends JpaRepository<Tfg, Long> {
    // Puedes definir consultas personalizadas aquí si lo necesitas
}
