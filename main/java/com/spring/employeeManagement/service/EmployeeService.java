package com.spring.employeeManagement.service;

import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.exception.GlobleExceptionHandler;
import com.spring.employeeManagement.exception.InvalidInputException;
import com.spring.employeeManagement.exception.ResourceNotFoundException;
import com.spring.employeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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




    public Employee getEmployeeByEmail(String email) {
        List<Employee> employees = employeeRepository.findByEmail(email);
        return employees.stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with email: " + email
                ));
    }

    public Employee saveEmployee(Employee employee) {
        boolean validation = validateEmployeeName(employee.getName());

        if (!validateEmployeeName(employee.getName())){
            throw new InvalidInputException("Employee name is invalid", employee.getId());

        }
        return employeeRepository.save(employee);
    }

        private boolean validateEmployeeName(String name){
            return name !=null && !name.isEmpty();
        }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            throw new ResourceNotFoundException(
                    "Employee not found with id",
                    id);
        }
        employeeRepository.deleteById(id);
    }


    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id);
        if (existing == null) {
            throw new ResourceNotFoundException(
                    "Employee not found with id",
                    id);
        }

        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setEmail(employee.getEmail());
        existing.setSalary(employee.getSalary());

        return employeeRepository.save(existing);
    }
}
