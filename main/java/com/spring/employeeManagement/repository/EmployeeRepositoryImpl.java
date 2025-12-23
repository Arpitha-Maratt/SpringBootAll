package com.spring.employeeManagement.repository;

import com.spring.employeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll(){
        String sql = "SELECT * FROM employee_details";
        return jdbcTemplate.query(sql , new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee findById(Long id){
        String sql = "SELECT * FROM employee_details WHERE id = ?";
                return jdbcTemplate.queryForObject(sql,
                        new BeanPropertyRowMapper<>(Employee.class),
                        id
                );
    }

    @Override
    public Optional<Employee> findByEmail(String email){
        String sql = "SELECT * FROM employee WHERE email = ?";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Employee.class),
                email).stream().findFirst();
    }

    @Override
    public Employee save(Employee employee){
        String sql ="INSERT INTO employee_details(name,department,email,salary)Values(?,?,?,?)";
        jdbcTemplate.update(sql,
                employee.getName(),
                employee.getDepartment(),
                employee.getEmail(),
                employee.getSalary()
        );
        return employee;
    }

    @Override
    public void deleteById(Long id){
        String sql = "Delete FROM employee_details WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
