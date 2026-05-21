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

    @Column(nullable = false, length=50)
    private String name;

    @Column(nullable = false, unique = true, length=100)
    private String email;

    @Column(updatable=false)
    private LocalDateTime createdAt=LocalDateTime.now();

    // Default constructor for JPA
    // Used by JPA so that Jackson (Java object conversion)
    // Serialization (Java object-> JSON)
    // Deserialization (JSON-> Java Object)
    // Overall it converts JSON (user input) to below code
    // Admin admin=new Admin();
    // admin.setName("Shashank");
    // admin.setEmail("shashank14370@gmail.com")
    // Similarly, Spring uses Jackson serializes while returning response in JSON

    protected Admin(){}

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
    public void setName(String name) {this.name=name;}
    public void setEmail(String email) {this.email=email;}
}
