package com.divino.hexagonal.infrastructure.jpa.repositories;

import com.divino.hexagonal.infrastructure.jpa.entities.PerfilEntity;
import org.springframework.data.repository.CrudRepository;

public interface PerfilJpaRepository extends CrudRepository<PerfilEntity, Long> {
}
