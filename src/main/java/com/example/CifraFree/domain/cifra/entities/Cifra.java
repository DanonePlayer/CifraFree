package com.example.CifraFree.domain.cifra.entities;

import java.time.LocalDateTime;

import com.example.CifraFree.domain.usuario.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cifra {
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
}