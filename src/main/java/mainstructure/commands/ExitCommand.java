package mainstructure.commands;
import mainstructure.UI;

public class ExitCommand extends Command{
    @Override
    public void execute(){
        UI.print("Bye. Hope to see you again soon!\n");
        System.exit(0);
    }
}
