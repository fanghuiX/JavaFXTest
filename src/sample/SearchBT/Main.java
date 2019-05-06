package sample.SearchBT;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    private int height, width;
    private static searchBT searchbt;
    private static JComponent nowSorting;
    public Main(int height, int width) {
        this.height = height;
        this.width = width;
        nowSorting = searchbt;
        setTitle("二叉排序树");
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

        searchbt =new searchBT(width,height,this);
        getContentPane().add(searchbt);
        searchbt.setVisible(true);
        setVisible(true);
        searchbt.Init();
        searchbt.insert();
    }
    /*public static void main(String[] args) {
        new Main(768, 1366);
    }*/
}
