package com.example.userManager.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.userManager.model.dto.EmployeeDTO;
import com.example.userManager.model.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employees);
    
    Employee toEntity(EmployeeDTO employeeDTO);
    
    List<EmployeeDTO> toListDTO(List<Employee> employees);
    
    List<Employee> toListEntity(List<EmployeeDTO> employeesDTO);
}
