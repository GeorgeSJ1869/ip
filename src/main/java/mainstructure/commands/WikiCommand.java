package mainstructure.commands;

import mainstructure.UI;

public class WikiCommand extends Command{
    @Override
    public void execute(){
        UI.printTaskWiki();
    }
}
