package com.sbwithreact.employeemgnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDto {
    //empdto to transfer data btn client and server
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
