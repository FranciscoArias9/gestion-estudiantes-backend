package com.rrii.gestionestudiantes.repository;

// Importa la interfaz JpaRepository de Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Importa la entidad Estudiante que este repositorio manejará
import com.rrii.gestionestudiantes.model.Estudiante;

/**
 * Esta interfaz actúa como el repositorio de acceso a datos para la entidad Estudiante.
 * Extiende JpaRepository, lo que le proporciona métodos CRUD automáticamente (findAll, save, deleteById, etc.)
 *
 * Parámetros genéricos:
 * - Estudiante: la entidad a manejar
 * - Long: el tipo de la clave primaria de la entidad (en este caso, Long)
 */
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {}
