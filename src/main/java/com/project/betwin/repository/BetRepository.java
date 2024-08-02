package com.project.betwin.repository;

import com.project.betwin.domain.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
}
