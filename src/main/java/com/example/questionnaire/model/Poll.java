package com.example.questionnaire.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Problem promblem;
    @OneToMany
    private List<Question> questions;
}
