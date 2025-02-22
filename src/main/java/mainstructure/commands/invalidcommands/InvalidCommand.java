package mainstructure.commands.invalidcommands;

import mainstructure.UI;
import mainstructure.commands.Command;

public class InvalidCommand extends Command {
    @Override
    public void execute(){
        String message = """
                Invalid command!
                Enter "wiki" to view the list of commands available.
                """;
        UI.print(message);
    }
}
