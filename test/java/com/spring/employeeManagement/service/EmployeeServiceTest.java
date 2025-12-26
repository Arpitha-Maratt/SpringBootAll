package com.spring.employeeManagement.service;

import com.spring.employeeManagement.entity.Employee;
import com.spring.employeeManagement.exception.InvalidInputException;
import com.spring.employeeManagement.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


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
        employee.setSalary(BigDecimal.valueOf(45000));
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

    @Test
    public void deleteByIdSuccessfull(){

        Employee employee = new Employee();
        employee.setId(1L);
        Mockito.when(employeeRepository.findById(1L)).thenReturn(employee);

        doNothing().when(employeeRepository).deleteById(1L);
        employeeService.deleteEmployee(1L);
        Mockito.verify(employeeRepository,Mockito.times(1)).deleteById(1L);

        System.out.println("Used doNothing when there is void and wwe cannot return");
    }

    @Test
    public void testPrivate_validateEmployeeName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validate = EmployeeService.class.getDeclaredMethod("validateEmployeeName",String.class);

        validate.setAccessible(true);
        Boolean name = (Boolean) validate.invoke(employeeService,"Sathvik");
        assertTrue(name);
        System.out.println("Private method testing");
    }

    @Test
    public void testPrivate_validateEmployeeNameInvalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validate = EmployeeService.class.getDeclaredMethod("validateEmployeeName",String.class);

        validate.setAccessible(true);
        Boolean name = (Boolean) validate.invoke(employeeService,"");
        assertFalse(name);
        System.out.println("Validate inavlid test for private");
    }


    @Test
    void saveEmployeeShouldThrowsExceptionForInvalidateEmployeeName() {

        Employee employee = new Employee();
        employee.setId(105L);
        employee.setName(""); // invalid
        employee.setSalary(BigDecimal.valueOf(45000.0));
        employee.setDepartment("software");
        employee.setEmail("sathvik@gmail.com");

        RuntimeException exception = assertThrows(InvalidInputException.class, () ->
                employeeService.saveEmployee(employee)
        );

        assertEquals("Employee name is invalid", exception.getMessage());
        verify(employeeRepository,times(0)).save(any(Employee.class));
    }

}

