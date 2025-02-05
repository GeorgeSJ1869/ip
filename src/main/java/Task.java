public class Task {
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String toString(){
        return (isDone ? "[X] " : "[ ] ") + description;
    }

    public void mark(boolean status){
        isDone = status;
    }
}
