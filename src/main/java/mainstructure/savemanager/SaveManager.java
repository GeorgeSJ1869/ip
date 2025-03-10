package mainstructure.savemanager;

import mainstructure.taskmanager.Deadline;
import mainstructure.taskmanager.Event;
import mainstructure.taskmanager.Task;
import mainstructure.taskmanager.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Manages the saving of all task data in the hard drive.
 * <code>defaultPath</code> is the path where the save file is stored.
 */
public class SaveManager {
    public static final String defaultPath = "save/GeoTaskList.txt";

    /**
     * Writes a text file at <code>filePath</code> with the contents of <code>text</code>. Creates the directory if it does not exist
     * @param filePath the path where the file is stored.
     * @param text the content of the text file to be written. If null, creates a new empty file.
     * @throws IOException if the named file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason
     */
    public static void writeTextFile(String filePath, String text) throws IOException {
        Files.createDirectories(Paths.get("save"));
        if (text == null){
            new FileWriter(filePath, false).close();
        } else {
            FileWriter fw = new FileWriter(filePath);
            fw.write(text);
            fw.close();
        }
    }

    /**
     * Appends <code>appendText</code> to the file at <code>filePath</code>.
     * @param filePath the path of the file.
     * @param appendText the content to be appended.
     * @throws IOException if the named file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason
     */
    public static void appendTextFile(String filePath, String appendText) throws IOException {
        Files.createDirectories(Paths.get("save"));
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(appendText + '\n');
        fw.close();
    }

    /**
     * Reads the saved tasks data from the file at <code>filePath</code>.
     * @param filePath the path of the file.
     * @return an ArrayList of Task.
     * @throws FileNotFoundException when the file is not found.
     */
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

    /**
     * Reads one line of text and parses out each information of the task.
     * @param line the line of text to be read.
     * @return a subclass of <code>Task</code> based on the information of the text.
     * @throws IllegalArgumentException when unable to parse valid task information.
     */
    private static Task readTask(String line) throws IllegalArgumentException{
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
