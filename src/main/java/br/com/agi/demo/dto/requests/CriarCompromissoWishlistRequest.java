package br.com.agi.demo.dto.requests;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CriarCompromissoWishlistRequest(
        @NotBlank String wishlistId,
        @NotBlank String nome,
        String descricao

)
{
}
