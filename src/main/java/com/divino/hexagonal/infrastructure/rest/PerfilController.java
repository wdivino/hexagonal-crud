package com.divino.hexagonal.infrastructure.rest;

import com.divino.hexagonal.application.exceptions.ValidationException;
import com.divino.hexagonal.application.usecases.user.CriarPerfilUseCase;
import com.divino.hexagonal.infrastructure.dtos.NovoPerfilDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping(value = "perfis")
public class PerfilController {

    private final CriarPerfilUseCase criarPerfilUseCase;

    public PerfilController(final CriarPerfilUseCase criarPerfilUseCase) {
        this.criarPerfilUseCase = Objects.requireNonNull(criarPerfilUseCase);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody final NovoPerfilDTO dto) {
        try {
            final var output =
                    this.criarPerfilUseCase.executar(new CriarPerfilUseCase.Input(dto.nome()));

            return ResponseEntity.created(URI.create("/perfis/%s".formatted(output.id()))).body(output);
        } catch (ValidationException ex) {
            return ResponseEntity.unprocessableEntity().body(ex.getMessage());
        }
    }
}
