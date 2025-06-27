package com.loginApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class user {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
}
