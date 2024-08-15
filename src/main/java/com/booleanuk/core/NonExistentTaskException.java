package com.booleanuk.core;

public class NonExistentTaskException extends RuntimeException {
  public NonExistentTaskException(String taskDescription) {
    super("No task with description: '" + taskDescription + "' exists");
  }

  public NonExistentTaskException(int ID) {
    super("No task with ID: '" + ID + "'exists");
  }
}
