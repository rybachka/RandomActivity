package com.example.randomactivity.repository;

import com.example.randomactivity.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
