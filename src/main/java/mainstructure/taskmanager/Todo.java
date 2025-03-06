package mainstructure.taskmanager;

/**
 * The <code>Task</code> that does not specify the time.
 */
public class Todo extends Task{
    /**
     * Instantiate a <code>Todo</code> task that is undone by default.
     * @param description the description of the task.
     */
    public Todo(String description){
        super(description);
    }

    /**
     * Instantiate a <code>Todo</code> task that is done or not done.
     * @param description the description of the task.
     * @param isDone whether the task is marked done or undone.
     */
    public Todo(String description, boolean isDone){
        super(description, isDone);
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }

    @Override
    public String toSave(){
        return ("todo" + '|' + isDone + '|' + description);
    }
}
