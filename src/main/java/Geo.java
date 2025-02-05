import java.util.Scanner;

public class Geo {
    public static void main(String[] args) {
        String logo = "Geo";
        UI UI = new UI();
        Scanner scanner = new Scanner(System.in);

        //Welcome
        UI.print("Hello from " + logo + '\n' + "What can I do for you?\n");

        TaskList taskList = new TaskList();

        while(true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                exit();
            } else if (input.equalsIgnoreCase("list")) {
                UI.print(taskList.showFullList());
            } else {
                String[] splitBySpace = input.split(" ");
                String firstWord = splitBySpace[0];
                switch (firstWord) {
                case "mark" -> {
                    if (splitBySpace.length < 2) {
                        UI.print("""
                                You need to specify which task to be marked undone!
                                Format: mark X
                                """);
                    } else {
                        int index = Integer.parseInt(input.substring(5));
                        if (index <= 0 || index > taskList.getTaskCount()) {
                            UI.print("Invalid task index\n");
                        } else {
                            taskList.mark(index, true);
                            UI.print(
                                    "Nice! I've marked this task as done:\n"
                                            + taskList.showTask(index) + '\n');
                        }
                    }
                }
                case "unmark" -> {
                    if (splitBySpace.length < 2) {
                        UI.print("""
                                You need to specify which task to be marked undone!
                                Format: unmark X
                                """);
                    } else {
                        int index = Integer.parseInt(input.substring(7));
                        if (index <= 0 || index > taskList.getTaskCount()) {
                            UI.print("Invalid task index\n");
                        } else {
                            taskList.mark(index, false);
                            UI.print("OK, I've marked this task as not done yet:\n"
                                    + taskList.showTask(index) + '\n');
                        }
                    }
                }
                case "todo" -> {
                    if (splitBySpace.length < 2) {
                        UI.print("""
                                You need to specify the task name!
                                Format: todo [task name]
                                """);
                    } else {
                        taskList.addTask(input.substring(5));
                        UI.print("Got it. I've added this task:\n"
                                + taskList.showTask(taskList.getTaskCount()) + '\n'
                                + "Now you have " + taskList.getTaskCount() + " tasks in the list\n");
                    }
                }
                case "deadline" -> {
                    String[] split = input.substring(8).split("/by", 2);
                    if (split.length < 2) {
                        UI.print("""
                                You need to specify the deadline!
                                Format: deadline [task name] /by [deadline]
                                """);
                    } else {
                        taskList.addTask(split[0].trim(), split[1].trim());
                        UI.print("Got it. I've added this task:\n"
                                + taskList.showTask(taskList.getTaskCount()) + '\n'
                                + "Now you have " + taskList.getTaskCount() + " tasks in the list\n");
                    }
                }
                case "event" -> {
                    String[] split = input.substring(5).split("/from | /to", 3);
                    if (split.length < 3) {
                        UI.print("""
                                You need to specify the start and end date of the event!
                                Format: event [task name] /from [start time] /to [end time]
                                """);
                    } else {
                        taskList.addTask(split[0].trim(), split[1].trim(), split[2].trim());
                        UI.print("Got it. I've added this task:\n"
                                + taskList.showTask(taskList.getTaskCount()) + '\n'
                                + "Now you have " + taskList.getTaskCount() + " tasks in the list\n");
                    }
                }
                default -> {
                    taskList.addTask(input);
                    UI.print("Got it. I've added this task:\n"
                            + taskList.showTask(taskList.getTaskCount()) + '\n'
                            + "Now you have " + taskList.getTaskCount() + " tasks in the list\n");
                }
                }
            }
        }
    }

    //Exit
    public static void exit(){
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
        System.exit(0);
    }
}
