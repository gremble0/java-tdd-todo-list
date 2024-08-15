package com.booleanuk.core;

public class Task {
  private static int taskCounter = 0;

  private int ID;
  public boolean completed;
  public String description;

  public Task(String description, boolean completed) {
    this.ID = taskCounter++;
    this.description = description;
    this.completed = completed;
  }

  public Task(String description) {
    this(description, false);
  }

  /**
   * This method is used to compare each task in the TodoList
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Task))
      return false;

    Task otherTask = (Task) other;
    if (otherTask.description.equals(this.description))
      return true;
    else
      return false;
  }
}
