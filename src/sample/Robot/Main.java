package sample.Robot;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    private int height, width;
    private static paintRobot paintrobot;
    private static JComponent now;
    public Main(int height, int width, int number, String string, String str) throws Exception{
        this.height = height;
        this.width = width;
        now = paintrobot;
        setTitle("喷漆机器人");
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

        paintrobot =new paintRobot(width,height,this,number,string);
        getContentPane().add(paintrobot);
        paintrobot.setVisible(true);
        setVisible(true);
        paintrobot.Init();
        //"2,4,5,1,3,6,7"
        paintrobot.fillColor(str);
    }
}
