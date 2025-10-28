package com.alejo.repository.auth;

import com.alejo.entities.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmailIgnoreCase(String email);
    List<User> findAllByRole_Id(Integer id);

    List<User> findAllByRole_IdNot(Integer id);
}
