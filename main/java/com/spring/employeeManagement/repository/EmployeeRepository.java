package com.spring.employeeManagement.repository;

import com.spring.employeeManagement.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    List<Employee> findAll();
    Employee findById(Long id);
    List<Employee> findByEmail(String email);
    Employee save(Employee employee);
    void deleteById(Long id);
}
