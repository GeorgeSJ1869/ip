package mainstructure;

/**
 * Manages the output of information to the user through CLI.
 */
public class UI {
    private static final String horizontalLine = "____________________________________________________________\n";

    /**
     * Print the content to the user, separated by horizontal lines.
     * @param content the content to be printed.
     */
    public static void print(String content){
        if (content.isEmpty()){
            return;
        }
        if (content.charAt(content.length() - 1) != '\n'){
            content += "\n";
        }
        System.out.print(horizontalLine + content + horizontalLine + "You:");
    }

    /**
     * Print the message when a <code>Task</code> is added to the <code>taskList</code>.
     * @param task the description of the <code>Task</code>.
     * @param count the total number of tasks in <code>TaskList</code>.
     */
    public static void printAddTaskMessage(String task, int count){
        print("Task added:\n"
                + task + "\n"
                + "Task count now: " + count + '\n');
    }

    /**
     * Prints the list of all possible commands and user guides.
     */
    public static void printTaskWiki(){
        print("""
                Here are some commands that might be useful to you:
                
                "bye": Close this application
                "list": View the list of all tasks
                "todo [task name]": Add a task named [task name]
                "deadline [task name] /by [deadline]": Add a task with a specific deadline. Time should be YYYY-MM-DD format.
                "event [task name] /from [start time] /to [end time]": Add a task with specific start and end times. Time should be YYYY-MM-DD format.
                "delete X": Delete the Xth task from the list.
                "mark X": Mark the Xth task in the list as done
                "unmark X": Mark the Xth task in the list as undone
                "find [keyword]": View the list of all tasks that contains the [keyword] in the description.
                
                """);
    }
}
