package com.example.CifraFree.domain.cifra.entities;

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
    private Long idCriador;
    private String observation;
}