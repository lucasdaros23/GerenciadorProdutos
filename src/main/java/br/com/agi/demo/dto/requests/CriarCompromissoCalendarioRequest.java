package br.com.agi.demo.dto.requests;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CriarCompromissoCalendarioRequest(
        String calendarioId,
        String nome,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim
)
{
}
