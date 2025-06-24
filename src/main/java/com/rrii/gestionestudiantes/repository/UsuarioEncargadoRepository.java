package com.rrii.gestionestudiantes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rrii.gestionestudiantes.model.UsuarioEncargado;

/**
 * Repositorio para la entidad UsuarioEncargado.
 * Extiende JpaRepository para acceso CRUD completo sobre usuarios encargados.
 *
 * También incluye un método personalizado para buscar usuarios por su correo electrónico.
 */
public interface UsuarioEncargadoRepository extends JpaRepository<UsuarioEncargado, Long> {

    /**
     * Busca un usuario encargado por su correo electrónico.
     * Este método será implementado automáticamente por Spring Data JPA.
     *
     * @param correo Correo electrónico a buscar
     * @return Optional con el usuario encontrado o vacío si no existe
     */
    Optional<UsuarioEncargado> findByCorreo(String correo);
}
