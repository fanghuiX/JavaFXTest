package sample.Graphics2DTest;

import javax.swing.*;
import java.awt.*;

public class GMain{
    public static void main(String[] args){
        graphicsTest graph = new graphicsTest();
        Graphics g = graph.getGraphics();
        graph.paint(g);
    }

}
