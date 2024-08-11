package com.divino.hexagonal.application.repositories;

import com.divino.hexagonal.application.domain.user.Perfil;

import java.util.Optional;

public interface PerfilRepository {

    Optional<Perfil> perfilPorId(Long id);

    Perfil criar(Perfil perfil);
}
