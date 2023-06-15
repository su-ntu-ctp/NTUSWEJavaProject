package com.example.simplecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.simplecrm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}