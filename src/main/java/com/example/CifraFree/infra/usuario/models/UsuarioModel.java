package com.example.CifraFree.infra.usuario.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.example.CifraFree.domain.usuario.entities.Usuario;
import com.example.CifraFree.infra.Enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE usuarios SET excluido = true WHERE id = ?")
@SQLRestriction("excluido = false")
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String password;

    @Column(name = "funcao", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "data_atualizacao")
    private LocalDateTime updatedAt;


    @Column(name = "excluido", nullable = false)
    private boolean deleted = false;

    @Column(name = "ativo", nullable = false)
    private boolean active = true;


    public UsuarioModel(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.role = usuario.getRole();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.deleted = false;
        this.active = true;
    }
    
    public Usuario toEntity() {
        return new Usuario(this.id, this.name, this.email, this.password, this.role, this.createdAt, this.updatedAt, this.deleted, this.active);
    }
}
