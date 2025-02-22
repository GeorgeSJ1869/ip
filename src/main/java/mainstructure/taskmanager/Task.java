package mainstructure.taskmanager;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone){
        this.description = description;
        this.isDone = isDone;
    }

    public String toString(){
        return (isDone ? "[X] " : "[ ] ") + description;
    }

    public String toSave(){
        return "Error occurred in saving process";
    }

    public void mark(boolean status){
        isDone = status;
    }
}
