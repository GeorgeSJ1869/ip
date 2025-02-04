public class TaskList {
    protected Task[] taskList;
    protected int taskCount;

    public TaskList(){
        taskList = new Task[100];
        taskCount = 0;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void addTask(String description){
        taskList[taskCount] = new Task(description);
        taskCount++;
    }

    public void markDone(int taskIndex){
        if (taskIndex > taskCount){
            return;
        }
        taskList[taskIndex - 1].markAsDone();
    }

    public void markUndone(int taskIndex){
        if (taskIndex > taskCount){
            return;
        }
        taskList[taskIndex - 1].markAsUndone();
    }

    public String showTask(int taskIndex){
        return "  " + taskList[taskIndex - 1].showTask();
    }

    public String showFullList(){
        if (taskCount <= 0){
            return "List is empty!\n";
        }
        else{
            String list = "Here are the tasks in your list:\n";
            for (int i = 0; i < taskCount; i++){
                list += (Integer.toString(i + 1) + ". " + taskList[i].showTask() + "\n");
            }
            return list;
        }
    }
}
