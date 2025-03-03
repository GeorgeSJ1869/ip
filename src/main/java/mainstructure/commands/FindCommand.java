package mainstructure.commands;

import mainstructure.UI;
import mainstructure.taskmanager.TaskList;

public class FindCommand extends Command{
    TaskList taskList;
    String keyword;

    public FindCommand(TaskList taskList, String key){
        this.taskList = taskList;
        this.keyword = key;
    }

    @Override
    public void execute(){
        UI.print(taskList.find(keyword));
    }
}
