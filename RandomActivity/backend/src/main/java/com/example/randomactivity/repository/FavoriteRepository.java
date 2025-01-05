package com.example.randomactivity.repository;

import com.example.randomactivity.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    boolean existsByActivityId(Long activityId);
}
