package com.project.betwin.validate.impl;

import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.exception.BetException.MinimalAmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidateMinBetAmountTest {
    @InjectMocks
    private ValidateMinBetAmount validate;


    @Test
    @DisplayName("validate throw MinimalAmountException when the amount is less than $20")
    void validate_ThrowMinimalAmountException_WhenAmountIsLessThan20() {
        var bet = new BetRequestDTO(new BigDecimal(10), 1L);
        assertThrows(MinimalAmountException.class, () -> validate.validate(bet));
    }
    @Test
    @DisplayName("validate that no exception is thrown when successful")
    void validate_NoExceptionIsThrown_WhenSuccessful(){
        var bet = new BetRequestDTO(new BigDecimal(30), 1L);
        assertDoesNotThrow(() -> validate.validate(bet));
    }
}