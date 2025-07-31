package com.example.CifraFree.application.cifra.useCases;

import java.time.LocalDateTime;

import com.example.CifraFree.application.cifra.dto.CifraDTO;
import com.example.CifraFree.domain.cifra.ICifraRepository;
import com.example.CifraFree.domain.cifra.entities.Cifra;
import com.example.CifraFree.domain.usuario.IUsuarioRepository;
import com.example.CifraFree.domain.usuario.entities.Usuario;
import com.example.CifraFree.shared.IUseCase;

public class CreateCifrasUseCase implements IUseCase<CifraDTO, CifraDTO>{

    private ICifraRepository cifraRepository;
    private IUsuarioRepository usuarioRepository;

    public CreateCifrasUseCase(ICifraRepository cifraRepository, IUsuarioRepository usuarioRepository) {
        this.cifraRepository = cifraRepository;
        this.usuarioRepository = usuarioRepository;
    }

	@Override
	public CifraDTO execute(CifraDTO input) {
        Usuario creator = usuarioRepository.getById(input.getCreator().getId());
        Cifra cifra = cifraRepository.create(new Cifra(
            input.getId(),
            input.getTitle(),
            input.getLyrics(),
            input.getChords(),
            input.getTone(),
            input.getArtist(),
            input.getGenre(),
            input.isPublished(),
            input.getObservation(),
            0,
            0,
            LocalDateTime.now(),
            null,
            false,
            creator
        ));

        Cifra savedCifra = cifra;
        return new CifraDTO(savedCifra);
	}

}
