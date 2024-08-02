package com.project.betwin.service;

import com.project.betwin.domain.User;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.dto.BetResponseDTO;

public interface BetResultProcessorService {
    public BetResponseDTO betProcessor(BetRequestDTO bet, User user);
}
