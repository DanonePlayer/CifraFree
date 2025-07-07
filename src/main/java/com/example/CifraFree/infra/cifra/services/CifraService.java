package com.example.CifraFree.infra.cifra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CifraFree.application.cifra.dto.CifraDTO;
import com.example.CifraFree.application.cifra.useCases.CreateCifrasUseCase;
import com.example.CifraFree.application.cifra.useCases.GetAllCifrasUseCase;
import com.example.CifraFree.infra.cifra.repositories.CifraRepository;

@Service
public class CifraService {
    
    private GetAllCifrasUseCase getAllCifrasUseCase;

    private CreateCifrasUseCase createCifrasUseCase;

    private CifraRepository cifraRepository;

    public CifraService(CifraRepository cifraRepository) {
        this.cifraRepository = cifraRepository;
        this.getAllCifrasUseCase = new GetAllCifrasUseCase(cifraRepository);
        this.createCifrasUseCase = new CreateCifrasUseCase(cifraRepository);

    }


    public List<CifraDTO> getAllCifras() {
        return getAllCifrasUseCase.execute();
    }

    public CifraDTO createCifra(CifraDTO cifraDTO) {
        return createCifrasUseCase.execute(cifraDTO);
    }
}
