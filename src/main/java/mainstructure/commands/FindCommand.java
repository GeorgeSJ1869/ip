package mainstructure.commands;

import mainstructure.UI;
import mainstructure.taskmanager.TaskList;

/**
 * The command that prints to the console the list of all tasks that contains a keyword in the description.
 * <code>keyword</code> is present in all tasks printed.
 * <code>taskList</code> points to the <code>TaskList</code> that contains all the tasks.
 */
public class FindCommand extends Command{
    TaskList taskList;
    String keyword;

    /**
     * Creates a command that prints to the console the list of all tasks that contains a keyword in the description.
     * @param taskList the <code>TaskList</code> to search from.
     * @param key the keyword that the found tasks must contain in the description.
     */
    public FindCommand(TaskList taskList, String key){
        this.taskList = taskList;
        this.keyword = key;
    }

    @Override
    public void execute(){
        UI.print(taskList.find(keyword));
    }
}
