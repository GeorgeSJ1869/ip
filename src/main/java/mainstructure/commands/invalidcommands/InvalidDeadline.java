package mainstructure.commands.invalidcommands;

import mainstructure.UI;

/**
 * Conveys to the user that they need to add details to the <code>deadline</code> command.
 */
public class InvalidDeadline extends InvalidCommand{
    @Override
    public void execute(){
        String message = """
                        You need to specify the deadline!
                        Format: deadline [task name] /by [deadline]
                        """;
        UI.print(message);
    }
}
