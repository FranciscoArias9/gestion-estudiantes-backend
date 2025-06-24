package com.rrii.gestionestudiantes.repository;

// Importa la clase Optional, que se usa para manejar valores que pueden o no estar presentes
import java.util.Optional;

// Importa JpaRepository, que proporciona métodos CRUD automáticos y otras funciones útiles
import org.springframework.data.jpa.repository.JpaRepository;

// Importa la entidad UsuarioEncargado que será gestionada por este repositorio
import com.rrii.gestionestudiantes.model.UsuarioEncargado;

/**
 * Interfaz para el acceso a datos de la entidad UsuarioEncargado.
 * Extiende JpaRepository, lo que le permite heredar métodos estándar como:
 * - findAll()
 * - findById()
 * - save()
 * - deleteById()
 * 
 * Parámetros genéricos:
 * - UsuarioEncargado: la clase de entidad que maneja este repositorio
 * - Long: el tipo de dato de su clave primaria
 */
public interface UsuarioEncargadoRepository extends JpaRepository<UsuarioEncargado, Long> {

    /**
     * Método personalizado que permite buscar un usuario por su correo electrónico.
     * Spring implementa automáticamente esta consulta basándose en el nombre del método.
     *
     * @param correo el correo electrónico del usuario encargado
     * @return un Optional que puede contener el UsuarioEncargado si se encuentra
     */
    Optional<UsuarioEncargado> findByCorreo(String correo);
}
