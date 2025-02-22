package mainstructure.savemanager;

import mainstructure.taskmanager.Deadline;
import mainstructure.taskmanager.Event;
import mainstructure.taskmanager.Task;
import mainstructure.taskmanager.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;


public class SaveManager {
    public static final String defaultPath = "./save/GeoTaskList.txt";

    public static void writeTextFile(String filePath, String text) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(text);
        fw.close();
    }

    public static void appendTextFile(String filePath, String appendText) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(appendText + '\n');
        fw.close();
    }

    public static ArrayList<Task> readSave(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        ArrayList<Task> list = new ArrayList<>();
        Scanner s = new Scanner(f);
        while (s.hasNext()){
            try {
                list.add(readTask(s.nextLine()));
            } catch (IllegalArgumentException ignored){
            }
        }
        return list;
    }

    private static Task readTask(String line) throws IllegalArgumentException{
        //System.out.println(line);
        String[] split = line.split("\\|");
        try {
            switch(split[0]){
            case "todo":
                return new Todo(split[2], Boolean.parseBoolean(split[1]));
            case "deadline":
                return new Deadline(split[2], split[3], Boolean.parseBoolean(split[1]));
            case "event":
                return new Event(split[2], split[3], split[4], Boolean.parseBoolean(split[1]));
            default:
                throw new IllegalArgumentException();
            }
        } catch(PatternSyntaxException | IndexOutOfBoundsException e){
            throw new IllegalArgumentException();
        }
    }

}
