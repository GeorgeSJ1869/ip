package mainstructure;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import mainstructure.commands.Command;
import mainstructure.parser.Parser;
import mainstructure.savemanager.SaveManager;
import mainstructure.taskmanager.*;

public class Geo {
    public static void main(String[] args) throws FileNotFoundException {
        String logo = "Geo";
        Scanner scanner = new Scanner(System.in);

        UI.print("Hello from " + logo + '\n' + "How can I help you?\n" + "Enter " + '"' + "wiki " + '"' + "to view available commands.\n");
        //LocalDate d1 = LocalDate.parse("2019-12-01");
        //System.out.println(d1.format(DateTimeFormatter.ofPattern("d MMM yyyy")));

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
