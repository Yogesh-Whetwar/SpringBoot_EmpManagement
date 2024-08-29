package com.sbwithreact.employeemgnt.service.impl;


import com.sbwithreact.employeemgnt.dto.EmployeeDto;
import com.sbwithreact.employeemgnt.exception.ResourceNotFoundException;
import com.sbwithreact.employeemgnt.mapper.EmployeeMapper;
import com.sbwithreact.employeemgnt.model.Employee;
import com.sbwithreact.employeemgnt.repository.EmployeeRepository;
import com.sbwithreact.employeemgnt.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service//this annotation will tell spring to create spring bean
//for this
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //db me data transfer object ko entity me convert krke save krenge after that
        //we will get the entity which will we convert again into dtos to send to controller
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getSingleEmployee(Long id){
        Employee myEmp=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not found with given id : " + id));
        return EmployeeMapper.mapToEmployeeDto(myEmp);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee>empList=employeeRepository.findAll();
        return empList.stream().map((emp)->EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public EmployeeDto updateEmployee(Long empId, EmployeeDto updateEmployee) {
        Optional<Employee> myEmp=employeeRepository.findById(empId);
        if(myEmp.isPresent()){
            Employee emp=myEmp.get();
            emp.setFirstName(updateEmployee.getFirstName());
            emp.setLastName(updateEmployee.getLastName());
            emp.setEmail(updateEmployee.getEmail());
            employeeRepository.save(emp);
            return EmployeeMapper.mapToEmployeeDto(emp);
        }else{
            throw new ResourceNotFoundException("Employee not found with id : "+ empId);
        }

    }

    @Override
    public void deleteEmployee(Long empId) {
        Optional<Employee>emp=employeeRepository.findById(empId);
        if(emp.isPresent()){
            Employee myEmp=emp.get();
            employeeRepository.delete(myEmp);
//            return EmployeeMapper.mapToEmployeeDto(myEmp);
        }else{
            throw new ResourceNotFoundException("Can not delete emp with this id as no emp is here with this id");
        }
    }

}
