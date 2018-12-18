package sample.DemoTest;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.lang.Thread;
import java.util.ArrayList;

public class BarChartSample{

    public int count = 0;
    public int temp = 0;

    public void start(Stage stage,ArrayList<int[]> result,int[] num,String str,String time) {
        StringBuffer inidata = new StringBuffer();
        for(int i=0;i<num.length;i++){
            inidata.append(""+num[i]+" ");
        }
        stage.setTitle("排序算法可视化");
        Group root = new Group();
        //添加显示数据的label
        Label lb1 = new Label(str+"时间:");
        lb1.setLayoutX(40);
        lb1.setLayoutY(10);
        TextField tf1 = new TextField(time);
        tf1.setLayoutX(140);
        tf1.setLayoutY(10);
        Label lb3 = new Label("待排序数据：");
        lb3.setLayoutX(40);
        lb3.setLayoutY(35);
        TextField tf2 = new TextField(inidata.toString());
        tf2.setPrefWidth(600);
        tf2.setLayoutX(140);
        tf2.setLayoutY(35);
        Label lb4 = new Label("排序的结果：");
        lb4.setLayoutX(40);
        lb4.setLayoutY(60);
        TextField tf3 = new TextField(inidata.toString());
        tf3.setPrefWidth(600);
        tf3.setLayoutX(140);
        tf3.setLayoutY(60);
        //设置label的属性
        ArrayList<Label> label = new ArrayList<Label>();
        label.add(lb1);label.add(lb3);label.add(lb4);
        for(Label lb : label){
            lb.getStylesheets().add(BarChartSample.class.getResource("label.css").toExternalForm());
        }

        //
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        final BarChart<String,Number> bc = new BarChart<>(xAxis,yAxis);
        //设置BarChart的样式
        bc.getStylesheets().add(BarChartSample.class.getResource("databar.css").toExternalForm());
        bc.setPadding(new Insets(100,0,0,20));
        bc.setPrefHeight(600);
        bc.setPrefWidth(750);
        bc.setTitle(str);
        bc.setBarGap(750/(20*num.length));
        xAxis.setLabel("数据量");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("数据大小");
        XYChart.Series series = new XYChart.Series();
        series.setName(str);
        for(int i=0;i<num.length;i++){
            int j = i+1;
            series.getData().add(new XYChart.Data(""+j,num[i]));
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<result.get(result.size()-1).length;i++){
            sb.append(""+result.get(result.size()-1)[i]+" ");
        }
        tf3.setText(sb.toString());
        root.getChildren().addAll(bc,lb1,lb3,lb4,tf1,tf2,tf3);
        Scene scene  = new Scene(root,800,600);
        stage.setScene(scene);
        stage.show();
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        bc.getData().addAll(series);

        //实现变换
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
                event1  -> {

                    for(XYChart.Series<String,Number> s : bc.getData()){
                        for(XYChart.Data<String,Number> d : s.getData()){
                            d.setYValue(result.get(count)[temp]);
                            temp++;
                        }
                        count++;
                        temp = 0;
                    }
                }
        ));
        tl.setCycleCount(result.size());
        tl.play();
    }
}