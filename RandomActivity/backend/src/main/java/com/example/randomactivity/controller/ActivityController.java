package com.example.randomactivity.controller;

import com.example.randomactivity.model.Activity;
import com.example.randomactivity.model.Favorite;
import com.example.randomactivity.model.History;
import com.example.randomactivity.repository.ActivityRepository;
import com.example.randomactivity.repository.FavoriteRepository;
import com.example.randomactivity.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
public class ActivityController {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/test")
    public String testRepository(){
        Activity activity = new Activity();
        activity.setName("Test Activity");
        activity.setCategory("Test Category");
        activityRepository.save(activity);

        return "Activity saved with ID: " + activity.getId();
    }
    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        if (activities.isEmpty()) {
            throw new IllegalArgumentException("There are no records.");
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
    @PostMapping("/favorites")
    public String addToFavorites(@RequestParam Long activityId){
        Activity activity=activityRepository.findById(activityId)
                .orElseThrow(() -> new IllegalArgumentException("Activity with ID " + activityId + "NOT FOUND. "));
        Favorite favorite=new Favorite();
        favorite.setActivityId(activityId);
        favoriteRepository.save(favorite);
        return "Activity with ID "+activityId+ " added to favorites.";
    }
    @PostMapping("/history")
    public String addToHistory(@RequestParam Long activityId){
        Activity activity=activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found with ID: "+ activityId));
        String timestamp = java.time.LocalDateTime.now().toString();
        History history= new History(activityId, timestamp);

        historyRepository.save(history);
        return "Activity with ID " + activityId + " added to history.";
    }
    @GetMapping("/favorites")
    public Object getFavorites(){
        List<Favorite> favorites = favoriteRepository.findAll();
        if(favorites.isEmpty()) {
            throw new IllegalArgumentException("There are no favorites");
        }
        return favorites;
    }
    @GetMapping("/history")
    public Object getHistory(){
        List<History> historyList = historyRepository.findAll();
        if(historyList.isEmpty()) {
            throw new IllegalArgumentException("There are no history");
        }
        return historyList;
    }

    @GetMapping("/activities/{id}")
    public Activity getActivityById(@PathVariable Long id){
        return activityRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Activity with ID" + id + "not found."));
    }

}
