package com.example.randomactivity;

import com.example.randomactivity.model.Activity;
import com.example.randomactivity.repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private final ActivityRepository activityRepository;

    public DatabaseInitializer(ActivityRepository activityRepository) {
        this.activityRepository=activityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (activityRepository.count() == 0){
            Activity activity1 = new Activity();
            activity1.setName("Hiking");
            activity1.setCategory("Outdoor");
            activity1.setDetails("Explore scenic trails, breathe fresh air, and enjoy the beauty of mountains, forests, or coastal paths. Perfect for improving physical fitness and mental well-being.");
            activityRepository.save(activity1);

            Activity activity2 = new Activity();
            activity2.setName("Photography");
            activity2.setCategory("Creative");
            activity2.setDetails("Use your camera or smartphone to capture landscapes, portraits, or urban scenes. Experiment with lighting, angles, and editing to enhance your skills.");
            activityRepository.save(activity2);

            Activity activity3 = new Activity();
            activity3.setName("Cooking");
            activity3.setCategory("Indoor");
            activity3.setDetails("Prepare delicious meals or desserts, explore international cuisines, and learn techniques like baking, grilling, or fermenting. Great for sharing with family and friends.");
            activityRepository.save(activity3);

            Activity activity4 = new Activity();
            activity4.setName("Painting");
            activity4.setCategory("Creative");
            activity4.setDetails("Express yourself through watercolors, acrylics, or oil paints. Paint landscapes, portraits, or abstract art to relax and boost creativity.");
            activityRepository.save(activity4);

            Activity activity5 = new Activity();
            activity5.setName("Yoga");
            activity5.setCategory("Wellness");
            activity5.setDetails("Practice poses and breathing exercises to improve flexibility, strength, and mindfulness. Perfect for reducing stress and enhancing inner peace.");
            activityRepository.save(activity5);

            System.out.println("Default activities added to the DB");
        }
    }
}

