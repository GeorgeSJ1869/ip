package mainstructure.commands;

import mainstructure.UI;
import mainstructure.taskmanager.TaskList;

/**
 * The command that prints the list of all tasks in <code>taskList</code> in the CLI.
 */
public class ListCommand extends Command{
    TaskList taskList;

    /**
     * Creates a command to print a list of all <code>Task</code> in the <code>taskList</code> to the console.
     * @param list the <code>TaskList</code> to be listed in the console.
     */
    public ListCommand(TaskList list){
        taskList = list;
    }

    @Override
    public void execute(){
        UI.print(taskList.showFullList());
    }
}
