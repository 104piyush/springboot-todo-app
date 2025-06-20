package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users") 
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

    private String email;
    private String password;
}
