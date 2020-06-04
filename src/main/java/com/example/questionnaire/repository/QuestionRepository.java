package com.example.questionnaire.repository;

import com.example.questionnaire.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
