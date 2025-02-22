package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

public class AddDeadlineCommand extends AddTodoCommand{
    protected String end;

    public AddDeadlineCommand(TaskList taskList, String des, String end){
        super(taskList, des);
        this.end = end;
    }

    @Override
    public void execute(){
        taskList.addTask(description, end);
    }
}
