package com.example.CifraFree.infra.usuario.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CifraFree.infra.usuario.models.UsuarioModel;

public interface JPAUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    List<UsuarioModel> findByName(String name);
    Optional<UsuarioModel> findByEmail(String email);
}
