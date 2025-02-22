package mainstructure.commands.invalidcommands;

import mainstructure.UI;

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
