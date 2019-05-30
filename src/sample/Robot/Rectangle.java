package sample.Robot;

import java.awt.*;

public class Rectangle {
    private int x1,y1;
    private int x2,y2;
    private int COLOR = YELLOW;
    private int W = 50;

    public static final int YELLOW=1;//预先设置的常量，用于绘制时的颜色判断
    public static final int RED=2;
    public static final int BLUE=3;
    public static final int GREEN=4;
    public static final int BLACK=5;
    public static final int GLASSGREEN=6;
    public static final int YELLOW2=7;
    public static final int WHITE=8;

    public Rectangle(){}
    public Rectangle(int x1,int y1,int x2,int y2,int COLOR){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.COLOR = COLOR;
    }

    public void paintRect(Graphics2D g){
        Stroke s = g.getStroke();
        g.setStroke(new BasicStroke(3.0f));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.black);
        g.drawRect(x1*W+50,y1*W+20,(x2-x1)*W,(y2-y1)*W);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(COLOR),x1*W+60,y1*W+70);
        g.setStroke(s);
        switch (COLOR) {
            case YELLOW:
                g.setColor(Color.yellow);
                break;
            case RED:
                g.setColor(Color.red);
                break;
            case BLUE:
                g.setColor(Color.cyan);
                break;
            case BLACK:
                g.setColor(Color.BLACK);
                break;
            case GREEN:
                g.setColor(Color.GREEN);
                break;
            case GLASSGREEN:
                g.setColor(new Color(82,188,105));
                break;
            case YELLOW2:
                g.setColor(new Color(254,197,21));
                break;
            case WHITE:
                g.setColor(Color.white);
                break;
        }
        g.setStroke(s);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillRect(x1*W+50,y1*W+20,(x2-x1)*W,(y2-y1)*W);
        //g.fillOval(x+3,y+3,44,44);
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setCOLOR(int COLOR) {
        this.COLOR = COLOR;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getCOLOR() {
        return COLOR;
    }


}
