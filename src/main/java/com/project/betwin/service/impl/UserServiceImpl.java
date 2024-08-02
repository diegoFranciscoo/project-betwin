package com.project.betwin.service.impl;

import com.project.betwin.domain.User;
import com.project.betwin.dto.UserDTO;
import com.project.betwin.repository.UserRepository;
import com.project.betwin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User createUser(UserDTO userDTO) {
        var newUser = new User(userDTO);
        return repository.save(newUser);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getUser() {
        return repository.findAll();
    }

}
