public class UI {
    private static final String horizontalLine = "____________________________________________________________\n";

    public static void print(String content){
        System.out.print(horizontalLine + content + horizontalLine + "You:");
    }

    public static void printAddTaskMessage(String task, int count){
        print("Task added:\n"
                + task + "\n"
                + "Task count now: " + count + '\n');
    }

    public static void printTaskWiki(){
        print("""
                Here are some commands that might be useful to you:
                
                "bye": Close this application
                "list": View the list of all tasks
                "todo [task name]": Add a task named [task name]
                "deadline [task name] /by [deadline]": Add a task with a specific deadline
                "event [task name] /from [start time] /to [end time]": Add a task with specific start and end times.
                "mark X": Mark the Xth task in the list as done
                "unmark X": Mark the Xth task in the list as undone
                
                """);
    }
}
