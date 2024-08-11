package com.divino.hexagonal.infrastructure.repositories;

import com.divino.hexagonal.application.domain.user.Usuario;
import com.divino.hexagonal.application.domain.user.UsuarioStatus;
import com.divino.hexagonal.application.repositories.UsuarioRepository;
import com.divino.hexagonal.infrastructure.jpa.entities.UsuarioEntity;
import com.divino.hexagonal.infrastructure.jpa.repositories.UsuarioJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Adapter
@Component
public class UsuarioDatabaseRepository implements UsuarioRepository {

    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioDatabaseRepository(final UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = Objects.requireNonNull(usuarioJpaRepository);
    }

    @Override
    public Optional<Usuario> usuarioPorId(final Long id) {
        Objects.requireNonNull(id, "id não pode ser nulo");
        return this.usuarioJpaRepository.findById(id)
                .map(UsuarioEntity::paraUsuario);
    }

    @Override
    public Optional<Usuario> usuarioPorEmail(final String email) {
        Objects.requireNonNull(email, "email não pode ser nulo");
        return this.usuarioJpaRepository.findByEmail(email)
                .map(UsuarioEntity::paraUsuario);
    }

    @Override
    public List<Usuario> usuariosPorStatus(final UsuarioStatus status) {
        return this.usuarioJpaRepository.findByStatus(status).stream()
                .map(UsuarioEntity::paraUsuario)
                .toList();
    }

    @Override
    @Transactional
    public Usuario criar(final Usuario usuario) {
        return this.usuarioJpaRepository.save(UsuarioEntity.criar(usuario))
                .paraUsuario();
    }

    @Override
    @Transactional
    public Usuario atualizar(final Usuario usuario) {
        return this.usuarioJpaRepository.save(UsuarioEntity.de(usuario))
                .paraUsuario();
    }

    @Override
    public void remover(final Long id) {
        Objects.requireNonNull(id, "id não pode ser nulo");
        this.usuarioJpaRepository.deleteById(id);
    }
}
