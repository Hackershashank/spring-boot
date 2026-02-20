
package com.example.demo.service;
import java.util.*;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> getAllUser(){
        return adminRepository.findAll();
    }

    public Admin getUserById(Long id){
        return adminRepository.findById(id).
                orElseThrow(()->new RuntimeException("Admin not found"));
    }

    public Admin updateUser(Long id,Admin updatedUser){
        Admin user=getUserById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        return adminRepository.save(user);
    }

    public void deleteUser(Long id){
        adminRepository.deleteById(id);
    }
}