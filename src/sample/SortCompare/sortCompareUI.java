package sample.SortCompare;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.DemoTest.BarChartSample;

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

        Label bottomlabel = new Label("排序算法比较");
        bottomlabel.getStylesheets().add(sortCompareUI.class.getResource("../DemoTest/label.css").toExternalForm());
        bottomlabel.setLayoutX(500);
        bottomlabel.setLayoutY(560);
        //第一个排序算法
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        final BarChart<String,Number> firstbc = new BarChart<>(xAxis,yAxis);
        //设置BarChart的样式
        firstbc.getStylesheets().add(sortCompareUI.class.getResource("../DemoTest/databar.css").toExternalForm());
        //firstbc.setPadding(new Insets(100,0,0,20));
        firstbc.setLayoutX(10);
        firstbc.setLayoutY(150);
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
        secondbc.getStylesheets().add(sortCompareUI.class.getResource("databar.css").toExternalForm());
        //secondbc.setPadding(new Insets(100,0,0,500));
        secondbc.setLayoutX(520);
        secondbc.setLayoutY(150);
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

        root.getChildren().addAll(firstbc,secondbc,bottomlabel);
        Scene scene = new Scene(root,1050,600);
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
