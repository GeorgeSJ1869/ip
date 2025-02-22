package mainstructure.commands.invalidcommands;

import mainstructure.UI;

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
