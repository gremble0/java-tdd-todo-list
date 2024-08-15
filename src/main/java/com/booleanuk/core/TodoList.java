package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private List<Task> tasks = new ArrayList<>();

  public int size() {
    return this.tasks.size();
  }

  public void add(Task task) {
    if (!this.tasks.contains(task))
      this.tasks.add(task);
  }

  public void remove(String taskDescription) throws NonExistentTaskException {
    int i = 0;
    for (Task task : this.tasks)
      if (task.description.equals(taskDescription)) {
        this.tasks.remove(i);
        return;
      }

    // Will only be reached if task with taskDescription does not exist
    throw new NonExistentTaskException(taskDescription);
  }
}
