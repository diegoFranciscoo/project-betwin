package com.project.betwin.service;

import com.project.betwin.domain.User;
import com.project.betwin.dto.UserDTO;

import java.util.List;

public interface UserService {
    public User createUser(UserDTO userDTO);

    public User findById(Long id);

    public User save(User user);
    public List<User> getUser();
}
