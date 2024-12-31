package com.example.randomactivity.repository;


import com.example.randomactivity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query(value = "SELECT * FROM activity ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Activity findRandomActivity();
}