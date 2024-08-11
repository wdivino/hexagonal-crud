package com.divino.hexagonal.infrastructure.rest;

import com.divino.hexagonal.application.exceptions.ValidationException;
import com.divino.hexagonal.application.usecases.user.CriarUsuarioUseCase;
import com.divino.hexagonal.infrastructure.dtos.NovoUsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

    private final CriarUsuarioUseCase criarUsuarioUseCase;

    public UsuarioController(final CriarUsuarioUseCase criarUsuarioUseCase) {
        this.criarUsuarioUseCase = Objects.requireNonNull(criarUsuarioUseCase);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody final NovoUsuarioDTO dto) {
        try {
            final var output =
                this.criarUsuarioUseCase.executar(new CriarUsuarioUseCase.Input(dto.nome(), dto.email(), dto.idPerfil()));

            return ResponseEntity.created(URI.create("/usuarios/%s".formatted(output.id()))).body(output);
        } catch (ValidationException ex) {
            return ResponseEntity.unprocessableEntity().body(ex.getMessage());
        }
    }
}
