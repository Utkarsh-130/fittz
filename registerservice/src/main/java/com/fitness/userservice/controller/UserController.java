package com.fitness.userservice.controller;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userID}")
    public ResponseEntity<UserResponse> getUserProfile(@Valid String userID) {

        return  ResponseEntity.ok(userService.getUserProfile(UUID.fromString(userID)));
    }

@PostMapping("/register")
public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
    UserResponse response = userService.register(registerRequest);
    return ResponseEntity.ok(response);
}}