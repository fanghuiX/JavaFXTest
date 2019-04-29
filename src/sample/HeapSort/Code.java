package sample.HeapSort;

import java.awt.*;

public class Code {
    private int height,width,x,y;
    private int color;
    private String str;
    public static final int YELLOW=1;
    public static final int RED=2;
    public static final int BLUE=3;
    public static final int GREEN=4;
    public static final int BLACK=5;
    public static final int GLASSGREEN=6;
    public static final int YELLOW2=7;
    public Code(){}
    public Code(int x,int y,int width,int height,String str){
        this.x=x;
        this.str=str;
        this.width=width;
        this.height=height;
        this.y=y;
        this.color=GLASSGREEN;
    }
    public void paintBar(Graphics2D g){
        Stroke s = g.getStroke();
        switch (color) {
            case YELLOW:
                g.setColor(Color.yellow);
                break;
            case RED:
                g.setColor(Color.red);
                break;
            case BLUE:
                g.setColor(new Color(75, 101, 186));
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
        }
        g.fillRect(x,y,width,height);
        g.setStroke(s);

        g.setColor(Color.WHITE);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Font font1 = new Font("微软雅黑", Font.BOLD, 20);
        g.setFont(font1);
        g.drawString(str,x+35,y+20);
    }
    public void setHeight(int height){
        this.height=height;
    }
    public void setColor(int color){
        this.color=color;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

