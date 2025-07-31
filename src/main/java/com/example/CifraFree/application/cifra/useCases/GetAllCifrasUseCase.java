package com.example.CifraFree.application.cifra.useCases;

import java.util.List;
import java.util.stream.Collectors;

import com.example.CifraFree.application.cifra.dto.CifraDTO;
import com.example.CifraFree.domain.cifra.ICifraRepository;
import com.example.CifraFree.shared.IVoidUseCase;

public class GetAllCifrasUseCase implements IVoidUseCase<List<CifraDTO>>{

    private ICifraRepository cifraRepository;

    public GetAllCifrasUseCase(ICifraRepository cifraRepository) {
        this.cifraRepository = cifraRepository;
    }

    @Override
    public List<CifraDTO> execute() {
        List<CifraDTO> cifras = cifraRepository.getAll().stream()
            .map(CifraDTO::new)
            .collect(Collectors.toList());

        return cifras;
    }
}
