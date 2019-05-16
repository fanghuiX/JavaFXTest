package sample.HeapSort;

import sample.HeapSort.Code;
import sample.HeapSort.HeapNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import sample.HeapSort.newThread;

public class HeapSort extends JPanel {
    private int height = 0;
    private int width = 0;
    private int x_loacte = 0;
    private int y_loacte = 0;
    private static int N = 15;
    private static int speed = 400;
    // 比较次数&移动次数
    private static int compareCount = 0;
    private static int moveCount = 0;
    //二叉树的初始化位置
    private int lx1[]={700,700,400,400,1000,1000,250,250,550,550,850,850,1150,1150};
    private int lx2[]={400,1000,250,550,850,1150,150,350,450,650,750,950,1050,1250};
    private int ly1[]={100,100,200,200,200,200,300,300,300,300,300,300,300,300};
    private int ly2[]={200,200,300,300,300,300,400,400,400,400,400,400,400,400};
    private static boolean stopFlag =false;
    private static boolean pause =false;
    private static boolean resetFlag =false;
    private static boolean canGo=false;
    private Main mainBoard = null;
    private static  int a[]=new int [N+1];
    private static int a2[]=new int [N+1];
    private static int length=N; //堆的大小
    private JButton start;
    private JButton quick;
    private JButton slow;
    private JButton pauseButton;
    private JButton resetButton;
    private Code title;
    private Code hint;
    private HeapNode heapNode[]=new HeapNode[N+1];
    Code codes[]=new Code[7];
    private String[]str ={"for (i = length/2; i >= 1; i--)",
            "         k = i;",
            "         while( k*2 <= length)",
            "             if (a[k] > min(a[k*2],a[k*2+1])",
            "                 swap(a[k],min(a[k*2],a[k*2+1]));",
            "                 k = k*2 or k*2+1;",
            "remove ( a[1] );",
            "a[1]=a[length--];",
            "k = 1;"
    };

