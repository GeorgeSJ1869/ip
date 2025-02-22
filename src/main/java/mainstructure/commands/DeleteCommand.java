package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

public class DeleteCommand extends Command{
    TaskList taskList;
    int index;

    public DeleteCommand(TaskList taskList, int index){
        this.taskList = taskList;
        this.index = index;
    }

    @Override
    public void execute(){
        taskList.deleteTask(index);
    }
}
