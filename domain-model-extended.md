## Domain model TaskExtended class
| Parent class | Variables                 |
|--------------|---------------------------|
| `Task`       |                           |
|              | `LocalDateTime dateAdded` |

## Domain model TodoListExtended class
NOTE: inheriting from TodoList creates all sorts of problems in terms of assumptions about parameters being of the type `Task` compared to `TaskExtended` which is what we need in the extension parts. My workaround for this is to just not inherit and only implement the functions that are necessary to implement the requirements in the extension criteria.

| Methods                                                           | Scenario                                                      | Output                        |
|-------------------------------------------------------------------|---------------------------------------------------------------|-------------------------------|
| `void add(TaskExtended task)`                                     | User adds new task                                            |                               |
|                                                                   |                                                               |                               |
| `Task search(int id) throws NonExistentTaskException`             | User searches for id of an existing task                      | The associated task           |
|                                                                   | User searches for id of non existent task                     | Exception                     |
|                                                                   |                                                               |                               |
| `void setTaskDescription(int id) throws NonExistentTaskException` | User sets the description of a task associated with some id   | Updated tasks description     |
|                                                                   | User sets the description of a non existent task              | Exception                     |
|                                                                   |                                                               |                               |
| `void toggleCompletion(int id) throws NonExistentTaskException`   | User toggles the completion of a task associated with some id | Updated tasks completion      |
|                                                                   | User toggles the completion of a non existent task            | Exception                     |
|                                                                   |                                                               |                               |
| `List<LocalDateTime> getAddedDates()`                             | User wants to know the dates every task was added             | the dates each task was added |
