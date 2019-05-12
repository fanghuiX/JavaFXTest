package sample.HeapSort;

public class newThread extends Thread{
    public static boolean running;
    public int num[];
    public boolean flag;
    public void run() {
        new Main(900, 1600, num,flag);
    }
}
