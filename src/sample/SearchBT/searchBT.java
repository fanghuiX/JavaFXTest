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
    private JTextField jTextField, deleteText;
    private JButton jButton, deleteButton, randButton, clearButton, tip;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int lx1[]={700,700,400,400,1000,1000,250,250,550,550,850,850,1150,1150};
    private int lx2[]={400,1000,250,550,850,1150,150,350,450,650,750,950,1050,1250};
    private int ly1[]={100,100,200,200,200,200,300,300,300,300,300,300,300,300};
    private int ly2[]={200,200,300,300,300,300,400,400,400,400,400,400,400,400};
    private HeapNode heapNode[]=new HeapNode[15];
    private int num[] = {30,20,50,10,23,-999,80,-999,12,-999,-999,-999,-999,70,-999};
    StringBuffer sb = new StringBuffer();
    public static boolean isrand = false;
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
        jTextField.setBounds(500, 500, 200, 40);
        this.add(jTextField);
        deleteText = new JTextField(10);
        deleteText.setBounds(500, 550, 200, 40);
        this.add(deleteText);
        //添加插入按钮
        jButton = new JButton("插入");
        jButton.setBounds(720,500, 100,40);
        jButton.setContentAreaFilled(false);
        this.add(jButton);
        //响应插入
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "请输入数据！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    boolean isexist = false;
                    if(isrand){
                        sb = new StringBuffer(",");
                        isrand = false;
                    }
                    String[] str = sb.toString().split(",");
                    for(int i=0;i<str.length;i++){
                        if(str[i].equals(jTextField.getText())){
                            isexist = true;
                            break;
                        }
                    }
                    if(isexist){
                        JOptionPane.showMessageDialog(null, "树中已经存在数据 "+jTextField.getText(), "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        System.out.println("insert " + jTextField.getText());
                        if(sb.toString().equals(",")){
                            sb = new StringBuffer("");
                        }
                        sb.append(jTextField.getText()+",");
                        //System.out.println(sb.toString());
                        int flag = 0;
                        int mid[] = new dataProcess().getData(sb.toString());
                        for(int i=0;i<num.length;i++){
                            if(num[i] == mid[i]){
                                flag++;
                            }
                            else{
                                num[i] = mid[i];
                            }
                        }
                        if(flag == 15){
                            JOptionPane.showMessageDialog(null, "树的深度超过了 4 ！", "提示", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            Init();
                        }
                    }
                }
            }
        });
        //添加删除按钮
        deleteButton = new JButton("删除");
        deleteButton.setBounds(720,550, 100,40);
        deleteButton.setContentAreaFilled(false);
        this.add(deleteButton);
        //响应删除
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "请输入数据！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    if(isrand){
                        JOptionPane.showMessageDialog(null, "随机数据，无法删除", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        boolean notexist = true;
                        String[] str = sb.toString().split(",");
                        for (int i = 0; i < str.length; i++) {
                            if (str[i].equals(deleteText.getText())) {
                                notexist = false;
                                break;
                            }
                        }
                        if (notexist) {
                            JOptionPane.showMessageDialog(null, "树中不存在数据 " + deleteText.getText(), "提示", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            System.out.println("delete " + deleteText.getText());
                            String ss = new dataProcess().getdelete(sb.toString(), Integer.parseInt(deleteText.getText()));
                            String sss[] = ss.split(",");
                            StringBuffer sbb = new StringBuffer("");
                            for(int i=0;i<sss.length;i++){
                                if(!sss[i].equals(deleteText.getText())){
                                    sbb.append(sss[i]+",");
                                }
                            }
                            String s = sbb.toString();
                            sb = new StringBuffer(s);
                            System.out.println(s);
                            if (s.length() == 0) {
                                s = ",";
                            }
                            int mid[] = new dataProcess().getData(s);
                            for (int i = 0; i < num.length; i++) {
                                num[i] = mid[i];
                            }
                            Init();
                        }
                    }
                }
            }
        });
        //添加随机按钮
        randButton = new JButton("随机");
        randButton.setBounds(930,500, 100,40);
        randButton.setContentAreaFilled(false);
        this.add(randButton);
        //响应删除
        randButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("随机");
                sb = new StringBuffer("");
                for(int i=0;i<15;i++){
                    int num = (int)(Math.random()*200+1);
                    if(!sb.toString().contains(String.valueOf(num))){
                        sb.append(num+",");
                    }
                }
                int mid[] = new dataProcess().getData(sb.toString());
                for(int i=0;i<num.length;i++){
                    num[i] = mid[i];
                }
                Init();
                isrand = true;
            }
        });
        //添加清空按钮
        clearButton = new JButton("清空");
        clearButton.setBounds(930,550, 100,40);
        clearButton.setContentAreaFilled(false);
        this.add(clearButton);
        //响应删除
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("清空");
                sb = new StringBuffer(",");
                int mid[] = new dataProcess().getData(sb.toString());
                for(int i=0;i<num.length;i++){
                    num[i] = mid[i];
                }
                Init();
            }
        });
        tip = new JButton("?");
        tip.setBounds(830,500, 50,40);
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
        for(int i=1;i<N;i++){
            if(heapNode[i].getValue() != -999) {
                Stroke s = gg.getStroke();
                gg.setStroke(new BasicStroke(3.0f));
                gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                gg.setColor(Color.BLACK);
                gg.drawLine(lx1[i-1] + 20, ly1[i-1] + 20, lx2[i-1] + 20, ly2[i-1] + 20);
                gg.setStroke(s);
            }
        }
        for(int i =0;i<N;i++){
            if(i == 0 && heapNode[i].getValue() != -999) {
                heapNode[i].paintNode(gg);
            }
            else if(heapNode[i].getValue() != -999) {
                heapNode[i].paintNode(gg);
            }
        }
    }
    //开始重绘
    public void Init() {
        initHeapNode(num);
        /*for(int i=0;i<N;i++) {
            int num = (int) (Math.random() * 100)+1;
            heapNode[i].setValue(num);
        }*/
        new paintThread().start();
    }

    public void initHeapNode(int[] num) {
        heapNode[0]=new HeapNode(700,100,num[0]);
        heapNode[1]=new HeapNode(400,200,num[1]);
        heapNode[2]=new HeapNode(1000,200,num[2]);
        heapNode[3]=new HeapNode(250,300,num[3]);
        heapNode[4]=new HeapNode(550,300,num[4]);
        heapNode[5]=new HeapNode(850,300,num[5]);
        heapNode[6]=new HeapNode(1150,300,num[6]);
        heapNode[7]=new HeapNode(150,400,num[7]);
        heapNode[8]=new HeapNode(350,400,num[8]);
        heapNode[9]=new HeapNode(450,400,num[9]);
        heapNode[10]=new HeapNode(650,400,num[10]);
        heapNode[11]=new HeapNode(750,400,num[11]);
        heapNode[12]=new HeapNode(950,400,num[12]);
        heapNode[13]=new HeapNode(1050,400,num[13]);
        heapNode[14]=new HeapNode(1250,400,num[14]);
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
