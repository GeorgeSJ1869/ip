package mainstructure.commands.invalidcommands;

import mainstructure.UI;

public class InvalidEvent extends InvalidCommand{
    @Override
    public void execute(){
        String message = """
                        You need to specify the start and end date of the event!
                        Format: event [task name] /from [start time] /to [end time]
                        """;
        UI.print(message);
    }
}
