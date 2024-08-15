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
        }
    }

    @Test
    public void testTodoListSearch() {
        TodoList todoList = new TodoList();
        todoList.add(new Task("Water plants"));

        try {
            todoList.search("Water plants");
        } catch (NonExistentTaskException e) {
            // Should be unreacable - water plants exists in todoList
            Assertions.assertTrue(false);
        }

        try {
            todoList.search("Walk dog");
        } catch (NonExistentTaskException e) {
            // Exception should be caught here, no task "Walk dog" in todoList
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testTodoListToggleCompletion() {
        TodoList todoList = new TodoList();
        todoList.add(new Task("Water plants"));

        try {
            Assertions.assertFalse(todoList.search("Water plants").completed);
        } catch (NonExistentTaskException e) {
            // Should be unreacable
            Assertions.assertTrue(false);
        }

        todoList.toggleCompletion("Water plants");

        try {
            Assertions.assertTrue(todoList.search("Water plants").completed);
        } catch (NonExistentTaskException e) {
            // Should be unreacable
            Assertions.assertTrue(false);
        }

        todoList.toggleCompletion("Water plants");

        try {
            Assertions.assertFalse(todoList.search("Water plants").completed);
        } catch (NonExistentTaskException e) {
            // Should be unreacable
            Assertions.assertTrue(false);
        }
    }
}
