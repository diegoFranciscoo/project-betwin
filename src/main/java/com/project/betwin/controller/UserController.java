package com.project.betwin.controller;

import com.project.betwin.domain.User;
import com.project.betwin.dto.UserDTO;
import com.project.betwin.service.UserService;
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

    @PostMapping(path = "/register")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDTO user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<>(service.getUser(), HttpStatus.OK);
    }
}
