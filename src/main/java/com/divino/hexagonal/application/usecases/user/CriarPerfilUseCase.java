package com.divino.hexagonal.application.usecases.user;

import com.divino.hexagonal.application.domain.user.Perfil;
import com.divino.hexagonal.application.repositories.PerfilRepository;
import com.divino.hexagonal.application.usecases.UseCase;

import java.time.LocalDateTime;
import java.util.Objects;

public class CriarPerfilUseCase extends UseCase<CriarPerfilUseCase.Input, CriarPerfilUseCase.Output> {

    private final PerfilRepository perfilRepository;

    public CriarPerfilUseCase(final PerfilRepository perfilRepository) {
        this.perfilRepository = Objects.requireNonNull(perfilRepository);
    }

    @Override
    public Output executar(Input input) {
        final var perfil = this.perfilRepository.criar(Perfil.criar(input.nome));

        return new Output(perfil.getId(), perfil.getNome(), perfil.getCriadoEm());
    }

    public record Input(String nome) {
    }

    public record Output(Long id, String nome, LocalDateTime criadoEm) {
    }
}