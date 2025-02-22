package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

import java.io.IOException;

public class AddTodoCommand extends Command {
    protected TaskList taskList;
    protected String description;

    public AddTodoCommand(TaskList taskList, String des){
        this.taskList = taskList;
        this.description = des;
    }

    @Override
    public void execute() {
        taskList.addTask(description);
    }
}
