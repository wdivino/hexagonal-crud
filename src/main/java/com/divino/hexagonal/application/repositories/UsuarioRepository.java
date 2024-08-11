package com.divino.hexagonal.application.repositories;

import com.divino.hexagonal.application.domain.user.Usuario;
import com.divino.hexagonal.application.domain.user.UsuarioStatus;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    Optional<Usuario> usuarioPorId(final Long id);

    Optional<Usuario> usuarioPorEmail(final String email);

    List<Usuario> usuariosPorStatus(final UsuarioStatus status);

    Usuario criar(final Usuario usuario);

    Usuario atualizar(final Usuario usuario);

    void remover(final Long id);
}
