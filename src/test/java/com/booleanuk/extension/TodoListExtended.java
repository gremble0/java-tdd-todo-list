package com.booleanuk.extension;

import java.util.List;

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
      Assertions.assertEquals(walkDog, todoList.search(0));
    } catch (NonExistentTaskException e) {
      // Should be unreachable task with id 0 exists
      Assertions.assertTrue(false);
    }

    try {
      todoList.search(9);
      // Should be unreachable task with id 9 does not exist and should throw
      // exception
      Assertions.assertTrue(false);
    } catch (NonExistentTaskException e) {
    }
  }
}
