package mainstructure.taskmanager;

/**
 * The <code>Task</code> that has a deadline.
 */
public class Deadline extends Task{
    protected String end;

    /**
     * Instantiate a <code>Deadline</code> task which is undone by default.
     * @param description the description of the task.
     * @param deadline the deadline of the task.
     */
    public Deadline(String description, String deadline){
        super(description);
        this.end = deadline;
    }

    /**
     * Instantiate a <code>Deadline</code> task which is done or not done.
     * @param description the description of the task.
     * @param deadline the deadline of the task.
     * @param isDone whether the task is done or not done.
     */
    public Deadline(String description, String deadline, boolean isDone){
        super(description, isDone);
        this.end = deadline;
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + end + ")";
    }

    @Override
    public String toSave(){
        return ("todo" + '|' + isDone + '|' + description + '|' + end);
    }
}
