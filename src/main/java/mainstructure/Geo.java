package mainstructure;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;
import mainstructure.taskmanager.*;

public class Geo {
    public static void main(String[] args){
        String logo = "Geo";
        Scanner scanner = new Scanner(System.in);

        //Welcome
        UI.print("Hello from " + logo + '\n' + "How can I help you?\n");

        TaskList taskList = new TaskList();

        while(true){
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")){
                UI.print("Bye. Hope to see you again soon!\n");
                System.exit(0);
            } else if (input.equalsIgnoreCase("list")) {
                UI.print(taskList.showFullList());
            //} else if(input.equalsIgnoreCase("wiki")){
                //UI.printTaskWiki();
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
                }
            }
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

    public static void addTask(TaskList list, String command, String rest){
        switch (command){
        case "todo":
            list.addTask(rest);
            break;
        case "deadline":
            String[] split = rest.split("/by", 2);
            list.addTask(split[0].trim(), split[1].trim());
            break;
        case "event":
            String[] firstSplit = rest.split("/from", 2);
            String[] secondSplit = firstSplit[1].split("/to", 2);
            list.addTask(firstSplit[0].trim(), secondSplit[0].trim(), secondSplit[1].trim());
            break;
        default:
            //Not expecting to execute this
            UI.print("You need to specify the task type! (todo, deadline or event)\n");
        }
    }
}
