package com.project.betwin.validate.impl;

import com.project.betwin.domain.User;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.service.UserService;
import com.project.betwin.validate.ValidateBet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateUserBetAmount implements ValidateBet {
    private final UserService service;

    @Override
    public void validate(BetRequestDTO bet) {
        User user = service.findById(bet.userId());

        if (user.getAmount().compareTo(bet.amountBet()) < 0 ){
            throw new IllegalArgumentException("Insufficient amount to complete the bet");
        }
    }
}
