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

import com.example.userManager.model.dto.EmployeeDTO;
import com.example.userManager.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl service;

    //GET /employees
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getUsers(){
        
        List<EmployeeDTO> employees = service.getEmployees();
        
        if (employees != null && !employees.isEmpty()) {
            return ResponseEntity.ok().body(employees);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    //GET /employee/{id}
    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getClient(@PathVariable Long id) {
        
        EmployeeDTO employee = service.getEmployee(id);
        
        if (employee != null) {
            return ResponseEntity.ok().body(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //POST /employee
    @PostMapping("/employee")
    public ResponseEntity<EmployeeDTO> createUser(@RequestBody EmployeeDTO employeeDTO) {
        if (employeeDTO == null || employeeDTO.name() == null || employeeDTO.email() == null) {
            return ResponseEntity.badRequest().build();
        }

        EmployeeDTO created = service.createEmployee(employeeDTO);
        
        if ( created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //PUT /employee/{id}
    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> updateUser(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        if (employeeDTO == null || employeeDTO.name() == null || employeeDTO.email() == null) {
            return ResponseEntity.badRequest().build();
        }

        EmployeeDTO updateDTO = service.updateEmployee(id, employeeDTO);
        
        if (updateDTO != null) {
            return ResponseEntity.ok().body(updateDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE /employee/{id}
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        
        boolean deleted = service.deleteEmployee(id);
        
        if (deleted) {
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}

