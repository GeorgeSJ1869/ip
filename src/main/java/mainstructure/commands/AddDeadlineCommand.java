package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

/**
 * The command that adds a <code>Deadline</code> task to the <code>TaskList</code>.
 * <code>end</code> variable stores the deadline of the task.
 */
public class AddDeadlineCommand extends AddTodoCommand{
    protected String end;

    /**
     * Creates a command to add an <code>Event</code> task to the <code>TaskList</code>.
     * @param taskList the <code>TaskList</code> where the task is added.
     * @param des the description of the task.
     * @param end the deadline of the task.
     */
    public AddDeadlineCommand(TaskList taskList, String des, String end){
        super(taskList, des);
        this.end = end;
    }

    @Override
    public void execute(){
        taskList.addTask(description, end);
    }
}
