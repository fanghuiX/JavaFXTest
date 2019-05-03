package sample.HeapSort;

public class newThread extends Thread{
    public boolean running = true;
    public void run() {
        new Main(900, 1600);
    }
}
