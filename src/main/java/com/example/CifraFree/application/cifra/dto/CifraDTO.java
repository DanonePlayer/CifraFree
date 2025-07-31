package com.example.CifraFree.application.cifra.dto;

import java.time.LocalDateTime;

import com.example.CifraFree.domain.cifra.entities.Cifra;
import com.example.CifraFree.domain.usuario.entities.Usuario;

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
    private String observation;
    private Integer views;
    private Integer likes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
    private Usuario creator;

    public CifraDTO(Cifra cifra) {
        this.id = cifra.getId();
        this.title = cifra.getTitle();
        this.lyrics = cifra.getLyrics();
        this.chords = cifra.getChords();
        this.tone = cifra.getTone();
        this.artist = cifra.getArtist();
        this.genre = cifra.getGenre();
        this.published = cifra.isPublished();
        this.observation = cifra.getObservation();
        this.views = cifra.getViews();
        this.likes = cifra.getLikes();
        this.createdAt = cifra.getCreatedAt();
        this.updatedAt = cifra.getUpdatedAt();
        this.deleted = cifra.isDeleted();
        this.creator = cifra.getCreator();
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
            this.observation,
            this.views,
            this.likes,
            this.createdAt,
            this.updatedAt,
            this.deleted,
            this.creator
        );
    }
}
