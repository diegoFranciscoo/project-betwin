package com.project.betwin.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record UserDTO(
        @NotBlank(message = "The name cannot be blank")
        @Size(min = 3, max = 25)
        String name,

        @NotNull(message = "The amount cannot be null")
        @Positive
        BigDecimal amount,

        @NotNull(message = "The age cannot be null")
        @Min(value = 18, message = "You must be over 18 years old to register")
        Integer age,

        @NotBlank(message = "The CPF cannot be blank")
        String cpf,

        @NotBlank(message = "The email cannot be blank")
        @Email(message = "Email must be valid")
        String email

) {
}
