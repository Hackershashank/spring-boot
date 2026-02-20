package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

// Marks this class as JPA entity and tells spring to create a table
@Entity

// Specifies the name of the table
@Table(name = "admins")

public class Admin {

    // Primary key for this table
    @Id
    // Auto generates the primary key value
    // IDENTITY handles the auto generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Maps field to database column
    // nullable=false means can not be empty
    @NotBlank(message="Name is required")
    @Size(min=2, max=50, message="Name must be between 2 and 50 characters")
    @Column(nullable = false, length=50)
    private String name;

    // unique=true means no two rows can have same data for this column
    @NotBlank(message="Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true, length=100)
    private String email;

    @Column(updatable=false)
    private LocalDateTime createdAt=LocalDateTime.now();

    // Default constructor for JPA
    public Admin(){}

    // Parameterized constructor
    public Admin(String name, String email){
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
