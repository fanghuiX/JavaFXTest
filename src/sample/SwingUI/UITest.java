package sample.SwingUI;

import sample.GraphViz.CreateGraph;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UITest extends JFrame implements  ActionListener, KeyListener {
    public static void main(String[] args){
        UITest ui = new UITest();
        ui.setTitle("TEST");
        ui.setBounds(100, 100, 800, 600);
    }
    public static Button b1,b2,b3,b4;
    public static TextField tf1,tf2,tf3,tf4;
    public static TextArea ta;
    public static JLabel jl;
    public UITest(){
        setLayout(new FlowLayout());
        tf1 = new TextField(93);
        add(tf1);
        b1 = new Button(" CommonTree");
        add(b1);
        tf2 = new TextField(93);
        add(tf2);
        b2 = new Button("    BinaryTree   ");
        add(b2);
        tf3 = new TextField(93);
        add(tf3);
        b3 = new Button("  SearchBTree ");
        add(b3);
        tf4 = new TextField(93);
        add(tf4);
        b4 = new Button("        forest         ");
        add(b4);
        jl = new JLabel("");
        add(jl);
		/*ta = new TextArea(15,65);
		add(ta);*/
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(b1)){
            String str = tf1.getText();
            CreateGraph mt = new CreateGraph();
            mt.choice(1, str);
            mt.start(mt.nodes, mt.bt);
            //JLabel展示本地图片
            jl.setText("<html><img src='file:///C:/Users/fanghui/Desktop/GraphTest/out.gif'/></html>");
            SwingUtilities.updateComponentTreeUI (this);
        }
        else if(e.getSource().equals(b2)){
            String str = tf2.getText();
            CreateGraph mt = new CreateGraph();
            mt.choice(2, str);
            mt.start(mt.nodes, mt.bt);
            //JLabel展示本地图片
            jl.setText("<html><img src='file:///C:/Users/fanghui/Desktop/GraphTest/out.gif'/></html>");
            //刷新JLabel
            SwingUtilities.updateComponentTreeUI (this);
        }
        else if(e.getSource().equals(b3)){
            String str = tf3.getText();
            CreateGraph mt = new CreateGraph();
            mt.choice(3, str);
            mt.start(mt.nodes, mt.bt);
            //JLabel展示本地图片
            jl.setText("<html><img src='file:///C:/Users/fanghui/Desktop/GraphTest/out.gif'/></html>");
            SwingUtilities.updateComponentTreeUI (this);
        }
        else if(e.getSource().equals(b4)){
            String str = tf4.getText();
            CreateGraph mt = new CreateGraph();
            mt.choice(4, str);
            mt.start(mt.nodes, mt.bt);
            //JLabel展示本地图片
            jl.setText("<html><img src='file:///C:/Users/fanghui/Desktop/GraphTest/out.gif'/></html>");
            SwingUtilities.updateComponentTreeUI (this);
        }
    }

    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode()==KeyEvent.VK_ENTER){

        }
    }

    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
}

