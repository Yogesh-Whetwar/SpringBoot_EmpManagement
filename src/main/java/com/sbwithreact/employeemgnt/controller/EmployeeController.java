package com.sbwithreact.employeemgnt.controller;

import com.sbwithreact.employeemgnt.dto.EmployeeDto;
import com.sbwithreact.employeemgnt.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //build Add employee rest api

    @PostMapping("/addemp")
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto){

        EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //if name of id in 1st and 2nd line is not not same then we have to pass the
    //value inside bracket to pathvariable as a parameter exa
    //
    @GetMapping("/getsingleemp/{id}")
    public ResponseEntity<EmployeeDto> getSingleEmployee(@PathVariable Long id){
        EmployeeDto myEmp=employeeService.getSingleEmployee(id);
        return new ResponseEntity<>(myEmp,HttpStatus.OK);
    }

    @GetMapping("/getallemps")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto>myEmps=employeeService.getAllEmployees();
        return ResponseEntity.ok(myEmps);
    }

    @PutMapping("/updateemp/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long emp_id,@RequestBody EmployeeDto employeeDto){
        EmployeeDto empDto= employeeService.updateEmployee(emp_id,employeeDto);
        return ResponseEntity.ok(empDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long emp_id){
        employeeService.deleteEmployee(emp_id);
        return ResponseEntity.ok("Employee deleted Successfully");
    }
}
