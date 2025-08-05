package com.fitness.activityservice.service;

import com.fitness.activityservice.ActivityRepository;
import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    @Autowired

    private ActivityRepository activityRepository;
    public ActivityResponse trackActivity(ActivityRequest request){}
    Activity activity= Activity.builder().userId().type(request.getType())
            .duration(request.getDuration())
            .caloriesBurned(request.getCaloriesBurned())
            .startTime(request.getstartTime())
            .build();
    Activity savedActivity = activityRepository.save(activity);
    return

}
private ActivityResponse mapToResponse(Activity activity){
    ActivityRepository response = new ActivityResponse();

}}

