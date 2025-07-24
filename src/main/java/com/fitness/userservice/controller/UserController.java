package com.fitness.userservice.controller;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/{user}")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse>getUserProfile(@PathVariable String user){
        return ResponseEntity.ok(UserService.getUserProfile(user));

    }
    @GetMapping("/register ")
    public ResponseEntity<UserResponse>register ( @Valid  @PathVariable RegisterRequest request){
        return ResponseEntity.ok(UserService.register(request));

    }
}
