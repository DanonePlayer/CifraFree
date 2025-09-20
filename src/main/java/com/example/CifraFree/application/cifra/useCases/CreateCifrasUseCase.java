package com.example.CifraFree.application.cifra.useCases;

import java.time.LocalDateTime;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

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
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.parseLong(authentication.getToken().getClaim("userId").toString());
        Usuario creator = usuarioRepository.getById(userId);
        Cifra cifra = cifraRepository.create(new Cifra(
            input.getId(),
            input.getTitle(),
            input.getLyrics(),
            input.getLyricsChords(),
            input.getChords(),
            input.getTone(),
            input.getArtist(),
            input.getGenre(),
            input.isPublished(),
            input.getObservation(),
            0,
            0,
            input.isFavorite(),
            LocalDateTime.now(),
            null,
            false,
            creator
        ));

        Cifra savedCifra = cifra;
        return new CifraDTO(savedCifra);
	}

}
