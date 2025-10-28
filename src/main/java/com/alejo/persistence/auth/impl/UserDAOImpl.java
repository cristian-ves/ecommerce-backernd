package com.alejo.persistence.auth.impl;

import com.alejo.entities.auth.User;
import com.alejo.persistence.auth.IUserDAO;
import com.alejo.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmailIgnoreCase(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllCommon() {
        return userRepository.findAllByRole_Id(4);
    }

    @Override
    public void toggleBan(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setSuspended(!user.getSuspended());
        userRepository.save(user);
    }

    @Override
    public List<User> findAllEmployees() {
        return userRepository.findAllByRole_IdNot(4);
    }

    @Override
    public User update(User updatedUser) {
        User user = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }


}
