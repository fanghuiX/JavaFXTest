package sample.HeapSort;

import java.awt.*;

public class HeapNode {//用于堆排序的数据展示，为圆形节点样式
    private int x,y;//代表坐标
    private int colorInner=WHITE;//节点内部的颜色
    private int colorOut=BLACK;//节点外部的颜色
    private int colorV=BLACK;//节点的值的颜色
    private int value; //代表值
    public static final int YELLOW=1;//预先设置的常量，用于绘制时的颜色判断
    public static final int RED=2;
    public static final int BLUE=3;
    public static final int GREEN=4;
    public static final int BLACK=5;
    public static final int GLASSGREEN=6;
    public static final int YELLOW2=7;
    public static final int WHITE=8;
    public HeapNode(){}
    public HeapNode(int x,int y,int value){
        this.x=x;
        this.value=value;
        this.y=y;
    }
    public void paintNode(Graphics2D g){
        Stroke s = g.getStroke();
        switch (colorOut) {
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
        g.fillOval(x,y,50,50);

        switch (colorInner) {
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
        g.fillOval(x+3,y+3,44,44);

        switch (colorV) {
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
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        g.setFont(font1);
        if (value==100){
            g.drawString(value+"",x+8,y+32);
        }
        else if(value-10<0)g.drawString(value+"",x+18,y+32);
        else {
            g.drawString(value+"",x+15,y+31);
        }

    }
    public void move(int moveX,int moveY,int time){
        int disX = (moveX-this.x)/time;
        int disY = (moveY-this.y)/time;
        int xc = Math.abs(moveX-this.x-disX*time);
        int yc = Math.abs(moveY-this.y-disY*time);
        for(int i=0;i<time;i++){
            if(xc-->0){
                if (x<moveX)x++;
                else x--;
            }
            if(yc-->0){
                if (y<moveY)y++;
                else y--;
            }
            x+=disX;
            y+=disY;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.x=moveX;
        this.y=moveY;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setColorInner(int colorInner) {
        this.colorInner = colorInner;
    }

    public void setColorV(int colorV) {
        this.colorV = colorV;
    }

    public void setColorOut(int colorOut) {
        this.colorOut = colorOut;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
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
}


