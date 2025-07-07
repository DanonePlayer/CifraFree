package com.example.CifraFree.infra.usuario.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CifraFree.application.usuario.dtos.UsuarioDTO;
import com.example.CifraFree.application.usuario.useCases.GetAllClientesUseCase;
import com.example.CifraFree.infra.usuario.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    private GetAllClientesUseCase getAllClientesUseCase;

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.getAllClientesUseCase = new GetAllClientesUseCase(usuarioRepository);
    }

    public List<UsuarioDTO> getAllClientes() {
        return getAllClientesUseCase.execute();
    }
}
