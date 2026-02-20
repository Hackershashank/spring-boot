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

    @NotBlank(message = "Name is required")
    @Size(min=2, max=50, message = "Name must me between 2 and 50 characters")
    @Column(nullable = false, length = 50)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true, length=100)
    private String email;

    @Column(updatable = false)
    private LocalDateTime createdAt=LocalDateTime.now();

    // Default constructor (required by JPA)
    public User(){}

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
    public void setId(Long id) {this.id=id;}
    public void setName(String name) {this.name=name;}
    public void setEmail(String email) {this.email=email;}
}
