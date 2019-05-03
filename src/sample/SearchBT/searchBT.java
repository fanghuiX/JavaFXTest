package sample.SearchBT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class searchBT  extends JPanel {
    private static int N = 15;
    private int width, height;
    private Main mainBoard = null;
    private JTextField jTextField;
    private JButton jButton, tip;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int lx1[]={700,700,400,400,1000,1000,250,250,550,550,850,850,1150,1150};
    private int lx2[]={400,1000,250,550,850,1150,150,350,450,650,750,950,1050,1250};
    private int ly1[]={100,100,200,200,200,200,300,300,300,300,300,300,300,300};
    private int ly2[]={200,200,300,300,300,300,400,400,400,400,400,400,400,400};
    private HeapNode heapNode[]=new HeapNode[N];
    //
    public searchBT(int width, int height, Main mainBoard) {
        this.width = width;
        this.height = height;
        this.mainBoard = mainBoard;
        setLayout(null);
        setBounds(0, 0, width, height);
        setBackground(Color.white);

        setVisible(false);
        setFocusable(true);
        //add文本框
        jTextField = new JTextField(10);
        jTextField.setBounds(500, 650, 200, 40);
        this.add(jTextField);
        //添加按钮
        jButton = new JButton("插入");
        jButton.setBounds(720,650, 100,40);
        jButton.setContentAreaFilled(false);
        this.add(jButton);
        //响应插入
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("insert "+jTextField.getText());
            }
        });
        tip = new JButton("?");
        tip.setBounds(830,650, 50,40);
        tip.setContentAreaFilled(false);
        this.add(tip);
        //响应插入
        tip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("tip");
                JOptionPane.showMessageDialog(null, "篇幅限制，请确保插入节点使得树的深度不超过4", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("printComponent "+jTextField.getText());
        Graphics2D gg = (Graphics2D) g;
        for(int i=0;i<N-1;i++){
            Stroke s = gg.getStroke();
            gg.setStroke(new BasicStroke(3.0f));
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            gg.setColor(Color.BLACK);
            gg.drawLine(lx1[i]+20,ly1[i]+20,lx2[i]+20,ly2[i]+20);
            gg.setStroke(s);
        }
        for(int i =0;i<N;i++){
            heapNode[i].paintNode(gg);
        }
    }
    //开始重绘
    public void Init() {
        initHeapNode();
        for(int i=0;i<N;i++) {
            int num = (int) (Math.random() * 100)+1;
            heapNode[i].setValue(num);
        }
        new paintThread().start();
    }

    public void initHeapNode() {
        heapNode[0]=new HeapNode(700,100,0);
        heapNode[1]=new HeapNode(400,200,0);
        heapNode[2]=new HeapNode(1000,200,0);
        heapNode[3]=new HeapNode(250,300,0);
        heapNode[4]=new HeapNode(550,300,0);
        heapNode[5]=new HeapNode(850,300,0);
        heapNode[6]=new HeapNode(1150,300,0);
        heapNode[7]=new HeapNode(150,400,0);
        heapNode[8]=new HeapNode(350,400,0);
        heapNode[9]=new HeapNode(450,400,0);
        heapNode[10]=new HeapNode(650,400,0);
        heapNode[11]=new HeapNode(750,400,0);
        heapNode[12]=new HeapNode(950,400,0);
        heapNode[13]=new HeapNode(1050,400,0);
        heapNode[14]=new HeapNode(1250,400,0);
    }
    //插入节点
    public void insert() {
        System.out.println("start insert");
        while(true) {
            //TODO
        }
    }
    //绘制
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
