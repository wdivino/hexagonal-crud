package com.divino.hexagonal.infrastructure.repositories;

import com.divino.hexagonal.application.domain.user.Perfil;
import com.divino.hexagonal.application.repositories.PerfilRepository;
import com.divino.hexagonal.infrastructure.jpa.entities.PerfilEntity;
import com.divino.hexagonal.infrastructure.jpa.repositories.PerfilJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

// Adapter
@Component
public class PerfilDatabaseRepository implements PerfilRepository {

    private final PerfilJpaRepository perfilJpaRepository;

    public PerfilDatabaseRepository(final PerfilJpaRepository perfilJpaRepository) {
        this.perfilJpaRepository = Objects.requireNonNull(perfilJpaRepository);
    }

    @Override
    public Optional<Perfil> perfilPorId(final Long id) {
        Objects.requireNonNull(id, "id não pode ser nulo");
        return this.perfilJpaRepository.findById(id)
                .map(PerfilEntity::paraPerfil);
    }

    @Override
    @Transactional
    public Perfil criar(final Perfil perfil) {
        return this.perfilJpaRepository.save(PerfilEntity.criar(perfil))
                .paraPerfil();
    }
}
