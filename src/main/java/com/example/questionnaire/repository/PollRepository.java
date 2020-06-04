package com.example.questionnaire.repository;

import com.example.questionnaire.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
}
