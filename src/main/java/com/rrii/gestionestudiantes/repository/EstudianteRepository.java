package com.rrii.gestionestudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rrii.gestionestudiantes.model.Estudiante;

/**
 * Repositorio para la entidad Estudiante.
 * Extiende JpaRepository para proporcionar operaciones CRUD automáticas.
 *
 * - Estudiante: entidad que gestiona.
 * - Long: tipo del identificador primario (ID).
 *
 * Spring Data JPA implementa automáticamente esta interfaz en tiempo de ejecución.
 */
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // Puedes agregar aquí métodos personalizados si lo necesitas, por ejemplo:
    // List<Estudiante> findByProgramaMaestria(String programa);
}
