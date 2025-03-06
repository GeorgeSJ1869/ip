package mainstructure.commands;
import mainstructure.UI;

/**
 * The command that exits the program.
 */
public class ExitCommand extends Command{
    @Override
    public void execute(){
        UI.print("Bye. Hope to see you again soon!\n");
        System.exit(0);
    }
}
