package taskmanager;

public class Event extends Task{
    protected String start;
    protected String end;

    public Event(String description, String startTime, String endTime){
        super(description);
        this.start = startTime;
        this.end = endTime;
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }
}
