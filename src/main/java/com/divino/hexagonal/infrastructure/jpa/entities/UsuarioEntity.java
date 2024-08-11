package com.divino.hexagonal.infrastructure.jpa.entities;

import com.divino.hexagonal.application.domain.user.Usuario;
import com.divino.hexagonal.application.domain.user.UsuarioStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Usuario")
@Table(name = "USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @Enumerated(EnumType.STRING)
    private UsuarioStatus status;

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;

    @OneToOne
    @JoinColumn(name = "id_perfil")
    private PerfilEntity perfil;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nome, String email, UsuarioStatus status, LocalDateTime criadoEm, LocalDateTime atualizadoEm, PerfilEntity perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.status = status;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.perfil = perfil;
    }

    public UsuarioEntity(String nome, String email, UsuarioStatus status, LocalDateTime criadoEm, LocalDateTime atualizadoEm, PerfilEntity perfil) {
        this.nome = nome;
        this.email = email;
        this.status = status;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.perfil = perfil;
    }

    public static UsuarioEntity criar(final Usuario usuario) {
        return new UsuarioEntity(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getStatus(),
                usuario.getCriadoEm(),
                usuario.getAtualizadoEm(),
                PerfilEntity.de(usuario.getPerfil()));
    }

    public static UsuarioEntity de(final Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getStatus(),
                usuario.getCriadoEm(),
                usuario.getAtualizadoEm(),
                PerfilEntity.de(usuario.getPerfil()));
    }

    public Usuario paraUsuario() {
        return new Usuario(
                this.id,
                this.nome,
                this.email,
                this.status,
                this.criadoEm,
                this.atualizadoEm,
                perfil.paraPerfil());
    }
}
