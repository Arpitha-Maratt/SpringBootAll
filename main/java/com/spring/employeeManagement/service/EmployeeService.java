package com.spring.employeeManagement.service;

import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.exception.ResourceNotFoundException;
import com.spring.employeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee is not available with this id"));
    }

    public Employee getEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email).orElseThrow(()-> new RuntimeException(("Employee is not available in this email id")));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:"+id));

        employeeRepository.delete(employee);
    }
}
