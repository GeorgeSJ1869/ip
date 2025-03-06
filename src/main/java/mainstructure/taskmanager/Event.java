package mainstructure.taskmanager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The <code>Task</code> that has a start time and an end time.
 */
public class Event extends Task{
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected String start;
    protected String end;

    /**
     * Instantiate an <code>Event</code> which is undone by default.
     * @param description the description of the event.
     * @param startTime the starting time of the event.
     * @param endTime the ending time of the event.
     */
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

    /**
     * Instantiate an <code>Event</code> which is done or not done.
     * @param description the description of the event.
     * @param startTime the starting time of the event.
     * @param endTime the ending time of the event.
     * @param isDone whether the task is marked done or undone.
     */
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
