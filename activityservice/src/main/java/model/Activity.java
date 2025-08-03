package com.fitness.activityservice.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

public class Activity {
    @Id
    private String id;

    @NotNull
    @Field("user_id")
    private String userId;

    @NotNull
    @Field("activity_type")
    private com.fitness.activityservice.model.ActivityType type;

    @NotNull
    @Positive(message = "Duration must be a positive number.")
    @Field("duration_minutes")
    private Integer duration;

    @Positive(message = "Calories burned must be a positive number.")
    @Field("calories_burned")
    private Integer caloriesBurned;

    @NotNull
    @Field("start_time")
    private LocalDateTime startTime;

    @Field("additional_metrics")
    private Map<String, Object> additionalMetrics;

    @CreatedDate
    @Field("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field("updated_at")
    private LocalDateTime updatedAt;
}