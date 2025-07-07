package com.example.CifraFree.application.usuario.useCases;

import java.util.List;

import com.example.CifraFree.application.usuario.dtos.UsuarioDTO;
import com.example.CifraFree.domain.usuario.IUsuarioRepository;
import com.example.CifraFree.domain.usuario.entities.Usuario;
import com.example.CifraFree.shared.IVoidUseCase;

public class GetAllClientesUseCase implements IVoidUseCase<List<UsuarioDTO>> {

    private IUsuarioRepository usuarioRepository;

    public GetAllClientesUseCase(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDTO> execute() {
        List<Usuario> usuarios = usuarioRepository.getAll();

        return usuarios.stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getId(),
                        usuario.getName(),
                        usuario.getEmail(),
                        usuario.getPassword(),
                        usuario.getRole()
                ))
                .toList();
    }
}
