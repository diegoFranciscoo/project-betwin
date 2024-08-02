package com.project.betwin.validate.impl;

import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.exception.BetException.MinimalAmountException;
import com.project.betwin.validate.ValidateBet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidateMinBetAmount implements ValidateBet {

    @Override
    public void validate(BetRequestDTO bet) {
        if (bet.amountBet().compareTo(new BigDecimal(20)) < 0){
            throw new MinimalAmountException("the minimum amount to place a bet is $20");
        }
    }
}
