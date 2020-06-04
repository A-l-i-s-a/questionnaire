package com.example.questionnaire.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "APP_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String phoneNumber;
}

