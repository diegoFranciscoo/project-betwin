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
        int random = RANDOM_NUMBER.nextInt(5) + 1;

        return switch (random) {
            case 1, 5, 4 -> {
                user.setAmount(user.getAmount().subtract(bet.amountBet()));
                yield new BetResponseDTO("You Lost :(", user);
            }
            case 2 -> {
                user.setAmount(user.getAmount().add(new BigDecimal(50)));
                yield new BetResponseDTO("Congratulations you won R$50!!!", user);
            }
            case 3 -> {
                user.setAmount(user.getAmount().add(new BigDecimal(100)));
                yield new BetResponseDTO("Congratulations you won R$100!!!", user);
            }
            default -> throw new ErrorProcessingBetException("error while processing the bet, please try again later");
        };
    }
}
