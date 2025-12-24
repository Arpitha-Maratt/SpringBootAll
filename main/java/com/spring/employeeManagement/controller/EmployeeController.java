package com.spring.employeeManagement.controller;

import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
@SecurityRequirement(name = "basicAuth")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @Operation(summary = "Get all employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
    List<Employee> employees= employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by id")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/by-email")
    @Operation(summary = "Get employee by email")
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam String email){
        Employee employee= employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    @Operation(summary = "Create new employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employee1=employeeService.saveEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update employee")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        Employee updatedemployee= employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedemployee);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete an employee")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
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
