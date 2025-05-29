package com.rrii.gestionestudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rrii.gestionestudiantes.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {}