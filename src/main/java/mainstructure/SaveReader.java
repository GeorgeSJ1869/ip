package mainstructure;

import mainstructure.taskmanager.*;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

public class SaveReader {

    public static ArrayList<TaskInfo> readSave(String content){
        System.out.println("Reading save");
        ArrayList<TaskInfo> list = new ArrayList<>();
        String[] lines = content.split("\n");
        for (String line : lines){
            list.add(readTask(line));
        }
        return list;
    }

    private static TaskInfo readTask(String line){
        char type = line.charAt(1);
        //char status = line.charAt(3);
        try {
            switch(type){
            case 'T':
                return new TaskInfo("todo", ' ', line.substring(6).trim());
            case 'D':
                return new TaskInfo("deadline", ' ', line.substring(6).trim());
            case 'E':
                return new TaskInfo("event", ' ', line.substring(6).trim());
            default:
                return null;
            }
        } catch(PatternSyntaxException | IndexOutOfBoundsException e){
            return null;
        }
    }
}
