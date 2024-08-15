package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.booleanuk.core.NonExistentTaskException;
import com.booleanuk.core.Task;

class TodoListExtendedTest {
  @Test
  public void testTodoListExtendedSearch() {
    TodoListExtended todoList = new TodoListExtended();

    Task walkDog = new Task("Walk dog");
    todoList.add(walkDog);

    try {
      Assertions.assertEquals(walkDog, todoList.search(walkDog.ID));
    } catch (NonExistentTaskException e) {
      Assertions.fail("Should be unreachable");
    }

    try {
      todoList.search(9);
      Assertions.fail("Should be unreachable");
    } catch (NonExistentTaskException e) {
    }
  }

  @Test
  public void testTodoListExtendedSetDescription() {
    TodoListExtended todoList = new TodoListExtended();

    Task walkDog = new Task("Walk dog");
    todoList.add(walkDog);
    todoList.setTaskDescription(walkDog.ID, "Water plants");
    Assertions.assertEquals(todoList.search(walkDog.ID).description, "Water plants");
  }
}
