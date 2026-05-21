package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.AdminRequestDTO;
import com.example.demo.dto.AdminResponseDTO;
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
    public ResponseEntity<AdminResponseDTO> createAdmin(@Valid @RequestBody AdminRequestDTO dto){
        // DTO -> Entity conversion
        Admin admin=new Admin(dto.getName(),dto.getEmail());
        Admin saved=adminService.createAdmin(admin);

        // Entity -> DTO conversion
        AdminResponseDTO response=new AdminResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getCreatedAt()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<AdminResponseDTO>> getAllAdmins(){
        List<AdminResponseDTO> admins=adminService.getAllAdmins()
                .stream()
                .map(admin->new AdminResponseDTO(
                        admin.getId(),
                        admin.getName(),
                        admin.getEmail(),
                        admin.getCreatedAt()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(admins);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> getAdminById(@PathVariable Long id){
        Admin admin=adminService.getAdminById(id);
        AdminResponseDTO response=new AdminResponseDTO(
                admin.getId(),
                admin.getName(),
                admin.getEmail(),
                admin.getCreatedAt()
        );
        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> updateAdmin(@PathVariable Long id,
                             @Valid @RequestBody AdminRequestDTO dto){
        Admin updatedAdmin=new Admin(dto.getName(),dto.getEmail());
        Admin updated=adminService.updateAdmin(id,updatedAdmin);
        AdminResponseDTO response=new AdminResponseDTO(
                updated.getId(),
                updated.getName(),
                updated.getEmail(),
                updated.getCreatedAt()
        );
        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