    public HeapSort(int width, int height, Main mainBoard, boolean flag) {
        this.mainBoard = mainBoard;
        this.height = height;
        this.width = width;
        setLayout(null);
        setBounds(x_loacte, y_loacte, width, height);
        setBackground(Color.white);

        setVisible(false);
        setFocusable(true);
        codes[0]=new Code(1100,600,490,30,"for (i = a.length/2; i >= 1; i--)");
        codes[1]=new Code(1100,630,490,30,"         k = i;");
        codes[2]=new Code(1100,660,490,30,"         while( k*2 <= a.length)");
        codes[3]=new Code(1100,690,490,30,"             if (a[k] > min(a[k*2],a[k*2+1])");
        codes[4]=new Code(1100,720,490,30,"                 swap(a[k],min(a[k*2],a[k*2+1]));");
        codes[5]=new Code(1100,750,490,30,"                 k = k*2 or k*2+1;");
        codes[6]=new Code(1100,780,490,30,"");

        quick =new JButton("加速");
        quick.setBounds(790,725,100,50);
        quick.setForeground(Color.black);
        this.add(quick);
        quick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(speed>50){
                    speed-=50;
                }
                System.out.println("quick now speed : "+speed);
            }
        });
        slow =new JButton("减速");
        slow .setBounds(670,725,100,50);
        slow.setForeground(Color.black);
        this.add( slow );
        slow .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(speed<600){
                    speed+=50;
                }
                System.out.println("slow now speed : "+speed);
            }
        });
        pauseButton = new JButton("暂停");
        pauseButton.setBounds(550,725,100,50);
        pauseButton.setForeground(Color.black);
        this.add(pauseButton);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pause){
                    pause=false;
                    pauseButton.setText("暂停");
                }
                else {
                    pause=true;
                    pauseButton.setText("开始");
                }
            }
        });
        start = new JButton("排序");
        start.setBounds(430,725,100,50);
        start.setForeground(Color.black);
        this.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canGo=true;
                System.out.println(canGo);
                moveCount=0;
                compareCount=0;
            }
        });
        resetButton = new JButton("重置");
        resetButton.setBounds(910,725,100,50);
        resetButton.setForeground(Color.black);
        this.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFlag=true;
                speed = 400;
            }
        });

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        for(int i=0;i<length-1;i++){
            Stroke s = gg.getStroke();
            gg.setStroke(new BasicStroke(3.0f));
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            gg.setColor(Color.BLACK);
            gg.drawLine(lx1[i]+20,ly1[i]+20,lx2[i]+20,ly2[i]+20);
            gg.setStroke(s);
        }
        for(int i =1;i<=N;i++){
            heapNode[i].paintNode(gg);
        }
        title.paintBar(gg);
        hint.paintBar(gg);
        /*for(Code i:codes){
            i.paintBar(gg);
        }*/
        Stroke s = gg.getStroke();
        gg.setColor(new Color(254,197,21));
        gg.fillRect(1100,635,490,60);
        gg.setStroke(s);

        gg.setColor(Color.BLACK);
        gg.fillRect(0,820,1600,80);
        gg.setStroke(s);

        gg.setColor(Color.white);
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Font font1 = new Font("微软雅黑", Font.BOLD, 18);
        gg.setFont(font1);
        gg.drawString("比较次数 :                     "+compareCount,1135,655);
        gg.drawString("移动次数 :                     "+moveCount,1135,685);
        gg.drawString("当前速度 : "+(70-speed/10),750,850);
    }
    public  void swap(int a [],int j,int i){
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    public void Init(int[] num, boolean flag) {
        initHeapNode();
        for(int i=1;i<=num.length;i++) {
            a[i] = num[i-1];
            a2[i]=a[i];
            heapNode[i].setValue(a[i]);
        }
        if(flag){
            title= new Code(1100,570,490,30,"堆排序-最小堆");
        }
        else {
            title= new Code(1100,570,490,30,"堆排序-最大堆");
        }
        title.setColor(Code.BLUE);
        hint= new Code(1100,600,490,30,"");
        hint.setColor(Code.BLUE);
        compareCount=0;
        moveCount=0;
        new paintThread().start();
    }
    public void initHeapNode(){
        heapNode[1]=new HeapNode(700,100,0);

        heapNode[2]=new HeapNode(400,200,0);
        heapNode[3]=new HeapNode(1000,200,0);

        heapNode[4]=new HeapNode(250,300,0);
        heapNode[5]=new HeapNode(550,300,0);
        heapNode[6]=new HeapNode(850,300,0);
        heapNode[7]=new HeapNode(1150,300,0);

        heapNode[8]=new HeapNode(150,400,0);
        heapNode[9]=new HeapNode(350,400,0);
        heapNode[10]=new HeapNode(450,400,0);
        heapNode[11]=new HeapNode(650,400,0);
        heapNode[12]=new HeapNode(750,400,0);
        heapNode[13]=new HeapNode(950,400,0);
        heapNode[14]=new HeapNode(1050,400,0);
        heapNode[15]=new HeapNode(1250,400,0);
        length=15;
        for (int i=0;i<6;i++){
            codes[i].setStr(str[i]);
            codes[i].setColor(HeapNode.GLASSGREEN);
        }
        codes[6].setStr("");
    }
    public static boolean begin = true;
    public void sort(boolean flag){
        //System.out.println(Thread.currentThread().getName());
        while (begin) {
            //System.out.println("sorttttttttt");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (stopFlag){
                stopFlag=false;
                canGo = false;
                break;
            }
            if(resetFlag){
                resetFlag=false;
                canGo=false;
                initHeapNode();
                for(int i=1;i<=N;i++) {
                    hint.setStr("");
                    a[i]=a2[i];
                    heapNode[i].setValue(a[i]);
                }
                compareCount=0;
                moveCount=0;
            }
            if (canGo) {
                if(flag){
                    hint.setStr("排序开始，建立最小堆");
                }
                else {
                    hint.setStr("排序开始，建立最大堆");
                }
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int k = length/2; k >= 1; k--){
                    if (stopFlag){
                        break;
                    }
                    if (resetFlag){
                        break;
                    }
                    codes[1].setColor(Code.BLACK);
                    int i=k;

                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    codes[1].setColor(Code.GLASSGREEN);
                    while (i*2<=length) {
                        codes[2].setColor(Code.BLACK);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        codes[2].setColor(Code.GLASSGREEN);
                        heapNode[i].setColorOut(HeapNode.GLASSGREEN);
                        heapNode[i].setColorInner(HeapNode.GLASSGREEN);
                        heapNode[i].setColorV(HeapNode.WHITE);
                        codes[3].setColor(Code.BLACK);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (stopFlag){
                            break;
                        }
                        if (resetFlag){
                            break;
                        }
                        if(pause){
                            while(pause){
                                try {
                                    Thread.sleep(300);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (i * 2 + 1 <= length) {

                            heapNode[i * 2].setColorOut(HeapNode.YELLOW2);
                            heapNode[i * 2].setColorInner(HeapNode.YELLOW2);
                            heapNode[i * 2].setColorV(HeapNode.WHITE);

                            heapNode[i * 2 + 1].setColorOut(HeapNode.YELLOW2);
                            heapNode[i * 2 + 1].setColorInner(HeapNode.YELLOW2);
                            heapNode[i * 2+1].setColorV(HeapNode.WHITE);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (stopFlag){
                                break;
                            }
                            if (resetFlag){
                                break;
                            }
                            if(pause){
                                while(pause){
                                    try {
                                        Thread.sleep(300);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            if(flag){
                                hint.setStr("与子节点比较，若大于子节点中较小的一个，交换");
                            }
                            else {
                                hint.setStr("与子节点比较，若小于子节点中较大的一个，交换");
                            }
                            //比左子节点大， 与其交换下沉
                            if (flag ? a[i * 2] < a[i * 2 + 1] && a[i] > a[i * 2] : a[i * 2] > a[i * 2 + 1] && a[i] < a[i * 2]) {
                                heapNode[i * 2 + 1].setColorOut(HeapNode.BLACK);
                                heapNode[i * 2 + 1].setColorInner(HeapNode.WHITE);
                                heapNode[i * 2 + 1].setColorV(HeapNode.BLACK);
                                codes[3].setColor(Code.GLASSGREEN);
                                compareCount++;
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                compareCount++;
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                codes[4].setColor(Code.BLACK);
                                swap(a, i * 2, i);
                                exchange(heapNode[i], heapNode[i * 2], 50);
                                swapHeap(i, i * 2);
                                moveCount+=3;
                                codes[4].setColor(Code.GLASSGREEN);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                codes[5].setColor(Code.BLACK);
                                i=i*2;
                                hint.setStr("交换后继续与新的子节点比较，直到成为叶节点");
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                codes[5].setColor(Code.GLASSGREEN);
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                            }
                            //比右子节点大， 与其交换下沉
                            else if (flag ? a[i * 2] > a[i * 2 + 1] && a[i] > a[i * 2 + 1] : a[i * 2] < a[i * 2 + 1] && a[i] < a[i * 2 + 1]) {
                                if(flag){
                                    hint.setStr("与子节点比较，若大于子节点中较小的一个，交换");
                                }
                                else {
                                    hint.setStr("与子节点比较，若小于子节点中较大的一个，交换");
                                }
                                codes[3].setColor(Code.GLASSGREEN);
                                heapNode[i * 2].setColorOut(HeapNode.BLACK);
                                heapNode[i * 2].setColorInner(HeapNode.WHITE);
                                heapNode[i * 2].setColorV(HeapNode.BLACK);
                                compareCount++;
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                compareCount++;
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                codes[4].setColor(Code.BLACK);
                                swap(a, i * 2 + 1, i);
                                exchange(heapNode[i], heapNode[i * 2 + 1], 50);
                                swapHeap(i, i * 2 + 1);
                                moveCount+=3;
                                codes[4].setColor(Code.GLASSGREEN);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                i=i*2+1;
                                hint.setStr("交换后继续与新的子节点比较，直到成为叶节点");
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                codes[5].setColor(Code.BLACK);
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                codes[5].setColor(Code.GLASSGREEN);
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                            }
                            else {

                                heapNode[i * 2].setColorOut(HeapNode.BLACK);
                                heapNode[i * 2].setColorInner(HeapNode.WHITE);
                                heapNode[i * 2].setColorV(HeapNode.BLACK);
                                heapNode[i * 2+1].setColorOut(HeapNode.BLACK);
                                heapNode[i * 2+1].setColorInner(HeapNode.WHITE);
                                heapNode[i* 2 +1].setColorV(HeapNode.BLACK);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                codes[3].setColor(Code.GLASSGREEN);
                                compareCount++;
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                compareCount++;
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        else if(i*2==length){
                            if (flag ? a[i] > a[i * 2] : a[i] < a[i * 2]) {
                                if(flag){
                                    hint.setStr("与子节点比较，若大于子节点中较小的一个，交换");
                                }
                                else {
                                    hint.setStr("与子节点比较，若小于子节点中较大的一个，交换");
                                }
                                codes[3].setColor(Code.BLACK);
                                heapNode[i * 2].setColorOut(HeapNode.YELLOW2);
                                heapNode[i * 2].setColorInner(HeapNode.YELLOW2);
                                heapNode[i*2].setColorV(HeapNode.WHITE);
                                compareCount++;
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                codes[3].setColor(Code.GLASSGREEN);
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                codes[4].setColor(Code.BLACK);
                                swap(a, i * 2, i);
                                exchange(heapNode[i], heapNode[i * 2], 50);
                                swapHeap(i, i * 2);
                                moveCount+=3;
                                codes[4].setColor(Code.GLASSGREEN);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                codes[5].setColor(Code.BLACK);
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                codes[5].setColor(Code.GLASSGREEN);
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                i=i*2;
                                hint.setStr("交换后继续与新的子节点比较，直到成为叶节点");
                            }

                        }
                    }

                }
                if(flag){
                    hint.setStr("最小堆建立完成，开始出堆");
                }
                else {
                    hint.setStr("最大堆建立完成，开始出堆");
                }
                codes[0].setStr(str[6]);
                codes[1].setStr(str[7]);
                codes[2].setStr(str[8]);
                codes[3].setStr(str[2]);
                codes[4].setStr(str[3]);
                codes[5].setStr(str[4]);
                codes[6].setStr(str[5]);
                try {
                    Thread.sleep(speed*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (length>0){

                    if (stopFlag){
                        break;
                    }
                    if (resetFlag){
                        break;
                    }
                    if(pause){
                        while(pause){
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    int x1=heapNode[1].getX(); int y1=heapNode[1].getY();
                    a[1]=a[length];
                    codes[0].setColor(Code.BLACK);
                    if(flag){
                        hint.setStr("根为最小堆中的最小值，将根出堆");
                    }
                    else {
                        hint.setStr("根为最大堆中的最大值，将根出堆");
                    }
                    heapNode[1].move((16-length)*60+80,600,50);
                    codes[0].setColor(Code.GLASSGREEN);
                    if (stopFlag){
                        break;
                    }
                    if (resetFlag){
                        break;
                    }
                    if(pause){
                        while(pause){
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if(flag){
                        hint.setStr("将堆中最后一个元素作为新根，重新调整最小堆");
                    }
                    else {
                        hint.setStr("将堆中最后一个元素作为新根，重新调整最大堆");
                    }
                    codes[1].setColor(Code.BLACK);
                    heapNode[0]=heapNode[1];
                    heapNode[1]=heapNode[length];
                    heapNode[length]=heapNode[0];
                    heapNode[1].setColorInner(HeapNode.BLUE);
                    heapNode[1].setColorOut(HeapNode.BLUE);
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (stopFlag){
                        break;
                    }
                    if (resetFlag){
                        break;
                    }
                    if(pause){
                        while(pause){
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }if (length!=1)
                        heapNode[1].move(x1,y1,50);
                    moveCount++;
                    heapNode[1].setColorOut(HeapNode.BLACK);
                    heapNode[1].setColorInner(HeapNode.WHITE);
                    length--;
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    codes[1].setColor(Code.GLASSGREEN);

                    codes[2].setColor(Code.BLACK);
                    int i =1;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    codes[2].setColor(Code.GLASSGREEN);
                    while (i*2<=length) {
                        codes[3].setColor(Code.BLACK);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        codes[3].setColor(Code.GLASSGREEN);
                        heapNode[i].setColorOut(HeapNode.GLASSGREEN);
                        heapNode[i].setColorInner(HeapNode.GLASSGREEN);
                        heapNode[i].setColorV(HeapNode.WHITE);
                        codes[4].setColor(Code.BLACK);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (stopFlag){
                            break;
                        }
                        if (resetFlag){
                            break;
                        }
                        if(pause){
                            while(pause){
                                try {
                                    Thread.sleep(300);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (i * 2 + 1 <= length) {

                            heapNode[i * 2].setColorOut(HeapNode.YELLOW2);
                            heapNode[i * 2].setColorInner(HeapNode.YELLOW2);
                            heapNode[i * 2].setColorV(HeapNode.WHITE);

                            heapNode[i * 2 + 1].setColorOut(HeapNode.YELLOW2);
                            heapNode[i * 2 + 1].setColorInner(HeapNode.YELLOW2);
                            heapNode[i * 2+1].setColorV(HeapNode.WHITE);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (stopFlag){
                                break;
                            }
                            if (resetFlag){
                                break;
                            }
                            if(pause){
                                while(pause){
                                    try {
                                        Thread.sleep(300);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            //比左子节点大， 与其交换下沉
                            if (flag ? a[i * 2] < a[i * 2 + 1] && a[i] > a[i * 2] : a[i * 2] > a[i * 2 + 1] && a[i] < a[i * 2]) {
                                if(flag){
                                    hint.setStr("与子节点比较，若大于子节点中较小的一个，交换");
                                }
                                else {
                                    hint.setStr("与子节点比较，若小于子节点中较大的一个，交换");
                                }
                                heapNode[i * 2 + 1].setColorOut(HeapNode.BLACK);
                                heapNode[i * 2 + 1].setColorInner(HeapNode.WHITE);
                                heapNode[i * 2 + 1].setColorV(HeapNode.BLACK);
                                codes[4].setColor(Code.GLASSGREEN);
                                compareCount++;
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                compareCount++;
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                codes[5].setColor(Code.BLACK);
                                swap(a, i * 2, i);
                                exchange(heapNode[i], heapNode[i * 2], 50);
                                swapHeap(i, i * 2);
                                moveCount+=3;
                                codes[5].setColor(Code.GLASSGREEN);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                codes[6].setColor(Code.BLACK);
                                i=i*2;
                                hint.setStr("交换后继续与新的子节点比较，直到成为叶节点");
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                codes[6].setColor(Code.GLASSGREEN);
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                            }
                            //比右子节点大， 与其交换下沉
                            else if (flag ? a[i * 2] >= a[i * 2 + 1] && a[i] > a[i * 2 + 1] : a[i * 2] <= a[i * 2 + 1] && a[i] < a[i * 2 + 1]) {
                                if(flag){
                                    hint.setStr("与子节点比较，若大于子节点中较小的一个，交换");
                                }
                                else {
                                    hint.setStr("与子节点比较，若小于子节点中较大的一个，交换");
                                }
                                codes[4].setColor(Code.GLASSGREEN);
                                heapNode[i * 2].setColorOut(HeapNode.BLACK);
                                heapNode[i * 2].setColorInner(HeapNode.WHITE);
                                heapNode[i * 2].setColorV(HeapNode.BLACK);
                                compareCount++;
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                compareCount++;
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                codes[5].setColor(Code.BLACK);
                                swap(a, i * 2 + 1, i);
                                exchange(heapNode[i], heapNode[i * 2 + 1], 50);
                                swapHeap(i, i * 2 + 1);
                                moveCount+=3;
                                codes[5].setColor(Code.GLASSGREEN);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                hint.setStr("交换后继续与新的子节点比较，直到成为叶节点");
                                i=i*2+1;
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                codes[6].setColor(Code.BLACK);
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                codes[6].setColor(Code.GLASSGREEN);
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                            }
                            else {
                                heapNode[i * 2].setColorOut(HeapNode.BLACK);
                                heapNode[i * 2].setColorInner(HeapNode.WHITE);
                                heapNode[i * 2].setColorV(HeapNode.BLACK);
                                heapNode[i * 2+1].setColorOut(HeapNode.BLACK);
                                heapNode[i * 2+1].setColorInner(HeapNode.WHITE);
                                heapNode[i* 2 +1].setColorV(HeapNode.BLACK);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                codes[4].setColor(Code.GLASSGREEN);
                                compareCount++;
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                compareCount++;
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        else if(i*2==length){
                            if (flag ? a[i] > a[i * 2] : a[i] < a[i * 2]) {
                                if(flag){
                                    hint.setStr("与子节点比较，若大于子节点中较小的一个，交换");
                                }
                                else {
                                    hint.setStr("与子节点比较，若小于子节点中较大的一个，交换");
                                }
                                codes[4].setColor(Code.BLACK);
                                heapNode[i * 2].setColorOut(HeapNode.YELLOW2);
                                heapNode[i * 2].setColorInner(HeapNode.YELLOW2);
                                heapNode[i*2].setColorV(HeapNode.WHITE);
                                compareCount++;
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                codes[4].setColor(Code.GLASSGREEN);
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                codes[5].setColor(Code.BLACK);
                                swap(a, i * 2, i);
                                exchange(heapNode[i], heapNode[i * 2], 50);
                                swapHeap(i, i * 2);
                                moveCount+=3;
                                codes[5].setColor(Code.GLASSGREEN);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                codes[6].setColor(Code.BLACK);
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                codes[6].setColor(Code.GLASSGREEN);
                                if (stopFlag){
                                    break;
                                }
                                if (resetFlag){
                                    break;
                                }
                                if(pause){
                                    while(pause){
                                        try {
                                            Thread.sleep(300);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                i=i*2;
                                hint.setStr("交换后继续与新的子节点比较，直到成为叶节点");
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                            }
                            else {
                                codes[4].setColor(Code.GLASSGREEN);
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                                i=i*2;
                                heapNode[i].setColorOut(HeapNode.BLACK);
                                heapNode[i].setColorInner(HeapNode.WHITE);
                                heapNode[i].setColorV(HeapNode.BLACK);
                            }

                        }
                        heapNode[i].setColorOut(HeapNode.BLACK);
                        heapNode[i].setColorInner(HeapNode.WHITE);
                        heapNode[i].setColorV(HeapNode.BLACK);
                    }

                }
                canGo=false;
                hint.setStr("");

            }

//
        }
        //  System.out.println("sort end");
    }
    public void exchange(HeapNode a, HeapNode b, int time){
        int ax = a.getX();int ay=a.getY();
        int bx = b.getX();int by=b.getY();
        int disx = Math.abs(ax-bx);
        int disy=Math.abs(ay-by);
        for(int i=0;i<time;i++){
            if(ax>bx){
                a.setX(a.getX()-disx/time);
                b.setX(b.getX()+disx/time);
            }
            else{
                a.setX(a.getX()+disx/time);
                b.setX(b.getX()-disx/time);
            }
            if(ay>by){
                a.setY(a.getY()-disy/time);
                b.setY(b.getY()+disy/time);
            }
            else{
                a.setY(a.getY()+disy/time);
                b.setY(b.getY()-disy/time);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.setX(bx);a.setY(by);
        b.setX(ax);b.setY(ay);
    }
    public void swapHeap(int i,int j){
        heapNode[0]=heapNode[i];
        heapNode[i]=heapNode[j];
        heapNode[j]=heapNode[0];
    }



    private class paintThread extends Thread{
        @Override
        public void run() {
            while(true){
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}

