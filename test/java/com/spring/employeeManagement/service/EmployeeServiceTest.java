package com.spring.employeeManagement.service;

import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeService employeeService;

    @BeforeAll
    public static void init(){
        System.out.println("Test before all test are executed");
    }

    @BeforeEach
    public void initEachTest(){
        System.out.println("Run before each test");
    }

    @AfterEach
    public void afterEachTest(){
        System.out.println("Run after all test for clean up");
    }

    @AfterAll
    public static void afterAllTest(){
        System.out.println("Close after all test");
    }
    @Test
    void saveEmployeeShouldSaveSuccessFully(){

        //data preparation
        Employee employee = new Employee();
        employee.setId(105L);
        employee.setName("Sathvik");
        employee.setSalary(45000.0);
        employee.setDepartment("software");
        employee.setEmail("sathvik@gmail.com");

        //mocking your call method
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        //calling actual methods
        Employee savedEmployee = employeeService.saveEmployee(employee);
        System.out.println("save method testing is done");
        //test employee = matchedEmployee

        //assertion
        assertNotNull(savedEmployee);
        assertEquals(employee.getId(),savedEmployee.getId());
        assertEquals(employee.getName(),savedEmployee.getName());
        assertTrue(employee.getId()==105);

    }

    @Test
    void getEmployeeEmailIdShouldSuccessfullyGet(){

        Employee employee = new Employee();
        employee.setEmail("arpitha1122@gmail.com");
        List<Employee> employeeList= List.of(employee);

        Mockito.when(employeeRepository.findByEmail("arpitha1122@gmail.com"))
                .thenReturn(employeeList);

        Employee getsEmployeeByEmail = employeeService.getEmployeeByEmail("arpitha1122@gmail.com");
        System.out.println("getEmployeeById method is tested successfully");

        //assertion
        assertEquals(employee.getEmail(),getsEmployeeByEmail.getEmail());
    }
}
