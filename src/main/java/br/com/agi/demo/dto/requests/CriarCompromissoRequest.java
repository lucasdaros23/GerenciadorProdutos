package br.com.agi.demo.dto.requests;

import br.com.agi.demo.entity.enums.TipoCompromissoPai;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CriarCompromissoRequest(
        @NotBlank String nome,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        @NotNull
        TipoCompromissoPai tipo,
        @NotBlank
        String paiId

) {
}
