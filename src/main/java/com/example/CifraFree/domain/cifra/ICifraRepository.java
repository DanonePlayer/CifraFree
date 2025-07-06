package com.example.CifraFree.domain.cifra;

import java.util.List;

import com.example.CifraFree.domain.cifra.entities.Cifra;

public interface ICifraRepository {
    Cifra create(Cifra cifra);
    Cifra update(Cifra cifra);
    void deleteById(Long id);
    List<Cifra> getAll();
    Cifra getById(Long id);
}