package com.example.CifraFree.domain.usuario.entities;

import com.example.CifraFree.infra.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
