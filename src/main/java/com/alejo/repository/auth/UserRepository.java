package com.alejo.repository.auth;

import com.alejo.entities.auth.Role;
import com.alejo.entities.auth.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findUserByEmailIgnoreCase(String email);

}
