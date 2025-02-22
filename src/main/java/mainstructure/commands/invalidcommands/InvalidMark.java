package mainstructure.commands.invalidcommands;

import mainstructure.UI;

public class InvalidMark extends InvalidCommand {
    @Override
    public void execute(){
        String message = """
                    You need to specify which task to be marked!
                    Format: mark/unmark X
                    """;
        UI.print(message);
    }
}
