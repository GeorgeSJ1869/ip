public class TaskList {
    protected Task[] taskList;
    protected int taskCount;

    public TaskList(){
        taskList = new Task[100];
        taskCount = 0;
    }

    public int getTaskCount(){
        return taskCount;
    }

    public void addTask(String description){
        taskList[taskCount] = new Todo(description);
        taskCount++;
        UI.printAddTaskMessage(showTask(taskCount), taskCount);
    }

    public void addTask(String description, String deadline){
        taskList[taskCount] = new Deadline(description, deadline);
        taskCount++;
        UI.printAddTaskMessage(showTask(taskCount), taskCount);
    }

    public void addTask(String description, String startTime, String endTime){
        taskList[taskCount] = new Event(description, startTime, endTime);
        taskCount++;
        UI.printAddTaskMessage(showTask(taskCount), taskCount);
    }

    public void mark(int taskIndex, boolean status){
        if (taskIndex > taskCount || taskIndex <= 0){
            UI.print("Invalid task number! Type " + '"' + "list" + '"' + " to view the list of tasks\n");
            return;
        }
        taskList[taskIndex - 1].mark(status);
        UI.print("This task is marked as done:\n"
                    + showTask(taskIndex) + '\n');
    }

    public String showTask(int taskIndex){
        return taskList[taskIndex - 1].toString();
    }

    public String showFullList(){
        if (taskCount <= 0){
            return "List is empty!\n";
        } else {
            String list = "Here is the list of all tasks:\n";
            for (int i = 0; i < taskCount; i++){
                list += (Integer.toString(i + 1) + ". " + taskList[i].toString() + "\n");
            }
            return list;
        }
    }
}
