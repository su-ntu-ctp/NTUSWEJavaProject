package com.example.simplecrm.lessonreferencefiles;

public class InteractionNotFoundException extends RuntimeException {
  public InteractionNotFoundException(int id) {
    super("Interaction with id " + id + " not found.");
  }
}
