public class UI {
    protected String horizontalLine;

    public UI(){
        horizontalLine = "____________________________________________________________\n";
    }

    public void print(String content){
        System.out.print(horizontalLine + content + horizontalLine);
    }
}
