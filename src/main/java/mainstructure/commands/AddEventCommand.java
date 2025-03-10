package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

import java.io.IOException;

/**
 * The command that adds an <code>Event</code> task to the <code>TaskList</code>.
 * <code>start</code> variable stores the starting time of the task.
 */
public class AddEventCommand extends AddDeadlineCommand{
    protected String start;

    /**
     * Creates a command to add an <code>Event</code> task to the <code>TaskList</code>.
     * @param taskList the <code>TaskList</code> where the task is added.
     * @param des the description of the task.
     * @param start the starting time of the task.
     * @param end the ending time of the task.
     */
    public AddEventCommand(TaskList taskList, String des, String start, String end) throws IOException {
        super(taskList, des, end);
        if (start.isEmpty()) {
            throw new IOException();
        }
        this.start = start;
    }

    @Override
    public void execute(){
        taskList.addTask(description, start, end);
    }
}
