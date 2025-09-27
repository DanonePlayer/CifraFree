package com.example.CifraFree.application.cifra.useCases;

import java.time.LocalDateTime;

import com.example.CifraFree.application.cifra.dto.CifraDTO;
import com.example.CifraFree.domain.cifra.ICifraRepository;
import com.example.CifraFree.domain.cifra.entities.Cifra;
import com.example.CifraFree.shared.IAuthorizationUseCase;

public class UpdateCifraUseCase implements IAuthorizationUseCase<CifraDTO, CifraDTO> {

    private final ICifraRepository cifraRepository;

    public UpdateCifraUseCase(ICifraRepository cifraRepository) {
        this.cifraRepository = cifraRepository;
    }

    @Override
    public CifraDTO execute(CifraDTO input, Long userId) {
        if (input.getId() == null) {
            throw new IllegalArgumentException("ID da cifra é obrigatório para atualização.");
        }

        var existingCifraOpt = cifraRepository.getById(input.getId());
        if (existingCifraOpt.isEmpty()) {
            throw new RuntimeException("Cifra não encontrada.");
        }

        var existingCifra = existingCifraOpt.get();
        if (!existingCifra.getCreator().getId().equals(userId)) {
            throw new SecurityException("Você não tem permissão para editar esta cifra.");
        }

        Cifra updatedCifra = cifraRepository.update(new Cifra(
            existingCifra.getId(),
            input.getTitle(),
            input.getLyrics(),
            input.getLyricsChords(),
            input.getChords(),
            input.getTone(),
            input.getArtist(),
            input.getGenre(),
            input.isPublished(),
            input.getObservation(),
            existingCifra.getViews(),
            existingCifra.getLikes(),
            input.isFavorite(),
            existingCifra.getCreatedAt(),
            LocalDateTime.now(),
            existingCifra.isDeleted(),
            existingCifra.getCreator()
        ));

        return new CifraDTO(updatedCifra);
    }
}
