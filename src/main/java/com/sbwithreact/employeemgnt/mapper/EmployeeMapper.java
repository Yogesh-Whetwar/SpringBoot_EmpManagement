package com.sbwithreact.employeemgnt.mapper;

import com.sbwithreact.employeemgnt.dto.EmployeeDto;
import com.sbwithreact.employeemgnt.model.Employee;

public class EmployeeMapper {
//Emloyyee entity ko emp Dto se map krne ke liye ye mapper
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
