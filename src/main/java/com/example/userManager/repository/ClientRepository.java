package com.example.userManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userManager.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
