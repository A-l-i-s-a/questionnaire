package com.example.questionnaire.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    @ManyToOne
    private Poll poll;
    @OneToMany
    private List<Comment> comments;
}
