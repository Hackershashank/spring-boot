package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

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

    //Setters
    public void setId(Long id) {this.id=id;}
    public void setName(String name) {this.name=name;}
    public void setEmail(String email) {this.email=email;}
}
