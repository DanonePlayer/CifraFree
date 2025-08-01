package com.example.CifraFree.infra.cifra.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.example.CifraFree.domain.cifra.entities.Cifra;
import com.example.CifraFree.infra.usuario.models.UsuarioModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE cifra_model SET excluido = true WHERE id = ?")
@SQLRestriction("excluido = false")
@Table(name = "cifras")
public class CifraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String title;

    @Column(name = "letra", nullable = false, columnDefinition = "TEXT")
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

    @ManyToOne
    @JoinColumn(name = "id_criador", nullable = false, updatable = false)
    private UsuarioModel creator;

    @Column(name = "observacao", nullable = true)
    private String observation;

    @Column(name = "visualizacoes", nullable = false)
    private Integer views = 0;

    @Column(name = "curtidas", nullable = false)
    private Integer likes = 0;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "data_atualizacao")
    private LocalDateTime updatedAt;

    @Column(name = "excluido", nullable = false)
    private boolean deleted = false;


    public CifraModel(Cifra cifra) {
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
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.deleted = false;
        this.creator = new UsuarioModel();
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
            this.creator.toEntity()
        );
    }
}
