package com.project.betwin.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "bet")
@Table(name = "bet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amountBet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
