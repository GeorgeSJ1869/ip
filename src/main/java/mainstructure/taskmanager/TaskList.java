package mainstructure.taskmanager;

import mainstructure.UI;
import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> taskList;
    protected int taskCount;

    public TaskList(){
        taskList = new ArrayList<Task>();
        taskCount = 0;
    }

    public int getTaskCount(){
        return taskCount;
    }

    public void addTask(String description){
        taskList.add(new Todo(description));
        taskCount++;
        UI.printAddTaskMessage(showTask(taskCount), taskCount);
    }

    public void addTask(String description, String deadline){
        taskList.add(new Deadline(description, deadline));
        taskCount++;
        UI.printAddTaskMessage(showTask(taskCount), taskCount);
    }

    public void addTask(String description, String startTime, String endTime){
        taskList.add(new Event(description, startTime, endTime));
        taskCount++;
        UI.printAddTaskMessage(showTask(taskCount), taskCount);
    }

    public void deleteTask(int index){
        try {
            String target = showTask(index);
            taskList.remove(index - 1);
            taskCount--;
            UI.print("Task deleted:\n"
                    + target + "\n"
                    + "Task count now: " + taskCount + '\n');
        } catch (IndexOutOfBoundsException e){
            UI.print("Invalid task number! Type " + '"' + "list" + '"' + " to view the list of tasks\n");
        }
    }

    public void mark(int taskIndex, boolean status){
        if (taskIndex > taskCount || taskIndex <= 0){
            UI.print("Invalid task number! Type " + '"' + "list" + '"' + " to view the list of tasks\n");
            return;
        }
        taskList.get(taskIndex - 1).mark(status);
        UI.print("This task is marked as done:\n"
                    + showTask(taskIndex) + '\n');
    }

    public String showTask(int taskIndex){
        return taskList.get(taskIndex - 1).toString();
    }

    public String showFullList(){
        if (taskCount <= 0){
            return "List is empty!\n";
        } else {
            String list = "Here is the list of all tasks:\n";
            for (int i = 0; i < taskCount; i++){
                list += (Integer.toString(i + 1) + ". " + taskList.get(i).toString() + "\n");
            }
            return list;
        }
    }
}
