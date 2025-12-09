package com.example.userManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userManager.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
