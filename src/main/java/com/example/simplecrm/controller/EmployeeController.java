package com.example.simplecrm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplecrm.model.Employee;
import com.example.simplecrm.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  // CRUD
  // 1. CREATE
  @PostMapping("")
  public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {

    Employee newEmployee = employeeService.createEmployee(employee);
    return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);

  }

  // 2. READ (Get and Get All)
  // Get All Users
  @GetMapping("")
  public ResponseEntity<List<Employee>> getAllEmployees() {

    List<Employee> allEmployees = employeeService.getAllEmployees();
    return new ResponseEntity<>(allEmployees, HttpStatus.OK);
  }

  // Get User
  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
    Employee foundEmployee = employeeService.getEmployee(id);
    return new ResponseEntity<>(foundEmployee, HttpStatus.OK);
  }

  // 3. UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateUser(@PathVariable int id, @RequestBody Employee employee) {
    Employee updatedEmployee = employeeService.updateEmployee(id, employee);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);

  }

  // 4. DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}