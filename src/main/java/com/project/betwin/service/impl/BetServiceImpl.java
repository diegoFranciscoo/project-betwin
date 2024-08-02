package com.project.betwin.service.impl;

import com.project.betwin.domain.Bet;
import com.project.betwin.domain.User;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.dto.BetResponseDTO;
import com.project.betwin.repository.BetRepository;
import com.project.betwin.service.BetService;
import com.project.betwin.service.UserService;
import com.project.betwin.validate.ValidateBet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetServiceImpl implements BetService {

    private final BetRepository betRepository;
    private final List<ValidateBet> validateBets;
    private final UserService userService;
    private final BetResultProcessorServiceImpl betResultProcessor;

    @Override
    public List<Bet> getBet() {
        return betRepository.findAll();
    }

    @Override
    public BetResponseDTO createBet(BetRequestDTO bet) {
        validateBets.forEach(validate -> validate.validate(bet));

        User user = userService.findById(bet.userId());

        BetResponseDTO betResponse = betResultProcessor.betProcessor(bet, user);

        userService.save(betResponse.user());

        var newBet = Bet.builder()
                .amountBet(bet.amountBet())
                .user(betResponse.user())
                .build();
        betRepository.save(newBet);

        return new BetResponseDTO(betResponse.message(), betResponse.user());
    }


}
