package com.example.simplecrm.service;
import java.util.List;

import com.example.simplecrm.model.Employee;

public interface EmployeeService {
  Employee createEmployee(Employee employee);

  Employee getEmployee(int id);

  List<Employee> getAllEmployees();

  Employee updateEmployee(int id, Employee employee);

  void deleteEmployee(int id);

}
