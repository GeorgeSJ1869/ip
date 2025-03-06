package mainstructure.commands.invalidcommands;

import mainstructure.UI;

/**
 * Conveys to the user that they need to add details to the <code>todo</code> command.
 */
public class InvalidTodo extends InvalidCommand{
    @Override
    public void execute(){
        String message = """
                        You need to specify the task name!
                        Format: todo [task name]
                        """;
        UI.print(message);
    }
}
