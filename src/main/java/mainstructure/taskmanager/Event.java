package mainstructure.taskmanager;

/**
 * The <code>Task</code> that has a start time and an end time.
 */
public class Event extends Task{
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
        this.start = startTime;
        this.end = endTime;
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
        this.start = startTime;
        this.end = endTime;
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }

    @Override
    public String toSave(){
        return ("todo" + '|' + isDone + '|' + description + '|' + start + '|' + end);
    }
}
