package com.example.demo.controller;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper){

        this.userService=userService;
        this.userMapper=userMapper;
    }

    // CREATE

    // RequestBody converts JSON (user input) to java Objects
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto){
        User user=userMapper.toEntity(dto);
        User saved=userService.createUser(user);
        UserResponseDTO response=userMapper.toResponseDTO(saved);
        return ResponseEntity.ok(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<User> users=userService.getAllUsers();
        List<UserResponseDTO> response=userMapper.toResponseDTOList(users);
        return ResponseEntity.ok(response);
    }

    // READ BY ID
    // PathVariable is used when some variable is needed to be passed from url to methods
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        User user=userService.getUserById(id);
        UserResponseDTO response=userMapper.toResponseDTO(user);
        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO dto){
        User updateUser=userMapper.toEntity(dto);
        User updated=userService.updateUser(id,updateUser);
        UserResponseDTO response=userMapper.toResponseDTO(updated);
        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
