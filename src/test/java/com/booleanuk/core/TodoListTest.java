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
}
