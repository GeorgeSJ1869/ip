import java.util.Scanner;

public class Geo {
    public static void main(String[] args) {
        String logo = "Geo";
        String UIHorizontalLine = "____________________________________________________________";
        Scanner scanner = new Scanner(System.in);

        //Welcome
        System.out.println(UIHorizontalLine);
        System.out.println("Hello from " + logo);
        System.out.println("What can I do for you?");
        System.out.println(UIHorizontalLine);

        TaskList taskList = new TaskList();

        //Echo
        while(true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                exit();
            }
            else if (input.equals("list")) {
                System.out.println(UIHorizontalLine);
                System.out.print(taskList.showFullList());
                System.out.println(UIHorizontalLine);
            }
            else if(input.matches("mark +\\d+")){
                String[] parts = input.split(" ");
                int index = Integer.parseInt(parts[1]);
                taskList.markDone(index);
                System.out.println(UIHorizontalLine);
                if (index <= 0 || index > taskList.getTaskCount()){
                    System.out.println("Invalid task index");
                }
                else{
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(taskList.showTask(index));
                }
                System.out.println(UIHorizontalLine);
            }
            else if(input.matches("unmark +\\d+")){
                String[] parts = input.split(" ");
                int index = Integer.parseInt(parts[1]);
                taskList.markUndone(index);
                System.out.println(UIHorizontalLine);
                if (index <= 0 || index > taskList.getTaskCount()){
                    System.out.println("Invalid task index");
                }
                else{
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(taskList.showTask(index));
                }
                System.out.println(UIHorizontalLine);
            }
            else{
                taskList.addTask(input);
                System.out.println(UIHorizontalLine);
                System.out.println("added: " + input);
                System.out.println(UIHorizontalLine);
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
