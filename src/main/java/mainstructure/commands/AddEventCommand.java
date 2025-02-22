package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

public class AddEventCommand extends AddDeadlineCommand{
    protected String start;

    public AddEventCommand(TaskList taskList, String des, String start, String end){
        super(taskList, des, end);
        this.start = start;
    }

    @Override
    public void execute(){
        taskList.addTask(description, start, end);
    }
}
