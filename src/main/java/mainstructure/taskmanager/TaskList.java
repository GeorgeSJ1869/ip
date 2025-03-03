package mainstructure.taskmanager;

import mainstructure.UI;
import mainstructure.savemanager.SaveManager;

import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> taskList;
    protected int taskCount;

    public TaskList(){
        taskList = new ArrayList<Task>();
        taskCount = 0;
    }

    public TaskList(ArrayList<Task> existingList){
        taskList = existingList;
        taskCount = existingList.size();
    }

    public int getTaskCount(){
        return taskCount;
    }

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
            int i = 1;
            for (Task task: taskList){
                list += (i + ". " + task.toString() + "\n");
                i++;
            }
            return list;
        }
    }

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

    public String find(String content){
        String list = "";
        int i = 1;
        for (Task task : taskList){
            if (task.description.toLowerCase().contains(content.toLowerCase())){
                list += (i + ". " + task.toString() + '\n');
            }
            i++;
        }
        return list.isEmpty() ? "No matching result\n" : list;
    }
}
