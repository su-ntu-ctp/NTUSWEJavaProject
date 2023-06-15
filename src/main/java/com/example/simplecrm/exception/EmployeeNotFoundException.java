package com.example.simplecrm.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int id) {
      super("Employee with id " + id + " not found.");
    }
  
  }
