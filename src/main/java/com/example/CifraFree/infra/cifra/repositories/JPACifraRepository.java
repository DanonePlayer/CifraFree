package com.example.CifraFree.infra.cifra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CifraFree.infra.cifra.models.CifraModel;


public interface JPACifraRepository extends JpaRepository<CifraModel, Long>{
}
