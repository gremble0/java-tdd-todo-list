## Domain model TodoListExtended class
| Parent class | Methods                                                          | Scenario                                                                   | Output                            |
|--------------|------------------------------------------------------------------|----------------------------------------------------------------------------|-----------------------------------|
| `TodoList`   |                                                                  |                                                                            |                                   |
|              | `Task search(int id) throws NonExistentTaskException`            | User searches for id of an existing task                                   | The associated task               |
|              |                                                                  | User searches for id of non existent task                                  | Exception                         |
|              |                                                                  |                                                                            |                                   |
|              | `void setTaskName(int id) throws NonExistentTaskException`       | User sets the name of a task associated with some id                       | Updated tasks name                |
|              |                                                                  | User sets the name of a non existent task                                  | Exception                         |
|              |                                                                  |                                                                            |                                   |
|              | `void setTaskCompletion(int id) throws NonExistentTaskException` | User sets the completion of a task associated with some id                 | Updated tasks completion          |
|              |                                                                  | User sets the completion of a non existent task                            | Exception                         |
|              |                                                                  |                                                                            |                                   |
|              | `String toString()`                                              | User wants to get a nicely formatted string representation of the todolist | String representation of todolist |
