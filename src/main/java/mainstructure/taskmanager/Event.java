package mainstructure.taskmanager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task{
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected String start;
    protected String end;

    public Event(String description, String startTime, String endTime){
        super(description);
        try {
            this.startDate = LocalDate.parse(startTime);
        } catch (DateTimeParseException e){
            this.start = startTime;
        }
        try {
            this.endDate = LocalDate.parse(endTime);
        } catch (DateTimeParseException e){
            this.end = endTime;
        }
    }

    public Event(String description, String startTime, String endTime, boolean isDone){
        super(description, isDone);
        try {
            this.startDate = LocalDate.parse(startTime);
        } catch (DateTimeParseException e){
            this.start = startTime;
        }
        try {
            this.endDate = LocalDate.parse(endTime);
        } catch (DateTimeParseException e){
            this.end = endTime;
        }
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (from: " +
                (startDate == null ? start : startDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"))) + " to: " +
                (endDate == null ? end : endDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"))) + ")";
    }

    @Override
    public String toSave(){
        return "event" + '|' + isDone + '|' + description + '|' +
                (startDate == null ? start : startDate) + '|' +
                (endDate == null ? end : endDate);
    }
}
