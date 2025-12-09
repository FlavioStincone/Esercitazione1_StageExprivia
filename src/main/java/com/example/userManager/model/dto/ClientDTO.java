package com.example.userManager.model.dto;

public record ClientDTO( Long id, String name, String email, String role) {
    
    public ClientDTO(String name, String email, String role) {
        this( null, name, email, role);
    }
}

