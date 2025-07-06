package com.example.CifraFree.application.cifra.useCases;

import java.util.List;

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
            .map(cifra -> new CifraDTO(
                cifra.getId(),
                cifra.getTitle(),
                cifra.getLyrics(),
                cifra.getChords(),
                cifra.getTone(),
                cifra.getArtist(),
                cifra.getGenre(),
                cifra.isPublished(),
                cifra.getIdCriador(),
                cifra.getObservation()
            )).toList();

        return cifras;
    }
}
