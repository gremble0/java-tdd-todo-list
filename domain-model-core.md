## Domain model Task class
| Variables                | Methods                              | Scenario | Output |
|--------------------------|--------------------------------------|----------|--------|
| `static int taskCounter` |                                      |          |        |
| `String description`     |                                      |          |        |
| `int ID`                 |                                      |          |        |
| `boolean completed`      |                                      |          |        |
|                          | `boolean equals(String description)` |          |        |

## Domain model NonExistentTaskException class
| Parent class       |
|--------------------|
| `RuntimeException` |

## Domain model TodoList class
| Variables          | Methods                                                                         | Scenario                                                                     | Output                                                |
|--------------------|---------------------------------------------------------------------------------|------------------------------------------------------------------------------|-------------------------------------------------------|
| `List<Task> tasks` |                                                                                 |                                                                              |                                                       |
|                    | `void add(Task task)`                                                           | User adds new task                                                           |                                                       |
|                    | `void remove(String taskDescription) throws NonExistentTaskException`           | User removes existing task                                                   |                                                       |
|                    |                                                                                 | User removes non existent task                                               | NonExistentTaskException                              |
|                    |                                                                                 |                                                                              |                                                       |
|                    | `void toggleCompletion(String taskDescription) throws NonExistentTaskException` | User completes uncompleted task                                              |                                                       |
|                    |                                                                                 | User marks completed task as uncompleted                                     |                                                       |
|                    |                                                                                 |                                                                              |                                                       |
|                    | `List<Task> getTasks()`                                                         | User wants to see the status of all tasks                                    | All registered tasks                                  |
|                    |                                                                                 |                                                                              |                                                       |
|                    | `List<Task> getTasksAlphabeticallyAscending()`                                  | User wants to see the status of all tasks in alphabetical ascending order    | All registered tasks sorted alphabetically ascending  |
|                    |                                                                                 |                                                                              |                                                       |
|                    | `List<Task> getTasksAlphabeticallyDescending()`                                 | User wants to see the status of all tasks in alphabetically descending order | All registered tasks sorted alphabetically descending |
|                    |                                                                                 |                                                                              |                                                       |
|                    | `List<Task> getCompletedTasks()`                                                | User wants to see the status of all completed tasks                          | All registered tasks filtered by completed            |
|                    |                                                                                 |                                                                              |                                                       |
|                    | `List<Task> getUncompletedTasks()`                                              | User wants to see the status of all uncompleted tasks                        | All registered tasks filtered by not completed        |
|                    |                                                                                 |                                                                              |                                                       |
|                    | `Task searchTask(String taskDescription) throws NonExistentTaskException`       | User wants to see the status of some existing task description               | The associated task                                   |
|                    |                                                                                 | User wants to see the status of a non nonexistent task                       | NonExistentTaskException                              |