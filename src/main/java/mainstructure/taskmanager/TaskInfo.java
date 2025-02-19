package mainstructure.taskmanager;

public class TaskInfo {
    protected String type;
    protected char status;
    protected String info;

    public TaskInfo(String t, char s, String info) {
        this.type = t;
        this.status = s;
        this.info = info;
    }

    public char getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }
}
