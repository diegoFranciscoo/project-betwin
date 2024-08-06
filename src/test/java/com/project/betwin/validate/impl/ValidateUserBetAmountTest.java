package com.project.betwin.validate.impl;

import com.project.betwin.domain.User;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.exception.BetException.InsufficientAmountException;
import com.project.betwin.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidateUserBetAmountTest {

    @InjectMocks
    private ValidateUserBetAmount validate;
    @Mock
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp(){
        user = new User(1L, "testing",new BigDecimal(50), 20, "123456788", "testing12344@gmail.com");
    }

    @Test
    @DisplayName("validate throw InsufficientAmountException when user does not have enough amount")
    void validate_ThrowInsufficientAmountException_WhenUserNotHaveEnoughAmount(){
        var bet = new BetRequestDTO(new BigDecimal(100),1L);
        when(userService.findById(1L)).thenReturn(user);

        assertThrows(InsufficientAmountException.class, () -> validate.validate(bet));
    }
    @Test
    @DisplayName("validates that InsufficientAmountException will not be thrown when successful")
    void validate_NoExceptionIsThrown_WhenSuccessful(){
        var bet = new BetRequestDTO(new BigDecimal(20),1L);
        when(userService.findById(1L)).thenReturn(user);

        assertDoesNotThrow(() -> validate.validate(bet));

    }
}