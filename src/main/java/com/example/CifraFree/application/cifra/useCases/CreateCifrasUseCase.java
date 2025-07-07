package com.example.CifraFree.application.cifra.useCases;

import com.example.CifraFree.application.cifra.dto.CifraDTO;
import com.example.CifraFree.domain.cifra.ICifraRepository;
import com.example.CifraFree.domain.cifra.entities.Cifra;
import com.example.CifraFree.shared.IUseCase;

public class CreateCifrasUseCase implements IUseCase<CifraDTO, CifraDTO>{

    private ICifraRepository cifraRepository;

    public CreateCifrasUseCase(ICifraRepository cifraRepository) {
        this.cifraRepository = cifraRepository;
    }

	@Override
	public CifraDTO execute(CifraDTO input) {
        Cifra cifra = cifraRepository.create(new Cifra(
            input.getId(),
            input.getTitle(),
            input.getLyrics(),
            input.getChords(),
            input.getTone(),
            input.getArtist(),
            input.getGenre(),
            input.isPublished(),
            input.getIdCriador(),
            input.getObservation()
        ));

        Cifra savedCifra = cifra;
        return new CifraDTO(savedCifra);
	}

}
