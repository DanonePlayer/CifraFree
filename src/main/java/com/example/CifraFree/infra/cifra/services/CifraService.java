package com.example.CifraFree.infra.cifra.services;

import org.springframework.stereotype.Service;

import com.example.CifraFree.application.cifra.useCases.GetAllCifrasUseCase;
import com.example.CifraFree.infra.cifra.repositories.CifraRepository;

@Service
public class CifraService {
    
    private GetAllCifrasUseCase getAllCifrasUseCase;

    private CifraRepository cifraRepository;

    public CifraService(CifraRepository cifraRepository) {
        this.cifraRepository = cifraRepository;
        this.getAllCifrasUseCase = new GetAllCifrasUseCase(cifraRepository);
    }
    public GetAllCifrasUseCase getAllCifrasUseCase() {
        return getAllCifrasUseCase;
    }
}
