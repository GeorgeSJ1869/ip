package mainstructure.commands.invalidcommands;

import mainstructure.UI;

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
