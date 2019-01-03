package sample.Graphics2DTest;

import java.awt.*;
import java.applet.*;

public class graphicsTest extends Applet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    int i = 0;
    int j = 0;
    public void init(){
        setBackground(Color.GRAY);
        setSize(400,400);
    }

    public void paint(Graphics g){
        i = i+30;
        j = j+30;
        if(i > 200)
            stop();
        g.setColor(Color.RED);
        g.drawOval(i, j, 20, 20);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){}
        g.drawLine(i+20, j+20, i+30, j+30);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){}
        repaint();
    }

    public void update(Graphics g){
        //g.clearRect(i,20,30,40);
        paint(g);
    }
}
