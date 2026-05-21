
package com.example.demo.service;
import java.util.*;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    // Dependency Injection
    private final AdminRepository adminRepository;

    // Constructor Injection
    public AdminService(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    // getUserById returns 'Optional' data structure to avoid NullPointerException in case null is there
    public Admin getAdminById(Long id){
        return adminRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Admin not found with id: "+id));
    }

    public Admin updateAdmin(Long id,Admin updatedAdmin){
        Admin existingAdmin=getAdminById(id);
        existingAdmin.setName(updatedAdmin.getName());
        existingAdmin.setEmail(updatedAdmin.getEmail());
        return adminRepository.save(existingAdmin);
    }

    public void deleteAdmin(Long id){
        Admin admin=getAdminById(id);
        adminRepository.delete(admin);
    }
}