package com.project.betwin.service;

import com.project.betwin.domain.Bet;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.dto.BetResponseDTO;

import java.util.List;

public interface BetService {
    BetResponseDTO createBet(BetRequestDTO bet);

    List<Bet> getBet();
}
