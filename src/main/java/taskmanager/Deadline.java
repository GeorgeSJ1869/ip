package taskmanager;

public class Deadline extends Task{
    protected String end;

    public Deadline(String description, String deadline){
        super(description);
        this.end = deadline;
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + end + ")";
    }
}
