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

        //Welcome
        UI.print("Hello from " + logo + '\n' + "How can I help you?\n");

        TaskList taskList;
        try {
            taskList = new TaskList(SaveManager.readSave(SaveManager.defaultPath));
        } catch (FileNotFoundException e){
            UI.print("Save not found\n");
            taskList = new TaskList();
        }

        while(true){
            String input = scanner.nextLine();
            Command command = Parser.parse(input, taskList);
            command.execute();
            /*
            if (input.equalsIgnoreCase("bye")){
                UI.print("Bye. Hope to see you again soon!\n");
                System.exit(0);
            } else if (input.equalsIgnoreCase("list")) {
                UI.print(taskList.showFullList());

            } else {
                //Action depends on the first word
                String[] splitBySpace = input.split(" ", 2);
                try {
                    switch (splitBySpace[0]) {
                    case "mark":
                        markTask(taskList, input, true);
                        break;
                    case "unmark":
                        markTask(taskList, input, false);
                        break;
                    case "todo":
                        addTask(taskList, "todo", splitBySpace[1]);
                        break;
                    case "deadline":
                        addTask(taskList, "deadline", splitBySpace[1]);
                        break;
                    case "event":
                        addTask(taskList, "event", splitBySpace[1]);
                        break;
                    case "delete":
                        taskList.deleteTask(Integer.parseInt(splitBySpace[1]));
                        break;
                    default:
                        UI.print("Invalid command!\n");
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException | PatternSyntaxException | NumberFormatException e){
                    //If the input is missing information
                    switch (splitBySpace[0]) {
                    case "todo":
                        UI.print("""
                        You need to specify the task name!
                        Format: todo [task name]
                        """);
                        break;
                    case "deadline":
                        UI.print("""
                        You need to specify the deadline!
                        Format: deadline [task name] /by [deadline]
                        """);
                        break;
                    case "event":
                        UI.print("""
                        You need to specify the start and end date of the event!
                        Format: event [task name] /from [start time] /to [end time]
                        """);
                        break;
                    case "delete":
                        UI.print("""
                        You need to specify which task to delete!
                        Format: delete X
                        """);
                        break;
                    default:
                        //Not expecting to execute this
                        UI.print("Seems like an error occurred in the code");
                        break;
                    }
                } catch (IOException e){
                    UI.print("Saving error");
                }
            }
             */
        }
    }

    private static void markTask(TaskList list, String input, boolean status){
        try {
            int index = Integer.parseInt(input.substring(status? 5 : 7));
            list.mark(index, status);
        } catch (NumberFormatException | StringIndexOutOfBoundsException e){
            //If input missing information
            UI.print("""
                    You need to specify which task to be marked!
                    Format: mark/unmark X
                    """);
        } catch (NullPointerException e){
            //Not expecting to execute this because the mark() handles errors already
            UI.print("Error occurred in taskList\n");
        }
    }

    public static void addTask(TaskList list, String command, String rest) throws IOException {
        try {
            switch (command) {
            case "todo":
                list.addTask(rest);
                SaveManager.appendTextFile(SaveManager.defaultPath, list.showTask(list.getTaskCount()));
                break;
            case "deadline":
                String[] split = rest.split("/by|\\(by:|\\)", 3);
                list.addTask(split[0].trim(), split[1].trim());
                SaveManager.appendTextFile(SaveManager.defaultPath, list.showTask(list.getTaskCount()));
                break;
            case "event":
                String[] firstSplit = rest.split("/from|\\(from:", 2);
                String[] secondSplit = firstSplit[1].split("/to|to:|\\)", 3);
                list.addTask(firstSplit[0].trim(), secondSplit[0].trim(), secondSplit[1].trim());
                SaveManager.appendTextFile(SaveManager.defaultPath, list.showTask(list.getTaskCount()));
                break;
            default:
                //Not expecting to execute this
                UI.print("You need to specify the task type! (todo, deadline or event)\n");
            }
        } catch (IOException e){
            SaveManager.writeTextFile(SaveManager.defaultPath, list.showTask(list.getTaskCount()));
        }
    }
}
