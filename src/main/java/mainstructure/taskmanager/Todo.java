package mainstructure.taskmanager;

public class Todo extends Task{
    public Todo(String description){
        super(description);
    }

    public Todo(String description, boolean isDone){
        super(description, isDone);
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }

    @Override
    public String toSave(){
        return ("todo" + '|' + isDone + '|' + description);
    }
}
