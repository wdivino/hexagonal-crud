package com.divino.hexagonal.infrastructure.configurations;

import com.divino.hexagonal.application.repositories.PerfilRepository;
import com.divino.hexagonal.application.repositories.UsuarioRepository;
import com.divino.hexagonal.application.usecases.user.CriarPerfilUseCase;
import com.divino.hexagonal.application.usecases.user.CriarUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class UseCaseConfig {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public UseCaseConfig(
            final UsuarioRepository usuarioRepository,
            final PerfilRepository perfilRepository
    ) {
        this.usuarioRepository = Objects.requireNonNull(usuarioRepository);
        this.perfilRepository = Objects.requireNonNull(perfilRepository);
    }

    @Bean
    public CriarUsuarioUseCase criarUsuarioUseCase() {
        return new CriarUsuarioUseCase(usuarioRepository, perfilRepository);
    }

    @Bean
    public CriarPerfilUseCase criarPerfilUseCase() {
        return new CriarPerfilUseCase(perfilRepository);
    }
}
