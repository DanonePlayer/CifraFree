package com.example.CifraFree.application.cifra.dto;

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
}