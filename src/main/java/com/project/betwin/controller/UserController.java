package com.project.betwin.controller;

import com.project.betwin.domain.User;
import com.project.betwin.dto.UserDTO;
import com.project.betwin.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;


    @Operation(description = "Create a new user")
    @ApiResponse(responseCode = "201")
    @PostMapping(path = "/register")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDTO user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }

    @Operation(description = "Return all users in the system")
    @ApiResponse(responseCode = "200")
    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<>(service.getUser(), HttpStatus.OK);
    }
}
