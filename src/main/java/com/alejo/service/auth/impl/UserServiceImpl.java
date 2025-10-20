package com.alejo.service.auth.impl;

import com.alejo.controllers.auth.dto.RegisterRequestDTO;
import com.alejo.entities.auth.Role;
import com.alejo.entities.auth.User;
import com.alejo.persistence.auth.IUserDAO;
import com.alejo.repository.auth.RoleRepository;
import com.alejo.service.auth.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public User register(RegisterRequestDTO registerRequestDTO) {
        Optional<User> existingUser = userDAO.findByEmail(registerRequestDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        Role role = roleRepository.findById(registerRequestDTO.getRoleId()).
                orElseThrow(() -> new RuntimeException("Role not found"));

        User newUser = User.builder()
                .name(registerRequestDTO.getName())
                .email(registerRequestDTO.getEmail())
                .password(registerRequestDTO.getPassword())
                .role(role)
                .suspended(false)
                .build();

        return userDAO.save(newUser);
    }
}
