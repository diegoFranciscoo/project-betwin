package com.project.betwin.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record BetRequestDTO(
        @NotNull(message = "O campo não pode ser nulo")
        BigDecimal amountBet,

        @NotNull(message = "O campo não pode ser nulo")
        Long userId
) {
}
