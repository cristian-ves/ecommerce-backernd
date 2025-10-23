package com.alejo.persistence.auth;

import com.alejo.entities.auth.User;

import java.util.Optional;

public interface IUserDAO {

    Optional<User> findByEmail(String email);
    User save(User user);
    Optional<User> findById(Integer id);

}
