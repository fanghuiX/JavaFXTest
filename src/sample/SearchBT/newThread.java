package sample.SearchBT;

public class newThread extends Thread{
    public boolean running = true;
    public int num[];
    public void run() {
        new Main(768, 1366);
    }
}
