package mainstructure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import mainstructure.commands.Command;
import mainstructure.commands.Parser;
import mainstructure.savemanager.SaveManager;
import mainstructure.taskmanager.*;

public class Geo {
    public static void main(String[] args) throws FileNotFoundException {
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
            Command command = Parser.parse(input, taskList);
            command.execute();
        }
    }
}
