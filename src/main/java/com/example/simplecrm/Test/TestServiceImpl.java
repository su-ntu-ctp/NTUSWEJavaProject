package com.example.simplecrm.Test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
  private TestRepository testRepository;

  public TestServiceImpl(TestRepository testRepository) {
    this.testRepository = testRepository;
  }

  // Create
  @Override
  public Test createTest(Test test) {
    Test newTest = testRepository.save(test);
    return newTest;
  }

  // Get One
  @Override
  public Test getTest(int id) {
    Test foundTest = testRepository.findById(id).get();
    return foundTest;
  }

  // Get All
  @Override
  public ArrayList<Test> getAllTest() {
    List<Test> allTest = testRepository.findAll();
    return (ArrayList<Test>) allTest;
  }

  // Update
  @Override
  public Test updateTest(int id, Test test) {

    // Retrieve customer from DB
    Test testToUpdate = testRepository.findById(id).get();

    // Update the customer retrieved from DB
    testToUpdate.setRemarks(test.getRemarks());
    testToUpdate.setInteractionDate(test.getInteractionDate());

    // Save and return the data

    return testRepository.save(testToUpdate);
  }

  // Delete
  @Override
  public void deleteTest(int id) {
    testRepository.deleteById(id);
  }

}
