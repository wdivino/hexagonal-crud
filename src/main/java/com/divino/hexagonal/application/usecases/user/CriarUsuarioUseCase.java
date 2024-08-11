package com.divino.hexagonal.application.usecases.user;

import com.divino.hexagonal.application.domain.user.Usuario;
import com.divino.hexagonal.application.exceptions.ValidationException;
import com.divino.hexagonal.application.repositories.PerfilRepository;
import com.divino.hexagonal.application.repositories.UsuarioRepository;
import com.divino.hexagonal.application.usecases.UseCase;

import java.util.Objects;

public class CriarUsuarioUseCase extends UseCase<CriarUsuarioUseCase.Input, CriarUsuarioUseCase.Output> {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public CriarUsuarioUseCase(final UsuarioRepository usuarioRepository, final PerfilRepository perfilRepository) {
        this.usuarioRepository = Objects.requireNonNull(usuarioRepository);
        this.perfilRepository = Objects.requireNonNull(perfilRepository);
    }

    @Override
    public Output executar(final Input input) {
        final var perfil = this.perfilRepository.perfilPorId(input.idPerfil)
                .orElseThrow(() -> new ValidationException("Perfil não encontrado"));

        if (this.usuarioRepository.usuarioPorEmail(input.email).isPresent()) {
            throw new ValidationException("Usuario já existe");
        }

        final var usuario = this.usuarioRepository.criar(Usuario.criar(input.nome, input.email, perfil));

        return new Output(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    public record Input(String nome, String email, Long idPerfil) {
    }

    public record Output(Long id, String nome, String email) {
    }
}
