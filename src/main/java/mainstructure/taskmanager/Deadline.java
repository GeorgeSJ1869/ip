package mainstructure.taskmanager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task{
    protected String end;
    protected LocalDate endDate;

    public Deadline(String description, String deadline){
        super(description);
        try {
            this.endDate = LocalDate.parse(deadline);
        } catch (DateTimeParseException e){
            this.end = deadline;
        }
    }

    public Deadline(String description, String deadline, boolean isDone){
        super(description, isDone);
        try {
            this.endDate = LocalDate.parse(deadline);
        } catch (DateTimeParseException e){
            this.end = deadline;
        }
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + (endDate == null ? end : endDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"))) + ")";
    }

    @Override
    public String toSave(){
        return "deadline" + '|' + isDone + '|' + description + '|' + (endDate == null ? end : endDate);
    }
}
