package com.booleanuk.core;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {
    @Test
    public void testTodoListAdd() {
        TodoList todoList = new TodoList();
        todoList.add(new Task("Water plants"));
        Assertions.assertEquals(todoList.size(), 1);

        // Adding same task should only overwrite existing task
        todoList.add(new Task("Water plants"));
        Assertions.assertEquals(todoList.size(), 1);

        todoList.add(new Task("Grocery shopping"));
        Assertions.assertEquals(todoList.size(), 2);
    }

    @Test
    public void testTodoListRemove() {
        TodoList todoList = new TodoList();
        todoList.add(new Task("Water plants"));
        todoList.add(new Task("Grocery shopping"));
        Assertions.assertEquals(todoList.size(), 2);

        try {
            todoList.remove("Water plants");
            Assertions.assertEquals(todoList.size(), 1);
        } catch (NonExistentTaskException e) {
            Assertions.fail("Should be unreachable");
        }
    }

    @Test
    public void testTodoListRemoveNonExistent() {
        TodoList todoList = new TodoList();
        todoList.add(new Task("Water plants"));
        todoList.add(new Task("Grocery shopping"));
        Assertions.assertEquals(todoList.size(), 2);

        try {
            todoList.remove("Walk the dog");

            Assertions.fail("Should be unreachable");
        } catch (NonExistentTaskException e) {
            // Size should still be the same
            Assertions.assertEquals(todoList.size(), 2);
        }
    }

    @Test
    public void testTodoListSearch() {
        TodoList todoList = new TodoList();
        todoList.add(new Task("Water plants"));

        try {
            todoList.search("Water plants");
        } catch (NonExistentTaskException e) {
            Assertions.fail("Should be unreachable");
        }

        try {
            todoList.search("Walk dog");
            Assertions.fail("Should be unreachable");
        } catch (NonExistentTaskException e) {
        }
    }

    @Test
    public void testTodoListToggleCompletion() {
        TodoList todoList = new TodoList();
        todoList.add(new Task("Water plants"));

        try {
            Assertions.assertFalse(todoList.search("Water plants").completed);
        } catch (NonExistentTaskException e) {
            Assertions.fail("Should be unreachable");
        }

        todoList.toggleCompletion("Water plants");

        try {
            Assertions.assertTrue(todoList.search("Water plants").completed);
        } catch (NonExistentTaskException e) {
            Assertions.fail("Should be unreachable");
        }

        todoList.toggleCompletion("Water plants");

        try {
            Assertions.assertFalse(todoList.search("Water plants").completed);
        } catch (NonExistentTaskException e) {
            Assertions.fail("Should be unreachable");
        }
    }

    @Test
    public void testTodoListGetTasks() {
        TodoList todoList = new TodoList();
        Task waterPlants = new Task("Water plants");
        Task walkDog = new Task("Walk dog");
        todoList.add(waterPlants);
        todoList.add(walkDog);

        List<Task> tasks = todoList.getTasks();
        Assertions.assertEquals(tasks.getFirst(), waterPlants);
        Assertions.assertEquals(tasks.getLast(), walkDog);
    }

    @Test
    public void testTodoListGetTasksAlphabeticallyAscending() {
        TodoList todoList = new TodoList();
        Task walkDog = new Task("Walk dog");
        Task waterPlants = new Task("Water plants");
        todoList.add(walkDog);
        todoList.add(waterPlants);

        List<Task> tasks = todoList.getTasksAlphabeticallyAscending();
        // "Walk dog" is alphabetically before "Water plants" so walkDog should be first
        // in ascending order
        Assertions.assertEquals(tasks.getFirst(), walkDog);
        Assertions.assertEquals(tasks.getLast(), waterPlants);
    }

    @Test
    public void testTodoListGetTasksAlphabeticallyDescending() {
        TodoList todoList = new TodoList();
        Task walkDog = new Task("Walk dog");
        Task waterPlants = new Task("Water plants");
        todoList.add(walkDog);
        todoList.add(waterPlants);

        List<Task> tasks = todoList.getTasksAlphabeticallyDescending();
        // "Walk dog" is alphabetically before "Water plants" so waterPlants should be
        // first in descending order
        Assertions.assertEquals(tasks.getFirst(), waterPlants);
        Assertions.assertEquals(tasks.getLast(), walkDog);
    }

    @Test
    public void testTodoListGetCompletedTasks() {
        TodoList todoList = new TodoList();
        Task waterPlants = new Task("Water plants");
        todoList.add(waterPlants);
        todoList.add(new Task("Walk dog"));

        todoList.toggleCompletion("Water plants");

        List<Task> completedTasks = todoList.getCompletedTasks();
        Assertions.assertEquals(1, completedTasks.size());
        Assertions.assertEquals(waterPlants, completedTasks.getFirst());
    }

    @Test
    public void testTodoListGetUncompletedTasks() {
        TodoList todoList = new TodoList();
        todoList.add(new Task("Water plants"));
        Task walkDog = new Task("Walk dog");
        todoList.add(walkDog);

        todoList.toggleCompletion("Water plants");

        List<Task> uncompletedTasks = todoList.getUncompletedTasks();
        Assertions.assertEquals(1, uncompletedTasks.size());
        Assertions.assertEquals(walkDog, uncompletedTasks.getFirst());
    }
}
