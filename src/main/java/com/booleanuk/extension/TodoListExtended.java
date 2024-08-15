package com.booleanuk.extension;

import com.booleanuk.core.NonExistentTaskException;
import com.booleanuk.core.Task;
import com.booleanuk.core.TodoList;

public class TodoListExtended extends TodoList {
  public Task search(int ID) throws NonExistentTaskException {
    for (Task task : this.tasks)
      if (task.ID == ID)
        return task;

    // Will only be reached if task with taskDescription does not exist
    throw new NonExistentTaskException(ID);
  }

  public void setTaskDescription(int ID, String description) throws NonExistentTaskException {
    for (Task task : this.tasks)
      if (task.ID == ID) {
        task.description = description;
        return;
      }

    // Will only be reached if task with taskDescription does not exist
    throw new NonExistentTaskException(ID);
  }
}
