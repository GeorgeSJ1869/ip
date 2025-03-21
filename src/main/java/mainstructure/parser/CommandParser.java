
package mainstructure.parser;

import mainstructure.commands.*;
import mainstructure.commands.invalidcommands.*;
import mainstructure.taskmanager.TaskList;

import java.io.IOException;
import java.util.regex.PatternSyntaxException;

/**
 * Generates commands based on the user's text input.
 */
public class CommandParser {
    /**
     * Parse the user's text input and return a command or an invalid command notification accordingly.
     * @param input the user's text input.
     * @param taskList the <code>TaskList</code> that the commands operate to.
     * @return a <code>Command</code> that performs certain operations.
     */
    public static Command parse(String input, TaskList taskList){
        if (input.equalsIgnoreCase("bye")){
            return new ExitCommand();
        }
        if (input.equalsIgnoreCase("list")) {
            return new ListCommand(taskList);
        }
        if (input.equalsIgnoreCase("wiki")) {
            return new WikiCommand();
        }
        String[] splitCommand = input.trim().split(" ", 2);
        String first = splitCommand[0];
        try {
            String rest = splitCommand[1].trim();
            switch (first) {
            case "mark":
                return new MarkCommand(true, taskList, Integer.parseInt(rest));
            case "unmark":
                return new MarkCommand(false, taskList, Integer.parseInt(rest));
            case "todo":
                return new AddTodoCommand(taskList, rest);
            case "deadline":
                String[] split = rest.split("/by|\\(by:|\\)", 3);
                return new AddDeadlineCommand(taskList, split[0].trim(), split[1].trim());
            case "event":
                String[] firstSplit = rest.split("/from|\\(from:", 2);
                String[] secondSplit = firstSplit[1].split("/to|to:|\\)", 3);
                return new AddEventCommand(taskList, firstSplit[0].trim(), secondSplit[0].trim(), secondSplit[1].trim());
            case "delete":
                return new DeleteCommand(taskList, Integer.parseInt(rest));
            case "find":
                return new FindCommand(taskList, rest);
            default:
                return new InvalidCommand();
            }
        } catch (IndexOutOfBoundsException | IOException e){
            switch (first) {
            case "mark":
            case "unmark":
                return new InvalidMark();
            case "todo":
                return new InvalidTodo();
            case "deadline":
                return new InvalidDeadline();
            case "event":
                return new InvalidEvent();
            case "delete":
                return new InvalidDelete();
            case "find":
                return new InvalidFind();
            default:
                return new InvalidCommand();
            }
        } catch (PatternSyntaxException e){
            return new InvalidCommand();
        } catch (NumberFormatException e){
            return new InvalidIndex();
        }
    }
}
