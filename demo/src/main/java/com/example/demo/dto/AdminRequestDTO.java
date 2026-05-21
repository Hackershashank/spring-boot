package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AdminRequestDTO {

    @NotBlank(message = "Name is Required")
    @Size(min=2, max=30)
    private String name;

    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid email format")
    private String email;

    //Getters
    public String getName(){ return name;}
    public String getEmail(){ return email;}

    //Setters
    public void setName(String name){ this.name=name;}
    public void setEmail(String email){ this.email=email;}

}
