package mainstructure.commands;

import mainstructure.taskmanager.TaskList;

public class MarkCommand extends Command{
    protected Boolean isDone;
    protected TaskList taskList;
    protected int index;

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
