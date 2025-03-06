import java.util.Scanner;

public class GeoLevelTwoArchive {
    public static void main(String[] args) {
        String logo = "Geo";
        String UIHorizontalLine = "____________________________________________________________";
        System.out.println(UIHorizontalLine);
        System.out.println("Hello from " + logo);
        System.out.println("What can I do for you?");
        System.out.println(UIHorizontalLine);
        Scanner sc = new Scanner(System.in);

        String[] list = new String[100];
        int count = 0;

        while (true){
            String input = sc.nextLine();
            switch (input){
            case "bye":
                exit();
            case "list":
                print(listAll(count, list));
                break;
            default:
                list[count] = input;
                count++;
                print("added: " + input);
            }
        }
    }

    //Exit
    public static void exit() {
        print("Bye. Hope to see you again soon!");
        System.exit(0);
    }

    public static String listAll(int count, String[] list) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < count; i++) {
            output.append(i + 1).append(". ").append(list[i]).append('\n');
        }
        return output.toString();
    }

    public static void print(String content) {
        String UIHorizontalLine = "____________________________________________________________";
        System.out.println(UIHorizontalLine);
        System.out.println(content);
        System.out.println(UIHorizontalLine);
    }
}
