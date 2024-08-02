package com.project.betwin.controller;

import com.project.betwin.domain.Bet;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.dto.BetResponseDTO;
import com.project.betwin.service.impl.BetServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bet")
@RequiredArgsConstructor
public class BetController {
    private final BetServiceImpl service;

    @PostMapping
    public ResponseEntity<BetResponseDTO> createBet(@RequestBody @Valid BetRequestDTO bet) {
        return new ResponseEntity<>(service.createBet(bet), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bet>> getBet(){
        return new ResponseEntity<>(service.getBet(), HttpStatus.OK);
    }
}
