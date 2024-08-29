package com.sbwithreact.employeemgnt.service;

import com.sbwithreact.employeemgnt.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getSingleEmployee(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long empId,EmployeeDto updateEmployee);
    void deleteEmployee(Long empId);
}
