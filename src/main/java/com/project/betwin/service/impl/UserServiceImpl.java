package com.project.betwin.service.impl;

import com.project.betwin.domain.User;
import com.project.betwin.dto.UserDTO;
import com.project.betwin.exception.UserException.UserNotFoundException;
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
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("The user was not found, please check ID"));
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
