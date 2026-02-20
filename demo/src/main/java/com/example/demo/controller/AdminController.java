package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin){
        Admin saved=adminService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins(){
        List<Admin> admins=adminService.getAllUser();
        return ResponseEntity.ok(admins);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id){
        Admin admin=adminService.getUserById(id);
        return ResponseEntity.ok(admin);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,
                             @RequestBody Admin admin){
        Admin updated=adminService.updateUser(id,admin);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        adminService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
