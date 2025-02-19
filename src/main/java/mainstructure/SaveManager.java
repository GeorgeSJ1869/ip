package mainstructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import mainstructure.taskmanager.TaskList;

public class SaveManager {
    public static final String defaultPath = "'/";

    public static void writeTextFile(String filePath, String text) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(text);
        fw.close();
    }

    public static void appendTextFile(String filePath, String appendText) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write('\n' + appendText);
        fw.close();
    }

    public static String readFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        StringBuilder content = new StringBuilder();
        while (s.hasNext()){
            content.append(s.nextLine());
        }
        return content.toString();
    }
}
