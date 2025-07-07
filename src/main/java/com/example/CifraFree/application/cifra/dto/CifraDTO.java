package com.example.CifraFree.application.cifra.dto;

import com.example.CifraFree.domain.cifra.entities.Cifra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CifraDTO {
    private Long id;
    private String title;
    private String lyrics;
    private String chords;
    private String tone;
    private String artist;
    private String genre;
    private boolean published;
    private Long idCriador;
    private String observation;

    public CifraDTO(Cifra cifra) {
        this.id = cifra.getId();
        this.title = cifra.getTitle();
        this.lyrics = cifra.getLyrics();
        this.chords = cifra.getChords();
        this.tone = cifra.getTone();
        this.artist = cifra.getArtist();
        this.genre = cifra.getGenre();
        this.published = cifra.isPublished();
        this.idCriador = cifra.getIdCriador();
        this.observation = cifra.getObservation();
    }

    public Cifra toEntity() {
        return new Cifra(
            this.id,
            this.title,
            this.lyrics,
            this.chords,
            this.tone,
            this.artist,
            this.genre,
            this.published,
            this.idCriador,
            this.observation
        );
    }
}
