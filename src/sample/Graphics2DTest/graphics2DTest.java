package sample.Graphics2DTest;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class graphics2DTest extends JPanel {
    int x = 100;
    int y = 100;
    public graphics2DTest(int width,int height){
        setLayout(null);
        setBounds(0,0,width,height);
        setBackground(Color.WHITE);
        setVisible(true);
    }
    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        Stroke s = new BasicStroke(3.0f);
        gg.setStroke(s);
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        gg.setColor(Color.BLACK);
        Line2D line = new Line2D.Double(30,50,100,200);
        gg.draw(line);
    }
    public void Init(){
        new paintThread().start();
    }

    private class paintThread extends Thread{
        @Override
        public void run(){
            while(true){
                repaint();
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    System.out.println(e.getMessage());
                    break;
                }
            }
        }
    }
}

