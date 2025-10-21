package com.alejo.controllers.auth;

import com.alejo.controllers.auth.dto.*;
import com.alejo.entities.auth.User;
import com.alejo.security.JwtUtils;
import com.alejo.service.auth.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Optional<User> userOpt = userService.findByEmail(loginRequest.getEmail());

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        User user = userOpt.get();
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtils.generateToken(user.getEmail());
        UserDTO userDTO = mapToDTO(user);
        AuthResponseDTO response = AuthResponseDTO.builder()
                .token(token)
                .user(userDTO)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        if (registerRequestDTO.getName().isEmpty() ||
                registerRequestDTO.getEmail().isEmpty() ||
                registerRequestDTO.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("All fields are mandatory");
        }

        try {
            User newUser = userService.register(registerRequestDTO);
            String token = jwtUtils.generateToken(newUser.getEmail());
            UserDTO userDTO = mapToDTO(newUser);
            AuthResponseDTO response = AuthResponseDTO.builder()
                    .token(token)
                    .user(userDTO)
                    .build();

            return ResponseEntity.status(201).body(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Missing token");
        }

        String token = authHeader.substring(7);
        if (!jwtUtils.validateToken(token)) {
            return ResponseEntity.status(401).body("Invalid token");
        }

        String email = jwtUtils.getUsernameFromToken(token);
        Optional<User> userOpt = userService.findByEmail(email);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        UserDTO userDTO = mapToDTO(userOpt.get());
        return ResponseEntity.ok(new AuthResponseDTO(null, userDTO));
    }

    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .suspended(user.getSuspended())
                .role(user.getRole())
                .build();
    }
}
