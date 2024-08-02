package com.project.betwin.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record BetRequestDTO(
        @NotNull(message = "The amount cannot be null")
        BigDecimal amountBet,

        @NotNull(message = "The amount cannot be null")
        Long userId
) {
}
