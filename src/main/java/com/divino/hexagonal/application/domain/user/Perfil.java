package com.divino.hexagonal.application.domain.user;

import java.time.LocalDateTime;

public class Perfil {

    private Long id;
    private String nome;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Perfil(Long id, String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id = id;
        this.nome = nome;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public Perfil(String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.nome = nome;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public static Perfil criar(String nome) {
        return new Perfil(nome, LocalDateTime.now(), null);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }
}
