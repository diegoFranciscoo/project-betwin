package com.project.betwin.service.impl;

import com.project.betwin.domain.User;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.dto.BetResponseDTO;
import com.project.betwin.exception.BetException.ErrorProcessingBetException;
import com.project.betwin.service.BetResultProcessorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class BetResultProcessorServiceImpl implements BetResultProcessorService {
    private static final Random RANDOM_NUMBER = new Random();

    @Override
    public BetResponseDTO betProcessor(BetRequestDTO bet, User user) {
        int random = RANDOM_NUMBER.nextInt(8) + 1;

        user.setAmount(user.getAmount().subtract(bet.amountBet()));

        return switch (random) {
            case 1, 5 -> {
                user.setAmount(bet.amountBet().multiply(BigDecimal.valueOf(1.5)).add(user.getAmount()));
                yield new BetResponseDTO("\uD83D\uDFE3 Purple 1.5x", user);
            }
            case 2 -> {
                user.setAmount(bet.amountBet().multiply(BigDecimal.valueOf(2)).add(user.getAmount()));
                yield new BetResponseDTO("⚫ Black 2.0x", user);
            }
            case 3 -> {
                user.setAmount(bet.amountBet().multiply(BigDecimal.valueOf(3.5)).add(user.getAmount()));
                yield new BetResponseDTO("⚪ White 3.5x", user);
            }
            case 6, 7, 4 -> {
                user.setAmount(bet.amountBet().multiply(BigDecimal.valueOf(0.5)).add(user.getAmount()));
                yield new BetResponseDTO("\uD83D\uDD34 Red 0.5x", user);
            }
            case 8 -> new BetResponseDTO("\uD83D\uDFE8 Yellow 0.0x", user);

            default -> throw new ErrorProcessingBetException("error while processing the bet, please try again later");
        };
    }
}
