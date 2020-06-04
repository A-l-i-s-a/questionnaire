package com.example.questionnaire.repository;

import com.example.questionnaire.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
