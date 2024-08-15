## Domain model TodoListExtended class
| Parent class | Methods                                                           | Scenario                                                                     | Output                            |
|--------------|-------------------------------------------------------------------|------------------------------------------------------------------------------|-----------------------------------|
| `TodoList`   |                                                                   |                                                                              |                                   |
|              | `Task search(int id) throws NonExistentTaskException`             | User searches for id of an existing task                                     | The associated task               |
|              |                                                                   | User searches for id of non existent task                                    | Exception                         |
|              |                                                                   |                                                                              |                                   |
|              | `void setTaskDescription(int id) throws NonExistentTaskException` | User sets the description of a task associated with some id                  | Updated tasks description         |
|              |                                                                   | User sets the description of a non existent task                             | Exception                         |
|              |                                                                   |                                                                              |                                   |
|              | `void toggleCompletion(int id) throws NonExistentTaskException`   | User toggles the completion of a task associated with some id                | Updated tasks completion          |
|              |                                                                   | User toggles the completion of a non existent task                           | Exception                         |
|              |                                                                   |                                                                              |                                   |
|              | `String toString()`                                               | User wants to get a nicely formatted string representation of the todolist   | String representation of todolist |
