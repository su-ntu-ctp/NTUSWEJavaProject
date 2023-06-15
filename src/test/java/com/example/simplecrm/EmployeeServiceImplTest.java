package com.example.simplecrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.simplecrm.model.Employee;
import com.example.simplecrm.repository.EmployeeRepository;
import com.example.simplecrm.service.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeServiceImplTest {

  @Mock // Create a mock of the CustomerRepository
  private EmployeeRepository employeeRepository;

  @InjectMocks // Inject the mocks as dependencies
  EmployeeServiceImpl employeeService;

  @Test
  public void createEmployeeTest() {
    // Mock the data
    Employee newEmployee = new Employee(1, "John", "Doe", "john@a.com", "HR", "123456");

    // Mock the repo method
    when(employeeRepository.save(newEmployee)).thenReturn(newEmployee);

    // Act
    Employee savedEmployee = employeeService.createEmployee(newEmployee);

    // Assert
    verify(employeeRepository, times(1)).save(newEmployee);
    assertEquals(newEmployee, savedEmployee);

  }

  @Test
  public void getAllEmployeesTest() {
    // Arrange - Mock the data

    when(employeeRepository.findAll()).thenReturn(Arrays.asList(
      new Employee(1, "Tony", "Stark", "tony@a.com", "HR", "123456"),
      new Employee(2, "Bruce", "Banner", "bruce@avengers.com", "Finance", "123456")
    ));

    // Act
    List<Employee> allEmployees = employeeService.getAllEmployees();
    // Assert
    assertEquals(2, allEmployees.size());


  }

  @Test
  public void getUserTest() {
    // Arrange - Mock the data
    Employee newEmployee = new Employee(1, "Tony", "Stark", "tony@a.com", "HR", "123456");

    when(employeeRepository.findById(1)).thenReturn(Optional.of(newEmployee));

    // Act
    Employee foundEmployee = employeeService.getEmployee(1);

    // Assert
    assertEquals(newEmployee, foundEmployee);
  }

}
