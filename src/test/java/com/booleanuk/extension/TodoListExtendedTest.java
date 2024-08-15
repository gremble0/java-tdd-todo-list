package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.booleanuk.core.NonExistentTaskException;
import com.booleanuk.core.Task;

class TodoListExtendedTest {
  @Test
  public void testTodoListExtendedSearch() {
    TodoListExtended todoList = new TodoListExtended();

    TaskExtended walkDog = new TaskExtended("Walk dog", LocalDateTime.now());
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

    TaskExtended walkDog = new TaskExtended("Walk dog", LocalDateTime.now());
    todoList.add(walkDog);
    Assertions.assertEquals(todoList.search(walkDog.ID).description, "Walk dog");
    todoList.setTaskDescription(walkDog.ID, "Water plants");
    Assertions.assertEquals(todoList.search(walkDog.ID).description, "Water plants");
  }

  @Test
  public void testTodoListExtendedToggleCompletion() {
    TodoListExtended todoList = new TodoListExtended();

    TaskExtended walkDog = new TaskExtended("Walk dog", LocalDateTime.now());
    todoList.add(walkDog);
    Assertions.assertFalse(todoList.search(walkDog.ID).completed);
    todoList.toggleCompletion(walkDog.ID);
    Assertions.assertTrue(todoList.search(walkDog.ID).completed);
    todoList.toggleCompletion(walkDog.ID);
    Assertions.assertFalse(todoList.search(walkDog.ID).completed);
  }

  @Test
  public void testTodoListExtendedGetAddedDates() {
    TodoListExtended todoList = new TodoListExtended();
    TaskExtended walkDog = new TaskExtended("Walk dog", LocalDateTime.now());
    TaskExtended waterPlants = new TaskExtended("Water plants", LocalDateTime.now());

    todoList.add(walkDog);
    todoList.add(waterPlants);

    List<LocalDateTime> tasksAdded = todoList.getAddedDates();
    Assertions.assertEquals(tasksAdded.getFirst(), walkDog.dateAdded);
    Assertions.assertEquals(tasksAdded.getLast(), waterPlants.dateAdded);
  }
}
