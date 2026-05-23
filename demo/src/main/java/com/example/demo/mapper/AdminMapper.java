package com.example.demo.mapper;

import com.example.demo.dto.AdminRequestDTO;
import com.example.demo.dto.AdminResponseDTO;
import com.example.demo.model.Admin;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

// Create this mapper as Spring Bean automatically. So Spring can inject it.
@Mapper(componentModel = "spring")
public interface AdminMapper {

    // RequestDTO -> Entity
    Admin toEntity(AdminRequestDTO dto);

    // Entity -> DTO
    AdminResponseDTO toResponseDTO(Admin admin);

    // List<Entity> -> List<ResponseDTO>
    List<AdminResponseDTO> toResponseDTOList(List<Admin> admins);
}


//Equivalent generated implementation:
//@Component
//public class AdminMapperImpl implements AdminMapper {
//
//    @Override
//    public Admin toEntity(AdminRequestDTO dto) {
//        return new Admin(
//            dto.getName(),
//            dto.getEmail()
//        );
//    }
//
//    @Override
//    public AdminResponseDTO toResponseDTO(Admin admin) {
//        return new AdminResponseDTO(
//            admin.getId(),
//            admin.getName(),
//            admin.getEmail(),
//            admin.getCreatedAt()
//        );
//    }
//
//    @Override
//    public List<AdminResponseDTO> toResponseDTOList(List<Admin> admins){
//        if(admins==null) return null;
//        List<AdminResponseDTO> list=new ArrayList<>(admins.size());
//        for(Admin admin:admins){
//            list.add(toResponseDTO(admin));
//        }
//        return list;
//    }
//}