package br.com.agi.demo.dto.requests;

import jakarta.validation.constraints.NotBlank;

public record CriarCalendarioRequest(@NotBlank String usuarioId) {

}
