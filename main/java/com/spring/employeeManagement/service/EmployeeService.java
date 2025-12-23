package com.spring.employeeManagement.service;

import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.exception.ResourceNotFoundException;
import com.spring.employeeManagement.repository.EmployeeRepository;
import com.spring.employeeManagement.repository.EmployeeRepositoryImpl;
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
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        return employee;
    }

    public Employee getEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException(("Employee is not available in this email id")));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }


    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }

        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setEmail(employee.getEmail());
        existing.setSalary(employee.getSalary());

        return employeeRepository.save(existing);
    }
}
