package com.example.CifraFree.domain.usuario;

import java.util.List;

import com.example.CifraFree.domain.usuario.entities.Usuario;

public interface IUsuarioRepository {
    Usuario create (Usuario usuario);
    Usuario update(Usuario usuario);
    void deleteById(Long id);
    Usuario getById(Long id);
    List<Usuario> getAll();
    List<Usuario> getByName(String name);
}
