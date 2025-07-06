package com.example.CifraFree.infra.cifra.models;

import com.example.CifraFree.domain.cifra.entities.Cifra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CifraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String title;

    @Column(name = "letra", nullable = false)
    private String lyrics;

    @Column(name = "acordes", nullable = false)
    private String chords;

    @Column(name = "tom", nullable = false)
    private String tone;

    @Column(name = "artista", nullable = true)
    private String artist;

    @Column(name = "genero", nullable = true)
    private String genre;

    @Column(name = "publica", nullable = false)
    private boolean published;

    @Column(name = "id_criador", nullable = false)
    private Long idCriador;

    @Column(name = "observacao", nullable = true)
    private String observation;


    public CifraModel(Cifra cifra) {
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
