package com.spring.employeeManagement.repository;

import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll(){
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }

    @Override
    public Employee findById(Long id){
        String sql = "SELECT * FROM employees WHERE id = ?";
        try {
            Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
            return employee;
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
    }

    @Override
    public List<Employee> findByEmail(String email) {
        String sql = "SELECT * FROM employees WHERE email = ?";
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), email);
    }

    @Override
    public Employee save(Employee employee){
        String sql = "INSERT INTO employees(id, name, department, email, salary) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,
                employee.getId(),
                employee.getName(),
                employee.getDepartment(),
                employee.getEmail(),
                employee.getSalary()
        );

        return employee;
    }

    @Override
    public void deleteById(Long id){
        String sql = "Delete FROM employees WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
