package com.example.userManager.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.userManager.model.dto.UserDTO;
import com.example.userManager.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper{

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

    List<UserDTO> toListDTO(List<User> users);

    List<User> toListEntity(List<UserDTO> usersDTO);
    
}