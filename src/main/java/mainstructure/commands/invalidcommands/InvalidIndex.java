package mainstructure.commands.invalidcommands;

import mainstructure.UI;

/**
 * Conveys to the user that the task with such index does not exist.
 */
public class InvalidIndex extends InvalidCommand{
    @Override
    public void execute(){
        UI.print("Invalid task index\n");
    }
}
