package com.example.simplecrm.Test;

import java.util.ArrayList;

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

@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private TestService testService;

  // 1. CREATE
  @PostMapping("")
  public ResponseEntity<Test> createTest(@RequestBody Test test) {
    // @RequestBody de-serializes the JSON and convert into Java object

    // Add the new customer to the ArrayList
    // customers.add(customer);
    Test newTest = testService.createTest(test);
    return new ResponseEntity<>(newTest, HttpStatus.CREATED);

  }

  // 2. READ (Get and Get All)
  // Get All Customers
  @GetMapping("")
  public ResponseEntity<ArrayList<Test>> getAllCustomers() {

    ArrayList<Test> allTest = testService.getAllTest();
    return new ResponseEntity<>(allTest, HttpStatus.OK);
  }

  // Get Customer
  @GetMapping("/{id}")
  public ResponseEntity<Test> getCustomer(@PathVariable int id) {

    Test foundTest = testService.getTest(id);
    return new ResponseEntity<>(foundTest, HttpStatus.OK);

  }

  // 3. UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<Test> updateTest(@PathVariable int id, @RequestBody Test test) {

    Test updatedTest = testService.updateTest(id, test);
    return new ResponseEntity<>(updatedTest, HttpStatus.OK);

  }

  // 4. DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteTest(@PathVariable int id) {

    testService.deleteTest(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }
}
