package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

import java.io.IOException;

/**
 * The command that adds a <code>Todo</code> task to the <code>TaskList</code>.
 * <code>taskList</code> points to the <code>TaskList</code> class where the task is added.
 * <code>description</code> stores the description of the task.
 */
public class AddTodoCommand extends Command {
    protected TaskList taskList;
    protected String description;

    /**
     * Creates a command to add an <code>Todo</code> task to the <code>TaskList</code>.
     * @param taskList the <code>TaskList</code> where the task is added.
     * @param des the description of the task.
     */
    public AddTodoCommand(TaskList taskList, String des){
        this.taskList = taskList;
        this.description = des;
    }

    @Override
    public void execute() {
        taskList.addTask(description);
    }
}
