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

  public List<Task> getTasks() {
    return this.tasks;
  }

  public List<Task> getTasksAlphabeticallyAscending() {
    return this.tasks.stream().sorted((first, second) -> first.description.compareTo(second.description)).toList();
  }

  public List<Task> getTasksAlphabeticallyDescending() {
    return this.tasks.stream().sorted((first, second) -> second.description.compareTo(first.description)).toList();
  }

  public List<Task> getCompletedTasks() {
    return this.tasks.stream().filter((task) -> task.completed).toList();
  }

  public List<Task> getUncompletedTasks() {
    return this.tasks.stream().filter((task) -> !task.completed).toList();
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

  public Task search(String taskDescription) throws NonExistentTaskException {
    for (Task task : this.tasks)
      if (task.description.equals(taskDescription))
        return task;

    // Will only be reached if task with taskDescription does not exist
    throw new NonExistentTaskException(taskDescription);
  }

  public void toggleCompletion(String taskDescription) throws NonExistentTaskException {
    for (Task task : this.tasks)
      if (task.description.equals(taskDescription)) {
        task.completed = !task.completed;
        return;
      }

    // Will only be reached if task with taskDescription does not exist
    throw new NonExistentTaskException(taskDescription);
  }
}
