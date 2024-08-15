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
}
