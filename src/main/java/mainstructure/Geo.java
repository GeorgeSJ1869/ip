package mainstructure;

import java.io.FileNotFoundException;
import java.util.Scanner;

import mainstructure.commands.Command;
import mainstructure.parser.CommandParser;
import mainstructure.savemanager.SaveManager;
import mainstructure.taskmanager.*;

public class Geo {
    public static void main(String[] args) {
        String logo = "Geo";
        Scanner scanner = new Scanner(System.in);

        UI.print("Hello from " + logo + '\n' + "How can I help you?\n" + "Enter " + '"' + "wiki " + '"' + "to view available commands.\n");

        TaskList taskList;
        try {
            taskList = new TaskList(SaveManager.readSave(SaveManager.defaultPath));
        } catch (FileNotFoundException e){
            taskList = new TaskList();
        }

        while(true){
            String input = scanner.nextLine();
            Command command = CommandParser.parse(input, taskList);
            command.execute();
        }
    }
}
