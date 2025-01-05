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

            Activity activity6 = new Activity();
            activity6.setName("Running");
            activity6.setCategory("Outdoor");
            activity6.setDetails("Enjoy the thrill of running in a park, along the beach, or through urban streets. Set goals like distance or time to challenge yourself.");
            activityRepository.save(activity6);

            Activity activity7 = new Activity();
            activity7.setName("Gardening");
            activity7.setCategory("Outdoor");
            activity7.setDetails("Plant flowers, vegetables, or herbs. Learn about soil, watering, and seasonal planting. Create a peaceful space to enjoy nature.");
            activityRepository.save(activity7);

            Activity activity8 = new Activity();
            activity8.setName("Reading");
            activity8.setCategory("Educational");
            activity8.setDetails("Immerse yourself in novels, self-help books, or biographies. Explore new genres and join book clubs to share your thoughts.");
            activityRepository.save(activity8);

            Activity activity9 = new Activity();
            activity9.setName("Cycling");
            activity9.setCategory("Outdoor");
            activity9.setDetails("Ride through city streets or off-road trails. Cycling is great for cardio and discovering new places at your own pace.");
            activityRepository.save(activity9);

            Activity activity10 = new Activity();
            activity10.setName("Swimming");
            activity10.setCategory("Outdoor");
            activity10.setDetails("Dive into a pool, lake, or sea for exercise or relaxation. Learn strokes like freestyle or butterfly and enjoy the therapeutic effect of water.");
            activityRepository.save(activity10);

            Activity activity11 = new Activity();
            activity11.setName("Writing");
            activity11.setCategory("Creative");
            activity11.setDetails("Write poems, short stories, or even a journal. Develop your voice, expand vocabulary, and use writing as a form of expression.");
            activityRepository.save(activity11);

            Activity activity12 = new Activity();
            activity12.setName("Knitting");
            activity12.setCategory("Craft");
            activity12.setDetails("Create scarves, sweaters, or blankets using different knitting patterns. A therapeutic activity that results in personalized gifts.");
            activityRepository.save(activity12);

            Activity activity13 = new Activity();
            activity13.setName("Meditation");
            activity13.setCategory("Wellness");
            activity13.setDetails("Practice guided or unguided meditation to focus your mind. Use apps or calming music to aid relaxation and improve mental clarity.");
            activityRepository.save(activity13);

            Activity activity14 = new Activity();
            activity14.setName("Learning a new language");
            activity14.setCategory("Educational");
            activity14.setDetails("Use apps, books, or classes to master new words, phrases, and grammar. Practice with native speakers to improve fluency.");
            activityRepository.save(activity14);

            Activity activity15 = new Activity();
            activity15.setName("Dancing");
            activity15.setCategory("Physical");
            activity15.setDetails("Try ballroom, hip-hop, salsa, or contemporary dance. Dancing is an excellent way to stay fit while having fun with music.");
            activityRepository.save(activity15);

            Activity activity16 = new Activity();
            activity16.setName("Volunteering");
            activity16.setCategory("Social");
            activity16.setDetails("Support local shelters, food banks, or environmental projects. Connect with others while making a positive impact on your community.");
            activityRepository.save(activity16);

            Activity activity17 = new Activity();
            activity17.setName("Bird watching");
            activity17.setCategory("Outdoor");
            activity17.setDetails("Use binoculars and field guides to spot and identify bird species. Visit local parks or reserves for the best opportunities.");
            activityRepository.save(activity17);

            Activity activity18 = new Activity();
            activity18.setName("Board games");
            activity18.setCategory("Social");
            activity18.setDetails("Challenge your friends or family with strategy games like chess or lighthearted games like Monopoly. Develop problem-solving skills while having fun.");
            activityRepository.save(activity18);

            Activity activity19 = new Activity();
            activity19.setName("Playing an instrument");
            activity19.setCategory("Creative");
            activity19.setDetails("Learn guitar, piano, or drums. Dedicate time to practice, read music sheets, and enjoy creating melodies.");
            activityRepository.save(activity19);

            Activity activity20 = new Activity();
            activity20.setName("DIY crafts");
            activity20.setCategory("Craft");
            activity20.setDetails("Use recyclable materials, paper, or fabric to create decorative items, gifts, or home accessories. Perfect for expressing creativity and saving money.");
            activityRepository.save(activity20);


            System.out.println("Default activities added to the DB");
        }
    }
}

