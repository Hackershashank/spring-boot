package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
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
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    // READ ALL
    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAllUser();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id){
        return adminService.getUserById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id,
                             @RequestBody Admin admin){
        return adminService.updateUser(id,admin);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id){
        adminService.deleteUser(id);
    }
}
