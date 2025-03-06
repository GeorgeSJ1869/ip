package mainstructure.commands.invalidcommands;

import mainstructure.UI;

/**
 * Conveys to the user that they need to add details to the <code>delete</code> command.
 */
public class InvalidDelete extends InvalidCommand{
    @Override
    public void execute(){
        String message = """
                        You need to specify which task to delete!
                        Format: delete X
                        """;
        UI.print(message);
    }
}
