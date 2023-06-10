package com.example.simplecrm.Test;

import java.util.ArrayList;

public interface TestService {
  Test createTest(Test test);

  Test getTest(int id);

  ArrayList<Test> getAllTest();

  Test updateTest(int id, Test test);

  void deleteTest(int id);
}
