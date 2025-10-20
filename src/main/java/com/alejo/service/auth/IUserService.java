package com.alejo.service.auth;

import com.alejo.controllers.auth.dto.RegisterRequestDTO;
import com.alejo.entities.auth.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findByEmail(String email);
    User register(RegisterRequestDTO registerRequestDTO);

}
