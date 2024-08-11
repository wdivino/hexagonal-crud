package com.divino.hexagonal.infrastructure.jpa.entities;

import com.divino.hexagonal.application.domain.user.Perfil;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Perfil")
@Table(name = "PERFIL")
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;

    public PerfilEntity() {
    }

    private PerfilEntity(Long id, String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id = id;
        this.nome = nome;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    private PerfilEntity(String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.nome = nome;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public static PerfilEntity criar(final Perfil perfil) {
        return new PerfilEntity(perfil.getNome(), perfil.getCriadoEm(), perfil.getAtualizadoEm());
    }

    public static PerfilEntity de(final Perfil perfil) {
        return new PerfilEntity(perfil.getId(), perfil.getNome(), perfil.getCriadoEm(), perfil.getAtualizadoEm());
    }

    public Perfil paraPerfil() {
        return new Perfil(this.id, this.nome, this.criadoEm, this.atualizadoEm);
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
