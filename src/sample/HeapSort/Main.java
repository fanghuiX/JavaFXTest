package sample.HeapSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame{
    private int height, width;
    private static HeapSort heapSort;
    private static JComponent nowSorting;

    public Main(int height, int width) {
        this.height = height;
        this.width = width;
        nowSorting = heapSort;
        setTitle("堆排序");
        //得到屏幕大小
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screensize.width;
        int screenHeight = screensize.height;
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //只关闭当前窗口
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);
        setLayout(null);

        heapSort =new HeapSort(width,height,this);
        getContentPane().add(heapSort);
        heapSort.setVisible(true);
        setVisible(true);
        heapSort.Init();
        heapSort.sort();
    }
    /*public static void main(String[] args) {
        new Main(900, 1600);
    }*/
}
