package model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "activities")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    private String id;

    @NotNull
    @Field("user_id")
    private String userId;

    @NotNull
    @Field("activity_type")
    private ActivityType type;

    @NotNull
    @Positive
    @Field("duration_minutes")
    private Integer duration;

    @Positive
    @Field("calories_burned")
    private Integer caloriesBurned;

    @NotNull
    @Field("start_time")
    private LocalDateTime startTime;

    @Field("additional_data")
    private Map<String, Object> additionalData;

    @CreatedDate
    @Field("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field("updated_at")
    private LocalDateTime updatedAt;
}
