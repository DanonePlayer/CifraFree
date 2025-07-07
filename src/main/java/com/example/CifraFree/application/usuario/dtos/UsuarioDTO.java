package com.example.CifraFree.application.usuario.dtos;

import com.example.CifraFree.domain.usuario.entities.Usuario;
import com.example.CifraFree.infra.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;

    public UsuarioDTO(String name, String email, String password, Role role) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Usuario toEntity() {
        return new Usuario(this.id, this.name, this.email, this.password, this.role);
    }
}
