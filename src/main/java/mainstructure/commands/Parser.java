package mainstructure.commands;

import mainstructure.commands.invalidcommands.*;
import mainstructure.taskmanager.TaskList;

import java.util.regex.PatternSyntaxException;

public class Parser {
    public static Command parse(String input, TaskList taskList){
        if (input.equalsIgnoreCase("bye")){
            return new ExitCommand();
        }
        if (input.equalsIgnoreCase("list")) {
            return new ListCommand(taskList);
        }
        String[] splitCommand = input.split(" ", 2);
        String first = splitCommand[0];
        try {
            String rest = splitCommand[1];
            switch (first) {
            case "mark":
                return new MarkCommand(true, taskList, Integer.parseInt(rest));
            case "unmark":
                return new MarkCommand(false, taskList, Integer.parseInt(rest));
            case "todo":
                return new AddTodoCommand(taskList, splitCommand[1]);
            case "deadline":
                String[] split = rest.split("/by|\\(by:|\\)", 3);
                return new AddDeadlineCommand(taskList, split[0], split[1]);
            case "event":
                String[] firstSplit = rest.split("/from|\\(from:", 2);
                String[] secondSplit = firstSplit[1].split("/to|to:|\\)", 3);
                return new AddEventCommand(taskList, firstSplit[0], secondSplit[0], secondSplit[1]);
            case "delete":
                return new DeleteCommand(taskList, Integer.parseInt(rest));
            default:
                return new InvalidCommand();
            }
        } catch (IndexOutOfBoundsException e){
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
