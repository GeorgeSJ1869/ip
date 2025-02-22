package mainstructure.commands;

import mainstructure.UI;
import mainstructure.taskmanager.TaskList;

public class ListCommand extends Command{
    TaskList taskList;

    public ListCommand(TaskList list){
        taskList = list;
    }

    @Override
    public void execute(){
        UI.print(taskList.showFullList());
    }
}
