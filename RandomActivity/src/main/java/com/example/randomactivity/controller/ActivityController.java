package com.example.randomactivity.controller;

import com.example.randomactivity.model.Activity;
import com.example.randomactivity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
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
    @GetMapping("/activities")
    public Object getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        if (activities.isEmpty()){
            return "There are no records";
        }
        return activities;
    }
    @GetMapping("/activities/random")
    public Object getRandomActivity(){
        Activity randomActivity= activityRepository.findRandomActivity();
        if(randomActivity==null){
            return "there are no records";
        }
        return randomActivity;
    }

}
