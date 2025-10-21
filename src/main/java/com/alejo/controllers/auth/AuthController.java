package com.alejo.controllers.auth;

import com.alejo.controllers.auth.dto.LoginRequestDTO;
import com.alejo.controllers.auth.dto.RegisterRequestDTO;
import com.alejo.controllers.auth.dto.UserDTO;
import com.alejo.entities.auth.User;
import com.alejo.security.JwtUtils;
import com.alejo.service.auth.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        Optional<User> userOptional = userService.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getPassword().equals(loginRequest.getPassword())) {
                String token = jwtUtils.generateToken(user.getEmail());
                UserDTO userDTO = UserDTO.builder()
                        .id(user.getId())
                        .role(user.getRole())
                        .name(user.getName())
                        .email(user.getEmail())
                        .suspended(user.getSuspended())
                        .build();
                return ResponseEntity.ok(Map.of(
                                "token", token,
                                "user", userDTO
                        )
                );
            } else {
                return ResponseEntity.status(401).body("Invalid credentials");
            }
        }

        return ResponseEntity.status(404).body("User not found");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO) {

        if(registerRequestDTO.getName().isEmpty() || registerRequestDTO.getEmail().isEmpty() || registerRequestDTO.getPassword().isEmpty()) {
            return ResponseEntity.status(400).body("All fields are mandatory");
        }

        try {
            User newUser = userService.register(registerRequestDTO);
            String token = jwtUtils.generateToken(newUser.getEmail());

            UserDTO userDTO = UserDTO.builder()
                    .id(newUser.getId())
                    .role(newUser.getRole())
                    .name(newUser.getName())
                    .email(newUser.getEmail())
                    .suspended(newUser.getSuspended())
                    .build();
            return ResponseEntity.status(201).body(Map.of(
                    "token", token,
                    "user", userDTO
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


}
