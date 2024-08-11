package com.divino.hexagonal.infrastructure.jpa.repositories;

import com.divino.hexagonal.application.domain.user.UsuarioStatus;
import com.divino.hexagonal.infrastructure.jpa.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioJpaRepository extends CrudRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByEmail(final String email);

    List<UsuarioEntity> findByStatus(final UsuarioStatus status);
}
