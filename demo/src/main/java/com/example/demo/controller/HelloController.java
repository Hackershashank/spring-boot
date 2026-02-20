package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Marks the class as Spring MVC controller and automatically convert values to JSON or text
@RestController

// Base url paths
@RequestMapping("/api")
public class HelloController {

    // Make HTTP GET request
    @GetMapping("/hello")

    public String sayHello(){
        return "Say Hello to Spring Boot!";
    }
}
// http://localhost:8080/api/hello
