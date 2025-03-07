package mainstructure.taskmanager;

import mainstructure.parser.DateParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The <code>Task</code> that has a deadline.
 */
public class Deadline extends Task{
    protected String end;
    protected LocalDate endDate;

    /**
     * Instantiate a <code>Deadline</code> task which is undone by default.
     * @param description the description of the task.
     * @param deadline the deadline of the task.
     */
    public Deadline(String description, String deadline){
        super(description);
        try {
            this.endDate = DateParser.parse(deadline);
        } catch (DateTimeParseException e){
            this.end = deadline;
        }
    }

    /**
     * Instantiate a <code>Deadline</code> task which is done or not done.
     * @param description the description of the task.
     * @param deadline the deadline of the task.
     * @param isDone whether the task is done or not done.
     */
    public Deadline(String description, String deadline, boolean isDone){
        super(description, isDone);
        try {
            this.endDate = DateParser.parse(deadline);
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
