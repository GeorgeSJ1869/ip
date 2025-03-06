import java.util.Scanner;

public class GeoLevelOneArchive {
    public static void notMain(String[] args) {
        String logo = "Geo";
        String UIHorizontalLine = "____________________________________________________________";
        System.out.println(UIHorizontalLine);
        System.out.println("Hello from " + logo);
        System.out.println("What can I do for you?");
        System.out.println(UIHorizontalLine);
        Scanner scanner = new Scanner(System.in);

        while (true){
            String text = scanner.nextLine();
            if (text.equalsIgnoreCase("bye")){
                exit();
            } else {
                System.out.println(UIHorizontalLine);
                System.out.println(text);
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
