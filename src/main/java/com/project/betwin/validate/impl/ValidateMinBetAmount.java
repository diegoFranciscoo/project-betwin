package com.project.betwin.validate.impl;

import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.validate.ValidateBet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidateMinBetAmount implements ValidateBet {

    @Override
    public void validate(BetRequestDTO bet) {
        if (bet.amountBet().compareTo(new BigDecimal(20)) < 0){
            throw new IllegalArgumentException("The minimum amount to bet is R$20");
        }
    }
}
