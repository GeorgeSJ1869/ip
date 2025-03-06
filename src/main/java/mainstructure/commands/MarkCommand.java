package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

/**
 * The command that marks the <code>index</code>th task in the <code>taskList</code> as done or not done.
 */
public class MarkCommand extends Command{
    protected Boolean isDone;
    protected TaskList taskList;
    protected int index;

    /**
     * Create a command to mark the <code>index</code>th task in the <code>taskList</code> as done or not done.
     * @param isDone whether the task should be marked done or not done. true means done, vice versa.
     * @param taskList the <code>TaskList</code> where the task is marked.
     * @param index the index of the task to be marked. The first task has index 1.
     */
    public MarkCommand(Boolean isDone, TaskList taskList, int index) {
        this.isDone = isDone;
        this.taskList = taskList;
        this.index = index;
    }

    @Override
    public void execute(){
        taskList.mark(index, isDone);
    }
}
