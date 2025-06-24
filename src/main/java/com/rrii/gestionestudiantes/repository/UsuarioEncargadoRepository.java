package com.rrii.gestionestudiantes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rrii.gestionestudiantes.model.UsuarioEncargado;

public interface UsuarioEncargadoRepository extends JpaRepository<UsuarioEncargado, Long> {
    Optional<UsuarioEncargado> findByCorreo(String correo);
} 
