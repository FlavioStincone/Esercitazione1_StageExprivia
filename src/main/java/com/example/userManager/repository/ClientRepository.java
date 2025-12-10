package com.example.userManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userManager.model.entity.Client;
import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByName(String name);

    List<Client> findByPwd(String pwd);
    
}
