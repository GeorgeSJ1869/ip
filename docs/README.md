# Geo User Guide

### Geo is a chatbot that helps users with managing tasks. Users can enter commands via the console to store, view and delete three types of tasks. Details of each command is shown below:

## Commands

### 1. Close Application
**Command:** `bye`

**Description:** Exits and closes the application.

**Example**: `bye`
```
Bye. Hope to see you again soon!
```

---

### 2. View All Tasks
**Command:** `list`

**Description:** Displays a list of all tasks currently in the system.

**Example:** `list`
```
Here is the list of all tasks:
1. [E][ ] weekend (from: Mar 8 2025 to: Mar 9 2025)
2. [D][ ] ip (by: Mar 7 2025)
```

---

### 3. Add a To-Do Task
**Command:** `todo [task name]`

**Description:** Adds a new task with the given name.

**Example:** `todo watch movie`
```
Task added:
[T][ ] watch movie
Task count now: 3
```

---

### 4. Add a Deadline Task
**Command:** `deadline [task name] /by [deadline]`

**Description:** Adds a task with a specific deadline. The deadline should be in `YYYY-MM-DD` format.

**Example:** `deadline ip /by 2025-03-07`
```
Task added:
[D][ ] ip (by: Mar 7 2025)
Task count now: 3
```

---

### 5. Add an Event Task
**Command:** `event [task name] /from [start time] /to [end time]`

**Description:** Adds a task with a specific start and end time. The date should be in `YYYY-MM-DD` format.

**Example:** `event weekend /from 2025-03-08 /to 2025-03-09`
```
Task added:
[E][ ] weekend (from: Mar 8 2025 to: Mar 9 2025)
Task count now: 1
```

---

### 6. Delete a Task
**Command:** `delete X`

**Description:** Removes the Xth task from the list.

**Example:** `delete 3`
```
Task deleted:
[T][ ] watch movie
Task count now: 2
```

---

### 7. Mark a Task as Done
**Command:** `mark X`

**Description:** Marks the Xth task in the list as completed.

**Example:** `mark 1`
```
This task is marked as done:
[E][X] weekend (from: Mar 8 2025 to: Mar 9 2025)
```

---

### 8. Mark a Task as Undone
**Command:** `unmark X`

**Description:** Marks the Xth task in the list as not completed.

**Example:** `unmark 1`
```
This task is marked as undone:
[E][ ] weekend (from: Mar 8 2025 to: Mar 9 2025)
```

---

### 9. Find Tasks
**Command:** `find [keyword]`

**Description:** Displays all tasks that contain the specified keyword. The index of the task remains the same as it is in the full list.

**Example:** `find weekend`
```
Here are the tasks found:
1. [E][ ] weekend (from: Mar 8 2025 to: Mar 9 2025)
3. [T][ ] watch movie on weekend
```

---

### 10. List of All Commands
**Command:** `wiki`

**Description:** Prints to the console all available commands that the user can input.

**Example:** `wiki`
```
Here are some commands that might be useful to you:
                
"bye": Close this application
"list": View the list of all tasks
"todo [task name]": Add a task named [task name]
"deadline [task name] /by [deadline]": Add a task with a specific deadline. Time should be YYYY-MM-DD format.
"event [task name] /from [start time] /to [end time]": Add a task with specific start and end times. Time should be YYYY-MM-DD format.
"delete X": Delete the Xth task from the list.
"mark X": Mark the Xth task in the list as done
"unmark X": Mark the Xth task in the list as undone
"find [keyword]": View the list of all tasks that contains the [keyword] in the description.
```
