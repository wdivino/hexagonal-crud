package com.divino.hexagonal.application.domain.user;

import java.time.LocalDateTime;

public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private UsuarioStatus status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private Perfil perfil;

    public Usuario(Long id, String nome, String email, UsuarioStatus status, LocalDateTime criadoEm, LocalDateTime atualizadoEm, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.status = status;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.perfil = perfil;
    }

    private Usuario(String nome, String email, UsuarioStatus status, LocalDateTime criadoEm, Perfil perfil) {
        this.nome = nome;
        this.email = email;
        this.status = status;
        this.criadoEm = criadoEm;
        this.perfil = perfil;
    }

    public static Usuario criar(String nome, String email, Perfil perfil) {
        return new Usuario(nome, email, UsuarioStatus.ATIVO, LocalDateTime.now(), perfil);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioStatus getStatus() {
        return status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}
