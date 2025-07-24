package com.fitness.userservice.dto;

import com.fitness.userservice.model.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class UserResponse {

    private UUID id;


    private String email;


    private String password;

    private String firstName;
    private String lastName;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
