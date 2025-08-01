package com.fitness.userservice.service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse register(@Valid RegisterRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUser = repository.save(user);

        // Map to response DTO without the password for security
        return mapToUserResponse(savedUser);
    }

    @Transactional(readOnly = true)
    public UserResponse getUserProfile(UUID userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Map to response DTO without the password for security
        return mapToUserResponse(user);
    }

    // Helper method to map User to UserResponse without exposing password
    private UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return userResponse;
    }
}
