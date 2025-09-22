package com.example.CifraFree.infra.cifra.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CifraFree.domain.cifra.ICifraRepository;
import com.example.CifraFree.domain.cifra.entities.Cifra;
import com.example.CifraFree.infra.cifra.models.CifraModel;

@Repository
public class CifraRepository implements ICifraRepository{

    @Autowired
    private JPACifraRepository jpaCifraRepository;
    
    @Override
    public Cifra create(Cifra cifra) {
        CifraModel model = new CifraModel(cifra);
        return this.jpaCifraRepository.save(model).toEntity();
    }

    @Override
    public Cifra update(Cifra cifra) {
        CifraModel model = new CifraModel(cifra);
        return this.jpaCifraRepository.save(model).toEntity();
    }

    @Override
    public void deleteById(Long id) {
        this.jpaCifraRepository.deleteById(id);
    }

    @Override
    public Optional<Cifra> getById(Long id) {
        return this.jpaCifraRepository.findById(id)
            .map(CifraModel::toEntity);
    }

    @Override
    public List<Cifra> getAll() {
        return this.jpaCifraRepository.findAll().stream()
            .map(CifraModel::toEntity)
            .toList();
    }
    
}
