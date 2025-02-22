package mainstructure.taskmanager;

public class Deadline extends Task{
    protected String end;

    public Deadline(String description, String deadline){
        super(description);
        this.end = deadline;
    }

    public Deadline(String description, String deadline, boolean isDone){
        super(description, isDone);
        this.end = deadline;
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + end + ")";
    }

    @Override
    public String toSave(){
        return ("todo" + '|' + isDone + '|' + description + '|' + end);
    }
}
