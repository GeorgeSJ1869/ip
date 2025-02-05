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
        taskList[taskCount] = new Todo(description);
        taskCount++;
    }

    public void addTask(String description, String deadline){
        taskList[taskCount] = new Deadline(description, deadline);
        taskCount++;
    }

    public void addTask(String description, String startTime, String endTime){
        taskList[taskCount] = new Event(description, startTime, endTime);
        taskCount++;
    }

    public void mark(int taskIndex, boolean status){
        if (taskIndex > taskCount){
            return;
        }
        taskList[taskIndex - 1].mark(status);
    }

    public String showTask(int taskIndex){
        return taskList[taskIndex - 1].toString();
    }

    public String showFullList(){
        if (taskCount <= 0){
            return "List is empty!\n";
        } else {
            String list = "Here are the tasks in your list:\n";
            for (int i = 0; i < taskCount; i++){
                list += (Integer.toString(i + 1) + ". " + taskList[i].toString() + "\n");
            }
            return list;
        }
    }
}
