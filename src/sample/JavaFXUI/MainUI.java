package sample.JavaFXUI;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.MenuItem;

import sample.DemoTest.Input;
import sample.SortCompare.SortCompare;
import sample.inputTree.Defaultui;
import sample.inputTree.Inputbtree;
import sample.inputTree.Searchtree;
import sample.MenuItemEvent.SJGJS.Gnjs;
import sample.HeapSort.Main;
import sample.MazeDFS.AlgoVisualizer;
import sample.GraphViz.showSettings;
import sample.HeapSort.inputNode;
import sample.SearchBT.newThread;
import sample.MazePath.Maze;
import sample.Robot.InputRobot;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainUI implements Initializable {
    @FXML
    private ChoiceBox choicetree,choicegraph,choicesort,choiceg;
    @FXML
    private MenuItem gnjs, sdbsf, ecs, hfms, bs, hhs;
    @FXML
    private MenuItem array, stack, queue, linklist, graph, heap, slb;
    @FXML
    private MenuItem select, bubble, quick, insert, shell, jspx, heapsort, merge;
    @FXML
    private MenuItem maze, dxbx, deepsearch, boardsearch;
    @FXML
    private MenuItem about, setting;
    public static int index;
    public static int graphindex;
    public static int sortindex;
    public static int gindex;

    @Override
        public void initialize(URL location, ResourceBundle resources) {
        String sdgnhtml = new File("src/sample/MenuItemEvent/SJGJS/sdgn.html").getAbsolutePath().replace('\\','/');
        String sdbsfhtml = new File("src/sample/MenuItemEvent/SJGJS/SDBSF.html").getAbsolutePath().replace('\\','/');
        String gybrjhtml = new File("src/sample/MenuItemEvent/GYBRJ/about.html").getAbsolutePath().replace('\\','/');
        //响应 MenuItem
        try {
            gnjs.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "树的概念", "file:///"+sdgnhtml); });
            sdbsf.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "树的表示法", "file:///"+sdbsfhtml); });
            ecs.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "二叉树", "https://baike.baidu.com/item/二叉树"); });
            hfms.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "哈夫曼树", "https://baike.baidu.com/item/哈夫曼树"); });
            bs.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "B-/B+树", "https://www.baidu.com/s?wd=B-/B+树"); });
            hhs.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "红黑树", "https://baike.baidu.com/item/红黑树"); });
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            array.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "数组", "https://baike.baidu.com/item/数组"); });
            stack.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "栈", "https://baike.baidu.com/item/栈"); });
            queue.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "队列", "https://baike.baidu.com/item/队列"); });
            linklist.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "链表", "https://baike.baidu.com/item/链表"); });
            graph.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "图", "https://baike.baidu.com/item/图"); });
            heap.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "堆", "https://baike.baidu.com/item/堆"); });
            slb.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "散列表", "https://baike.baidu.com/item/散列表"); });
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            select.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "选择排序", "https://baike.baidu.com/item/选择排序"); });
            bubble.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "冒泡排序", "https://baike.baidu.com/item/冒泡排序"); });
            quick.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "快速排序", "https://baike.baidu.com/item/快速排序"); });
            insert.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "直接插入排序", "https://baike.baidu.com/item/直接插入排序"); });
            shell.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "希尔排序", "https://baike.baidu.com/item/希尔排序"); });
            jspx.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "基数排序", "https://baike.baidu.com/item/基数排序"); });
            heapsort.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "堆排序", "https://baike.baidu.com/item/堆排序"); });
            merge.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "归并排序", "https://baike.baidu.com/item/归并排序"); });
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            maze.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "迷宫寻路", "https://www.baidu.com/s?wd=迷宫寻路算法"); });
            dxbx.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "电线布线", "https://www.baidu.com/s?wd=电线布线算法"); });
            deepsearch.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "深度优先搜索", "https://baike.baidu.com/item/深度优先搜索"); });
            boardsearch.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "广度优先搜索", "https://baike.baidu.com/item/广度优先搜索"); });
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            about.setOnAction(e -> { Gnjs.getInstance().start(700,600,new Stage(), "关于本软件", "file:///"+gybrjhtml); });
            setting.setOnAction(e -> {
                try {
                    showSettings sss = new showSettings();
                    sss.show(new Stage());
                }catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            });
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //响应ChoiceBox：choicetree的选择
        choicetree.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicetree index:"+new_val);
                    index = new_val.intValue();
                    if(new_val.intValue() != 0) {
                        if (new_val.intValue() != 3) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Inputbtree.getInstance().start(new Stage());
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            });
                        } else {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Searchtree.getInstance().start(new Stage());
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            });
                        }
                    }
                }
        );
        //响应ChoiceBox,树结构
        String btreehtml = new File("src/sample/BTREE/B-Tree.html").getAbsolutePath().replace('\\','/');
        String bplustreehtml = new File("src/sample/BTREE/B+Tree.html").getAbsolutePath().replace('\\','/');
        choicegraph.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicegraph index:"+new_val);
                    // Thread th = Thread.currentThread();
                    // System.out.println(th.getName());
                    graphindex = new_val.intValue();
                    if(graphindex == 1) {
                        try{
                            inputNode.getInstance().startnode(new Stage());
                        } catch (Exception e) {

                        }
                    }
                    else if(graphindex == 2){
                        Gnjs.getInstance().start(1000, 580,new Stage(), "B-树", "file:///"+btreehtml);
                    }
                    else if(graphindex == 3){
                        Gnjs.getInstance().start(1000, 580,new Stage(), "B+树", "file:///"+bplustreehtml);
                    }
                    else if(graphindex == 4) {
                        new newThread().start();
                    }
                    else {
                        Defaultui dui = new Defaultui();
                        try {
                            dui.start(new Stage());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
        );
        //响应ChoiceBox：choicesort的选择
        choicesort.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicesort index:"+new_val);
                    sortindex = new_val.intValue();
                    //八大排序
                    if(sortindex != 0 && sortindex != 9) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Input i = new Input();
                                    i.start(new Stage());
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
                    }
                    //转入比较排序的界面
                    else if(sortindex == 9){
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    SortCompare sc = new SortCompare();
                                    sc.start(new Stage());
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
                    }
                }
        );
        //响应ChoiceBox：choiceg的选择
        choiceg.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choiceg index:"+new_val);
                    gindex = new_val.intValue();
                    if(gindex == 2) {
                        try{
                            new Maze().start(new Stage());
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else if(gindex == 1) {
                        InputRobot ir = new InputRobot();
                        try{
                            ir.start(new Stage());
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
        );
    }

}
