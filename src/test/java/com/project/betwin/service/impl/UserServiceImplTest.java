package com.project.betwin.service.impl;

import com.project.betwin.domain.User;
import com.project.betwin.exception.UserException.UserNotFoundException;
import com.project.betwin.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserRepository repository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1L, "testing", new BigDecimal(1700), 20, "123456578", "testing1234@gmail.com");
    }

    @Test
    @DisplayName("save returns and creates a new user")
    void save_ReturnAndCreateNewUser_WhenSuccessfully() {
        when(repository.save(any(User.class))).thenReturn(user);
        User userSaved = service.save(user);

        assertNotNull(userSaved);
        assertEquals(userSaved.getId(), user.getId());
    }
    @Test
    @DisplayName("findById returns user by id")
    void findById_ReturnUserById_WhenSuccessfully(){
        when(repository.findById(1L)).thenReturn(Optional.of(user));
        User userById = service.findById(1L);

        assertDoesNotThrow(() -> service.findById(1L));
        assertNotNull(userById);
        assertEquals(userById.getId(), user.getId());
    }

    @Test
    @DisplayName("findById throw UserNotFoundException when user is not found")
    void findById_ThrowUserNotFoundException_WhenUserNotFound(){
        assertThrows(UserNotFoundException.class, () -> service.findById(2L));
    }

}