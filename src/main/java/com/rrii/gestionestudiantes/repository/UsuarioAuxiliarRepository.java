package com.rrii.gestionestudiantes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rrii.gestionestudiantes.model.UsuarioAuxiliar;

public interface UsuarioAuxiliarRepository extends JpaRepository<UsuarioAuxiliar, Long> {
    Optional<UsuarioAuxiliar> findByCorreo(String correo);
}
