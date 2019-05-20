package sample.Robot;

import javax.swing.*;
import java.awt.*;

public class paintRobot extends JPanel {
    private int width, height;
    private Main mainBoard = null;
    public paintRobot(int width, int height, Main mainBoard) {
        this.width = width;
        this.height = height;
        this.mainBoard = mainBoard;
    }
    public void paintComponent(Graphics g){

    }
    public void Init(){
        System.out.print("");
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
