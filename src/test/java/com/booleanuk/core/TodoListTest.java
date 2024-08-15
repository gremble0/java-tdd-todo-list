package com.booleanuk.core;

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

            Assertions.assertTrue(true);
        } catch (NonExistentTaskException e) {
            // Should be unreachable
            Assertions.assertTrue(false);
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

            // Should be unreachable
            Assertions.assertTrue(false);
        } catch (NonExistentTaskException e) {
            // Size should still be the same
            Assertions.assertEquals(todoList.size(), 2);
            Assertions.assertTrue(true);
        }
    }
}
