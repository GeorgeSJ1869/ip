package mainstructure.taskmanager;

/**
 * The basic class that stores information for every type of task.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Instantiate a task that is default undone.
     * @param description the description of the task.
     */
    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    /**
     * Instantiate a task that is done or not done.
     * @param description the description of the task.
     * @param isDone whether the task is marked done or undone.
     */
    public Task(String description, boolean isDone){
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * @return a <code>String</code> that displays the details of the task.
     */
    public String toString(){
        return (isDone ? "[X] " : "[ ] ") + description;
    }

    /**
     * @return a <code>String</code> that can be stored and read by <code>SaveManager</code> easily.
     */
    public String toSave(){
        return "Error occurred in saving process";
    }

    /**
     * Mark this task as done or not done.
     * @param status true means done, vice versa.
     */
    public void mark(boolean status){
        isDone = status;
    }
}
