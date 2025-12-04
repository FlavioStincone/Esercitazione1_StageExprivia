package com.example.userManager.service;

import java.util.List;

import com.example.userManager.model.dto.UserDTO;

public interface IUser {

    List<UserDTO> getUsers();

    UserDTO getUser(int id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(int id, UserDTO user);

    boolean deleteUser(int id);
    
}
