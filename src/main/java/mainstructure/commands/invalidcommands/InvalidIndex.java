package mainstructure.commands.invalidcommands;

import mainstructure.UI;

public class InvalidIndex extends InvalidCommand{
    @Override
    public void execute(){
        UI.print("Invalid task index\n");
    }
}
