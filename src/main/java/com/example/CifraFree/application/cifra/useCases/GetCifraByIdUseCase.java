package com.example.CifraFree.application.cifra.useCases;

import java.util.Optional;

import com.example.CifraFree.application.cifra.dto.CifraDTO;
import com.example.CifraFree.domain.cifra.ICifraRepository;
import com.example.CifraFree.shared.IUseCase;

public class GetCifraByIdUseCase implements IUseCase<Long, Optional<CifraDTO>> {

    private ICifraRepository cifraRepository;

    public GetCifraByIdUseCase(ICifraRepository cifraRepository) {
        this.cifraRepository = cifraRepository;
    }

    @Override
    public Optional<CifraDTO> execute(Long input) {
        Optional<CifraDTO> cifra = cifraRepository.getById(input).map(CifraDTO::new);
        return cifra;
    }

}
