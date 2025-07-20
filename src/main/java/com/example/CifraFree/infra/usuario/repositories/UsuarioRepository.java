package com.example.CifraFree.infra.usuario.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CifraFree.domain.usuario.IUsuarioRepository;
import com.example.CifraFree.domain.usuario.entities.Usuario;
import com.example.CifraFree.infra.usuario.models.UsuarioModel;

@Repository
public class UsuarioRepository implements IUsuarioRepository{

    @Autowired
    private JPAUsuarioRepository jpaUsuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        UsuarioModel model = new UsuarioModel(usuario);
        return this.jpaUsuarioRepository.save(model).toEntity();
    }

    @Override
    public Usuario update(Usuario usuario) {
        UsuarioModel model = new UsuarioModel(usuario);
        return this.jpaUsuarioRepository.save(model).toEntity();
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioModel model = new UsuarioModel(usuario);
        return this.jpaUsuarioRepository.save(model).toEntity();
    }

    @Override
    public void deleteById(Long id) {
        this.jpaUsuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> getAll() {
        List<UsuarioModel> models = this.jpaUsuarioRepository.findAll();
        return models.stream().map(UsuarioModel::toEntity).toList();
    }

    @Override
    public Usuario getById(Long id) {
        return this.jpaUsuarioRepository.findById(id)
                .map(UsuarioModel::toEntity)
                .orElse(null);
    }

    @Override
    public List<Usuario> getByName(String name) {
        List<UsuarioModel> models = this.jpaUsuarioRepository.findByName(name);
        return models.stream().map(UsuarioModel::toEntity).toList();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return this.jpaUsuarioRepository.findByEmail(email)
                .map(UsuarioModel::toEntity);
    }
    
}
