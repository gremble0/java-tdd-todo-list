package com.booleanuk.core;

public class NonExistentTaskException extends RuntimeException {
  public NonExistentTaskException(String taskDescription) {
    super(taskDescription);
  }
}
