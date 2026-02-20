package com.example.demo.model;

import jakarta.persistence.*;

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
    @Column(nullable = false)
    private String name;

    // unique=true means no two rows can have same data for this column
    @Column(nullable = false, unique = true)
    private String email;

    // Default constructor for JPA
    public Admin(){};

    // Parameterized constructor
    public Admin(String name, String email){
        this.name=name;
        this.email=email;
    }

    //Getters
    public Long getId(){return id;}
    public String getName(){return name;}
    public String getEmail(){return email;}

    //Setters
    public void setId(Long id) {this.id=id;}
    public void setName(String name) {this.name=name;}
    public void setEmail(String email) {this.email=email;}
}
