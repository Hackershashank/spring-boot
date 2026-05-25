package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // One Department -> Many Users
    @OneToMany(mappedBy = "department")
    private List<Admin> admins=new ArrayList<>();

    protected Department(){};

    public Department(String name){
        this.name=name;
    }

    // Getters
    public Long getId(){ return id;}
    public String getName(){ return name;}
    public List<Admin> getAdmins(){ return admins;}

    // Setters
    public void setName(String name){ this.name=name;}

}
