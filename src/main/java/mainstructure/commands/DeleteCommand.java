package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

/**
 * The command that deletes the <code>index</code>th task from the <code>taskList</code>.
 */
public class DeleteCommand extends Command{
    TaskList taskList;
    int index;

    /**
     * Create a command to delete the <code>index</code>th task from the <code>taskList</code>.
     * @param taskList the <code>TaskList</code> class where the task is deleted.
     * @param index the index of the task to be deleted. The first task has index 1.
     */
    public DeleteCommand(TaskList taskList, int index){
        this.taskList = taskList;
        this.index = index;
    }

    @Override
    public void execute(){
        taskList.deleteTask(index);
    }
}
