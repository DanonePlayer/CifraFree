package com.example.CifraFree.infra.cifra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CifraFree.application.cifra.dto.CifraDTO;
import com.example.CifraFree.application.cifra.useCases.CreateCifrasUseCase;
import com.example.CifraFree.application.cifra.useCases.GetAllCifrasUseCase;
import com.example.CifraFree.application.cifra.useCases.GetCifraByIdUseCase;
import com.example.CifraFree.infra.cifra.repositories.CifraRepository;
import com.example.CifraFree.infra.usuario.repositories.UsuarioRepository;

@Service
public class CifraService {
    
    private GetAllCifrasUseCase getAllCifrasUseCase;

    private CreateCifrasUseCase createCifrasUseCase;

    private GetCifraByIdUseCase getCifraByIdUseCase;

    private CifraRepository cifraRepository;
    private UsuarioRepository usuarioRepository;

    public CifraService(CifraRepository cifraRepository, UsuarioRepository usuarioRepository) {
        this.cifraRepository = cifraRepository;
        this.usuarioRepository = usuarioRepository;
        this.getAllCifrasUseCase = new GetAllCifrasUseCase(cifraRepository);
        this.createCifrasUseCase = new CreateCifrasUseCase(cifraRepository, usuarioRepository);
        this.getCifraByIdUseCase = new GetCifraByIdUseCase(cifraRepository);
    }
    
    public CifraDTO getCifraById(Long id) {
        return getCifraByIdUseCase.execute(id).orElseThrow(() -> new RuntimeException("Cifra not found"));
    }


    public List<CifraDTO> getAllCifras() {
        return getAllCifrasUseCase.execute();
    }

    public CifraDTO createCifra(CifraDTO cifraDTO) {
        return createCifrasUseCase.execute(cifraDTO);
    }
}
