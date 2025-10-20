package com.alejo.persistence.auth.impl;

import com.alejo.entities.auth.Role;
import com.alejo.entities.auth.User;
import com.alejo.persistence.auth.IUserDAO;
import com.alejo.repository.auth.RoleRepository;
import com.alejo.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmailIgnoreCase(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
