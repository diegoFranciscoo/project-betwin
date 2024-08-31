package com.project.betwin.controller;

import com.project.betwin.domain.Bet;
import com.project.betwin.dto.BetRequestDTO;
import com.project.betwin.dto.BetResponseDTO;
import com.project.betwin.service.impl.BetServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = "Create a new bet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully create a bet"),
            @ApiResponse(responseCode = "400", description = "Throws MinimalAmountException, InsufficientAmountException, or ErrorProcessingBetException based on the condition")
    })
    @PostMapping
    public ResponseEntity<BetResponseDTO> createBet(@RequestBody @Valid BetRequestDTO bet) {
        return new ResponseEntity<>(service.createBet(bet), HttpStatus.CREATED);
    }

    @Operation(description = "Returns all bets in the system")
    @GetMapping
    public ResponseEntity<List<Bet>> getBet() {
        return new ResponseEntity<>(service.getBet(), HttpStatus.OK);
    }
}
