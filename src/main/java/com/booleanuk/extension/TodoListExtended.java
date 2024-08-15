package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.booleanuk.core.NonExistentTaskException;

public class TodoListExtended {
  protected List<TaskExtended> tasks = new ArrayList<>();

  public void add(TaskExtended task) {
    if (!this.tasks.contains(task))
      this.tasks.add(task);
  }

  public TaskExtended search(int ID) throws NonExistentTaskException {
    for (TaskExtended task : this.tasks)
      if (task.ID == ID)
        return task;

    // Will only be reached if task with taskDescription does not exist
    throw new NonExistentTaskException(ID);
  }

  public void setTaskDescription(int ID, String description) throws NonExistentTaskException {
    for (TaskExtended task : this.tasks)
      if (task.ID == ID) {
        task.description = description;
        return;
      }

    throw new NonExistentTaskException(ID);
  }

  public void toggleCompletion(int ID) throws NonExistentTaskException {
    for (TaskExtended task : this.tasks)
      if (task.ID == ID) {
        task.completed = !task.completed;
        return;
      }

    throw new NonExistentTaskException(ID);
  }

  public List<LocalDateTime> getAddedDates() {
    List<LocalDateTime> addedDates = new ArrayList<>();

    for (TaskExtended task : this.tasks)
      addedDates.add(task.dateAdded);

    return addedDates;
  }
}
