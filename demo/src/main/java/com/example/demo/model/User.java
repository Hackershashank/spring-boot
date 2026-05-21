package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length=100)
    private String email;

    @Column(updatable = false)
    private LocalDateTime createdAt=LocalDateTime.now();

    // Default constructor (required by JPA)
    protected User(){}

    // Parameterized constructor
    public User(String name, String email){
        this.name=name;
        this.email=email;
    }
    //Getters
    public Long getId(){return id;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public LocalDateTime getCreatedAt(){ return createdAt; }

    //Setters
    public void setName(String name) {this.name=name;}
    public void setEmail(String email) {this.email=email;}
}
