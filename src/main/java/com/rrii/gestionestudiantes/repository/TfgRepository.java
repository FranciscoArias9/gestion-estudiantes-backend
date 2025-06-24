package com.rrii.gestionestudiantes.repository;

// Importa la interfaz JpaRepository que provee métodos CRUD y más para manejar entidades
import org.springframework.data.jpa.repository.JpaRepository;

// Importa la clase Tfg, que es la entidad que este repositorio administrará
import com.rrii.gestionestudiantes.model.Tfg;

/**
 * Esta interfaz define un repositorio para la entidad Tfg (Trabajo Final de Graduación).
 * Al extender JpaRepository, Spring Boot genera automáticamente implementaciones para:
 * - Buscar todos los registros
 * - Buscar por ID
 * - Guardar (insertar/actualizar)
 * - Eliminar
 * - Y otros métodos comunes sin necesidad de escribir código SQL.
 *
 * Parámetros:
 * - Tfg: entidad objetivo
 * - Long: tipo de dato de la clave primaria de la entidad
 */
public interface TfgRepository extends JpaRepository<Tfg, Long> {
}
