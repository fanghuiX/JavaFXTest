package sample.Robot;

import javax.swing.*;
import java.awt.*;

public class paintRobot extends JPanel {

    private int width, height;
    private Main mainBoard = null;
    private int number;
    private String string;
    private Rectangle[] rect;
    private int times;
    private int[][] block;
    private String take = "准备拿起喷枪";
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
        Stroke s = gg.getStroke();
        for(int i=0;i<number;i++){
            rect[i].paintRect(gg);
            gg.setStroke(new BasicStroke(3.0f));
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gg.setColor(Color.black);
            Font font1 = new Font("微软雅黑", Font.PLAIN, 20);
            g.setFont(font1);
            gg.drawString(block[i][4]+"",block[i][0]*50+60,block[i][1]*50+50);
        }

        gg.setStroke(new BasicStroke(3.0f));
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gg.setColor(Color.BLACK);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 15);
        g.setFont(font1);
        gg.drawString(take,50,height-95);
        Font font2 = new Font("微软雅黑", Font.PLAIN, 20);
        g.setFont(font2);
        gg.drawString("拿起喷枪次数："+times,50,height-60);
        gg.setStroke(s);
    }
    public void Init(){
        //System.out.println(number);
        //System.out.println(string);
        String[] str = string.split(",");
        block = new int[number][5];
        rect = new Rectangle[number];
        for(int i=0;i<block.length;i++){
            for(int j=0;j<block[0].length;j++){
                block[i][j] = Integer.parseInt(str[i*5+j]);
            }
            rect[i] = new Rectangle(block[i][0],block[i][1],block[i][2],block[i][3],8);
        }
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
                //System.out.print(block[i][j]+" ");
            }
        }
        for(int i=0;i<block.length;i++){
            //drawRect(int x, int y, int width, int height)
            g.drawRect(block[i][1],block[i][0],block[i][3]*20,block[i][2]*20);
        }
        //System.out.println("hi");
    }

    public void fillColor(String str) throws Exception{
        String[] order = str.split(",");
        times = 1;
        for(int i=0;i<order.length;i++){
            int j = Integer.parseInt(order[i]);
            rect[j].setCOLOR(block[j][4]);
            take = "拿起颜色为 "+block[j][4]+" 的喷枪";
            if(i>=1){
                if(block[j][4] != block[Integer.parseInt(order[i-1])][4]){
                    times++;
                }
            }
            Thread.sleep(1300);
        }
        take = "喷漆结束！";
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
