package com.project.betwin.service.impl;

import com.project.betwin.domain.Bet;
import com.project.betwin.domain.User;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.dto.BetResponseDTO;
import com.project.betwin.repository.BetRepository;
import com.project.betwin.service.UserService;
import com.project.betwin.validate.ValidateBet;
import com.project.betwin.validate.impl.ValidateMinBetAmount;
import com.project.betwin.validate.impl.ValidateUserBetAmount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BetServiceImplTest {

    @InjectMocks
    private BetServiceImpl betService;
    @Mock
    private BetRepository betRepository;


    private BetRequestDTO betRequestDTO;
    private User user;
    private BetResponseDTO betResponseDTO;
    private Bet bet;


    @BeforeEach
    void setUp() {
        user = new User(1L, "testing", new BigDecimal(1000), 20, "123456578", "testing1234@gmail.com");
        betRequestDTO = new BetRequestDTO(new BigDecimal(30), 1L);
        betResponseDTO = new BetResponseDTO("You Lost :(", user);

        bet = Bet.builder()
                .id(1L)
                .amountBet(betRequestDTO.amountBet())
                .user(betResponseDTO.user())
                .build();
    }

    @Test
    @DisplayName("createBet creates new bet and returns BetResponseDTO")
    void createBet_CreateNewBet_WhenSuccessfully() {
        when(betRepository.save(bet)).thenReturn(bet);
        Bet betSaved = betRepository.save(bet);

        assertNotNull(betSaved);
        assertEquals(betSaved.getId(), bet.getId());

    }

    @Test
    @DisplayName("getBet returns list of bet")
    void getBet_ReturnListOfBet_WhenSuccessfully(){
        List<Bet> betList = List.of(bet);
        when(betRepository.findAll()).thenReturn(betList);
        List<Bet> getBet = betService.getBet();

        assertNotNull(getBet);
        assertEquals(1, getBet.size());
        assertEquals(getBet.getFirst().getId(), betList.getFirst().getId());
    }
}