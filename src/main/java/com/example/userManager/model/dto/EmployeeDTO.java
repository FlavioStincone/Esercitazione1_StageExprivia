package com.example.userManager.model.dto;

public record EmployeeDTO( Long id, String name, String email, String role) {
    
    public EmployeeDTO(String name, String email, String role) {
        this( null, name, email, role);
    }
}
