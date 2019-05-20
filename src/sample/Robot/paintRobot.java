package sample.Robot;

import javax.swing.*;
import java.awt.*;

public class paintRobot extends JPanel {

    private int width, height;
    private Main mainBoard = null;
    private int number;
    private String string;
    public paintRobot(int width, int height, Main mainBoard, int number, String string) {
        this.width = width;
        this.height = height;
        this.mainBoard = mainBoard;
        this.number = number;
        this.string = string;
        setLayout(null);
        setBounds(0, 0, width, height);
        setBackground(Color.white);

        setVisible(false);
        setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        String[] str = string.split(",");
        int block[][] = new int[number][5];
        for(int i=0;i<block.length;i++){
            for(int j=0;j<block[0].length;j++){
                block[i][j] = Integer.parseInt(str[i*5+j]);
            }
        }
        int w = 50;
        for(int i=0;i<block.length;i++){
            Stroke s = gg.getStroke();
            gg.setStroke(new BasicStroke(3.0f));
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gg.setColor(Color.BLACK);
            gg.drawRect(block[i][1]*w+50,block[i][0]*w+50,(block[i][3]-block[i][1])*w,(block[i][2]-block[i][0])*w);
            gg.drawString(block[i][4]+"",block[i][1]*w+60,block[i][0]*w+70);
            gg.setStroke(s);
        }
    }
    public void Init(){
        System.out.println(number);
        System.out.println(string);
        new paintThread().start();
    }

    public void paintRect(Graphics2D g){
        System.out.println(number);
        System.out.println(string);
        String[] str = string.split(",");
        int block[][] = new int[number][5];
        for(int i=0;i<block.length;i++){
            for(int j=0;j<block[0].length;j++){
                block[i][j] = Integer.parseInt(str[i*5+j]);
                System.out.print(block[i][j]+" ");
            }
        }
        for(int i=0;i<block.length;i++){
            //drawRect(int x, int y, int width, int height)
            g.drawRect(block[i][1],block[i][0],block[i][3]*20,block[i][2]*20);
        }
        System.out.println("hi");
    }

    private class paintThread extends Thread {
        @Override
        public void run() {
            while(true){
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
