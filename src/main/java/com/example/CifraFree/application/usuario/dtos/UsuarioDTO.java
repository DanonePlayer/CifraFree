package com.example.CifraFree.application.usuario.dtos;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted = false;
    private boolean active = true;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.role = usuario.getRole();
        this.active = usuario.isActive();
        this.deleted = usuario.isDeleted();
        this.createdAt = usuario.getCreatedAt();
        this.updatedAt = usuario.getUpdatedAt();
    }

    public Usuario toEntity() {
        return new Usuario(this.id, this.name, this.email, this.password, this.role, this.createdAt, this.updatedAt, this.deleted, this.active);
    }
}
