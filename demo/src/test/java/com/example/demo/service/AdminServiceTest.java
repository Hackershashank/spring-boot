package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
class AdminServiceTest {

    @Test
    void testGetUserById() {

        AdminRepository mockRepo = Mockito.mock(AdminRepository.class);

        Admin admin = new Admin("Ram", "ram@mail.com");
        admin.setId(1L);

        Mockito.when(mockRepo.findById(1L))
                .thenReturn(Optional.of(admin));

        AdminService service = new AdminService(mockRepo);

        Admin result = service.getUserById(1L);

        assertEquals("Ram", result.getName());
    }
}