package mainstructure.taskmanager;

import mainstructure.UI;
import mainstructure.savemanager.SaveManager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The class that stores an ArrayList of Task, and related operations of the task list.
 */
public class TaskList {
    /**
     * An <code>ArrayList</code> of <code>Task</code> subclasses that store information of every task added.
     */
    protected ArrayList<Task> taskList;
    protected int taskCount;

    /**
     * Instantiates an empty <code>TaskList</code>.
     */
    public TaskList(){
        taskList = new ArrayList<Task>();
        taskCount = 0;
    }

    /**
     * Instantiates a <code>TaskList</code> and import all tasks from <code>existingList</code>
     * @param existingList an <code>ArrayList</code> of <code>Task</code> that will be added upon instantiation
     */
    public TaskList(ArrayList<Task> existingList){
        taskList = existingList;
        taskCount = existingList.size();
    }

    /**
     * @return the total number of tasks in <code>taskList</code>.
     */
    public int getTaskCount(){
        return taskCount;
    }

    /**
     * Adds a Todo type of task to <code>taskList</code>.
     * @param description the description of the todo task.
     */
    public void addTask(String description){
        Task task = new Todo(description);
        taskList.add(task);
        taskCount++;
        try {
            SaveManager.appendTextFile(SaveManager.defaultPath, task.toSave());
            UI.printAddTaskMessage(task.toString(), taskCount);
        } catch (IOException e){
            deleteTaskMute(taskCount);
        }
    }

    /**
     * Adds a Deadline type of task to <code>taskList</code>.
     * @param description the description of the task.
     * @param deadline the deadline of the task.
     */
    public void addTask(String description, String deadline){
        Task task = new Deadline(description, deadline);
        taskList.add(task);
        taskCount++;
        try {
            SaveManager.appendTextFile(SaveManager.defaultPath, task.toSave());
            UI.printAddTaskMessage(task.toString(), taskCount);
        } catch (IOException e){
            deleteTaskMute(taskCount);
        }
    }

    /**
     * Adds an Event type of task to <code>taskList</code>.
     * @param description the description of the task.
     * @param startTime the starting time of the event.
     * @param endTime the ending time of the event.
     */
    public void addTask(String description, String startTime, String endTime){
        Task task = new Event(description, startTime, endTime);
        taskList.add(task);
        taskCount++;
        try {
            SaveManager.appendTextFile(SaveManager.defaultPath, task.toSave());
            UI.printAddTaskMessage(task.toString(), taskCount);
        } catch (IOException e){
            deleteTaskMute(taskCount);
        }
    }

    /**
     * Deletes the <code>index</code>th task in <code>taskList</code>.
     * @param index the index of the task to be deleted. The first task has index 1.
     */
    public void deleteTask(int index){
        try {
            String target = showTask(index);
            taskList.remove(index - 1);
            taskCount--;
            SaveManager.writeTextFile(SaveManager.defaultPath, forSave());
            UI.print("Task deleted:\n"
                    + target + "\n"
                    + "Task count now: " + taskCount + '\n');
        } catch (IndexOutOfBoundsException e){
            UI.print("Invalid task number! Type " + '"' + "list" + '"' + " to view the list of tasks\n");
        } catch (IOException e){
            UI.print("Error in saving the task list");
        }
    }

    /**
     * This method is used when the <code>SaveManager</code>SaveManager is unable to store the data of the newly added task. It deletes the task and informs the user.
     * @param index the index of the task in <code>taskList</code> to be deleted. The first task has index 1.
     */
    private void deleteTaskMute(int index){
        try {
            String target = taskList.get(index - 1).toString();
            taskList.remove(index - 1);
            taskCount--;
            UI.print("Error in saving new task\n" + "The following task is not added to the list:\n" + target + '\n');
        } catch (IndexOutOfBoundsException e){
            UI.print("Error in removing unsaved task\n");
        }
    }

    /**
     * Mark the <code>index</code>th task in <code>taskList</code> as done or not done.
     * @param taskIndex the index of the task to be marked. The first task has index 1.
     * @param status whether the task should be marked done or not done. <code>true</code> means that the task is marked done, vice versa.
     */
    public void mark(int taskIndex, boolean status){
        if (taskIndex > taskCount || taskIndex <= 0){
            UI.print("Invalid task number! Type " + '"' + "list" + '"' + " to view the list of tasks\n");
            return;
        }
        taskList.get(taskIndex - 1).mark(status);
        UI.print("This task is marked as done:\n"
                    + showTask(taskIndex) + '\n');
    }

    /**
     * @param taskIndex the index of the task to be shown. The first task has index 1.
     * @return a <code>String</code> that displays the details of a task in <code>taskList</code>.
     */
    public String showTask(int taskIndex){
        return taskList.get(taskIndex - 1).toString();
    }

    /**
     * @return a <code>String</code> that displays the details of every task in <code>taskList</code>.
     */
    public String showFullList(){
        if (taskCount <= 0){
            return "List is empty!\n";
        } else {
            String list = "Here is the list of all tasks:\n";
            int i = 1;
            for (Task task: taskList){
                list += (i + ". " + task.toString() + "\n");
                i++;
            }
            return list;
        }
    }

    /**
     * Converts the information of all tasks in <code>taskList</code> to a <code>String</code> that can be saved and read by <code>SaveManager</code> easily.
     * @return a <code>String</code> that stores the details of all tasks in the task list.
     */
    public String forSave(){
        if (taskCount <= 0){
            return null;
        }
        StringBuilder content = new StringBuilder();
        for (Task task: taskList){
            content.append(task.toSave()).append('\n');
        }
        return content.toString();
    }

    /**
     * @param content the keyword that the found tasks must contain in the description
     * @return a list that displays all tasks where the description contains <code>content</code>.
     */
    public String find(String content){
        String list = "";
        int i = 1;
        for (Task task : taskList){
            if (task.description.toLowerCase().contains(content.toLowerCase())){
                list += (i + ". " + task.toString() + '\n');
            }
            i++;
        }
        return list.isEmpty() ? "No matching result\n" : ("Here are the tasks found:\n" + list);
    }
}
