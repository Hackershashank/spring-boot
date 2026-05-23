package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.AdminRequestDTO;
import com.example.demo.dto.AdminResponseDTO;
import com.example.demo.mapper.AdminMapper;
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
    private final AdminMapper adminMapper;
    public AdminController(AdminService adminService, AdminMapper adminMapper){

        this.adminService=adminService;
        this.adminMapper=adminMapper;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<AdminResponseDTO> createAdmin(@Valid @RequestBody AdminRequestDTO dto){
        // RequestDTO -> Entity
        Admin admin=adminMapper.toEntity(dto);

        // save entity
        Admin saved=adminService.createAdmin(admin);

        // Entity -> ResponseDTO
        AdminResponseDTO response=adminMapper.toResponseDTO(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<AdminResponseDTO>> getAllAdmins(){
        List<Admin> admins=adminService.getAllAdmins();
        List<AdminResponseDTO> response=adminMapper.toResponseDTOList(admins);
        return ResponseEntity.ok(response);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> getAdminById(@PathVariable Long id){
        Admin admin=adminService.getAdminById(id);
        AdminResponseDTO response=adminMapper.toResponseDTO(admin);
        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> updateAdmin(@PathVariable Long id,
                             @Valid @RequestBody AdminRequestDTO dto){
        Admin updatedAdmin=adminMapper.toEntity(dto);
        Admin updated=adminService.updateAdmin(id,updatedAdmin);
        AdminResponseDTO response=adminMapper.toResponseDTO(updated);
        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
