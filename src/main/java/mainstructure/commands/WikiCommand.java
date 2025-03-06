package mainstructure.commands;

import mainstructure.UI;

/**
 * Prints the list of all valid commands to the console.
 */
public class WikiCommand extends Command{
    @Override
    public void execute(){
        UI.printTaskWiki();
    }
}
