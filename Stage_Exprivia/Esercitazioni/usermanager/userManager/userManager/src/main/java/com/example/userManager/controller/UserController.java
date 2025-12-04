package com.example.userManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userManager.model.dto.UserDTO;
import com.example.userManager.service.impl.UserServiceImpl;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl service;

    //GET /users
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        
        List<UserDTO> users = service.getUsers();
        
        if (users != null && !users.isEmpty()) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    //GET /user/{id}
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        
        UserDTO user = service.getUser(id);
        
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //POST /user
    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        if (userDTO == null || userDTO.getName() == null || userDTO.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }

        UserDTO created = service.createUser(userDTO);
        
        if ( created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //PUT /user/{id}
    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        if (userDTO == null || userDTO.getName() == null || userDTO.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }

        UserDTO updateDTO = service.updateUser(id, userDTO);
        
        if (updateDTO != null) {
            return ResponseEntity.ok().body(updateDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE /user/{id}
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id) {
        
        boolean deleted = service.deleteUser(id);
        
        if (deleted) {
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
