package com.example.userManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userManager.model.entity.Employee;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByPwd(String pwd);
    
}
