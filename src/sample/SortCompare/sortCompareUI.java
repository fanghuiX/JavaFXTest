package sample.SortCompare;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;

public class sortCompareUI {
    public int firstcount = 0;
    public int firsttemp = 0;

    public int secondcount = 0;
    public int secondtemp = 0;

    public void start(Stage stage,int[] num,ArrayList<int[]> firstsort, ArrayList<int[]> secondsort,
                      String first,String second,String firsttime,String secondtime){
        stage.setTitle("排序算法比较");
        Group root = new Group();
        StringBuilder sbnum = new StringBuilder();
        for(int i=0;i<num.length;i++){
            sbnum.append(num[i]+" ");
        }
        StringBuilder sbresult = new StringBuilder();
        for(int i=0;i<firstsort.get(firstsort.size()-1).length;i++){
            sbresult.append(firstsort.get(firstsort.size()-1)[i]+" ");
        }

        //top显示排序时间，结果等信息
        Label labelf1 = new Label(first+"用时：");
        labelf1.setLayoutX(40);
        labelf1.setLayoutY(10);
        Label labelf2 = new Label("排序数据：");
        labelf2.setLayoutX(40);
        labelf2.setLayoutY(38);
        Label labelf3 = new Label("排序结果：");
        labelf3.setLayoutX(40);
        labelf3.setLayoutY(66);
        TextField textf1 = new TextField(firsttime);
        textf1.setLayoutX(150);
        textf1.setLayoutY(10);
        TextField textf2 = new TextField(sbnum.toString());
        textf2.setPrefWidth(390);
        textf2.setLayoutX(100);
        textf2.setLayoutY(38);
        TextField textf3 = new TextField(sbresult.toString());
        textf3.setPrefWidth(390);
        textf3.setLayoutX(100);
        textf3.setLayoutY(66);

        Label labels1 = new Label(second+"用时：");
        labels1.setLayoutX(540);
        labels1.setLayoutY(10);
        Label labels2 = new Label("排序数据：");
        labels2.setLayoutX(540);
        labels2.setLayoutY(38);
        Label labels3 = new Label("排序结果：");
        labels3.setLayoutX(540);
        labels3.setLayoutY(66);
        TextField texts1 = new TextField(secondtime);
        texts1.setLayoutX(650);
        texts1.setLayoutY(10);
        TextField texts2 = new TextField(sbnum.toString());
        texts2.setPrefWidth(400);
        texts2.setLayoutX(600);
        texts2.setLayoutY(38);
        TextField texts3 = new TextField(sbresult.toString());
        texts3.setPrefWidth(400);
        texts3.setLayoutX(600);
        texts3.setLayoutY(66);

        Label bottomlabel = new Label("排序算法比较");
        bottomlabel.getStylesheets().add(sortCompareUI.class.getResource("/sample/DemoTest/label.css").toExternalForm());
        bottomlabel.setLayoutX(500);
        bottomlabel.setLayoutY(510);
        //第一个排序算法
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        final BarChart<String,Number> firstbc = new BarChart<>(xAxis,yAxis);
        //设置BarChart的样式
        firstbc.getStylesheets().add(sortCompareUI.class.getResource("/sample/DemoTest/databar.css").toExternalForm());
        firstbc.setLayoutX(10);
        firstbc.setLayoutY(100);
        firstbc.setPrefHeight(400);
        firstbc.setPrefWidth(500);
        firstbc.setTitle(first);
        firstbc.setBarGap(500/(20*num.length));
        xAxis.setLabel("数据量");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("数据大小");
        XYChart.Series series = new XYChart.Series();
        series.setName(first);
        for(int i=0;i<num.length;i++){
            int j = i+1;
            series.getData().add(new XYChart.Data(""+j,num[i]));
        }

        //第二个排序算法
        final NumberAxis yAxistwo = new NumberAxis();
        final CategoryAxis xAxistwo = new CategoryAxis();
        final BarChart<String,Number> secondbc = new BarChart<>(xAxistwo,yAxistwo);
        //设置BarChart的样式
        secondbc.getStylesheets().add(sortCompareUI.class.getResource("/sample/SortCompare/databar.css").toExternalForm());
        secondbc.setLayoutX(520);
        secondbc.setLayoutY(100);
        secondbc.setPrefHeight(400);
        secondbc.setPrefWidth(500);
        secondbc.setTitle(second);
        secondbc.setBarGap(500/(20*num.length));
        xAxistwo.setLabel("数据量");
        xAxistwo.setTickLabelRotation(90);
        yAxistwo.setLabel("数据大小");
        XYChart.Series seriestwo = new XYChart.Series();
        seriestwo.setName(second);
        for(int i=0;i<num.length;i++){
            int j = i+1;
            seriestwo.getData().add(new XYChart.Data(""+j,num[i]));
        }

        root.getChildren().addAll(firstbc,secondbc,bottomlabel,labelf1,labelf2,labelf3,labels1,labels2,labels3,
                textf1,textf2,textf3,texts1,texts2,texts3);
        Scene scene = new Scene(root,1050,550);
        stage.setScene(scene);
        stage.show();

        firstbc.getData().addAll(series);
        secondbc.getData().addAll(seriestwo);

        //实现第一个排序算法变换
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
                event1  -> {
                    for(XYChart.Series<String,Number> s : firstbc.getData()){
                        for(XYChart.Data<String,Number> d : s.getData()){
                            d.setYValue(firstsort.get(firstcount)[firsttemp]);
                            firsttemp++;
                        }
                        firstcount++;
                        firsttemp = 0;
                    }
                }
        ));
        tl.setCycleCount(firstsort.size());
        tl.play();

        //实现第二个排序算法变换
        Timeline sectl = new Timeline();
        sectl.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
                event2  -> {
                    for(XYChart.Series<String,Number> s : secondbc.getData()){
                        for(XYChart.Data<String,Number> d : s.getData()){
                            d.setYValue(secondsort.get(secondcount)[secondtemp]);
                            secondtemp++;
                        }
                        secondcount++;
                        secondtemp = 0;
                    }
                }
        ));
        sectl.setCycleCount(secondsort.size());
        sectl.play();
    }
}
