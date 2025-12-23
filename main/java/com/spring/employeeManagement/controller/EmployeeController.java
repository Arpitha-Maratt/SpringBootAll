package com.spring.employeeManagement.controller;

import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@SecurityRequirement(name = "basicAuth")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @Operation(summary = "Get all employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get employee by id")
    public Employee getEmployeeById(@PathVariable  Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get employee by email")
    public Employee getEmployeeByEmail(@PathVariable String email){
        return employeeService.getEmployeeByEmail(email);
    }

    @PostMapping
    @Operation(summary = "Create new employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update employee")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        Employee existing = employeeService.getEmployeeById(id);

        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setEmail(employee.getEmail());
        existing.setSalary(employee.getSalary());

        return employeeService.saveEmployee(existing);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete an employee")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

  /* @GetMapping(value ="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public Employee getEmployeeForNegotiation(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @Operation(summary ="Get Employee bu ID")
    @GetMapping("/{id}")
    public Employee getEmployeeForSwagger(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }*/
}
