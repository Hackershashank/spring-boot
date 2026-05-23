package com.example.demo.mapper;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // RequestDTO -> Entity
    User toEntity(UserRequestDTO dto);

    // Entity -> ResponseDTO
    UserResponseDTO toResponseDTO(User user);

    // List<Entity> -> List<UserResponseDTO>
    List<UserResponseDTO> toResponseDTOList(List<User> users);
}
