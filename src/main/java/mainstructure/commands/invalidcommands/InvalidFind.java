package mainstructure.commands.invalidcommands;

import mainstructure.UI;

public class InvalidFind extends InvalidCommand{
    @Override
    public void execute(){
        String message = """
                        You need to specify the keyword!
                        Format: find [keyword]
                        """;
        UI.print(message);
    }
}
