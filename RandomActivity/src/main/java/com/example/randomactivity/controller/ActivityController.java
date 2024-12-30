package com.example.randomactivity.controller;

import com.example.randomactivity.model.Activity;
import com.example.randomactivity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;



    @GetMapping("/test")
    public String testRepository(){
        Activity activity = new Activity();
        activity.setName("Test Activity");
        activity.setCategory("Test Category");
        activityRepository.save(activity);

        return "Activity saved with ID: " + activity.getId();
    }
}
