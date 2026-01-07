package com.spring.employeeManagement.repository;

import com.spring.employeeManagement.entity.Employee;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet,int rowNum) throws SQLException{

        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        employee.setDepartment(resultSet.getString("department"));
        employee.setEmail(resultSet.getString("email"));
        employee.setSalary(resultSet.getBigDecimal("salary"));
        return employee;
    }
}
