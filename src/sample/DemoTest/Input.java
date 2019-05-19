package sample.DemoTest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.JavaFXUI.MainUI;
import sample.SortCreate.*;

import java.awt.*;
import java.util.Random;
import java.util.regex.Pattern;

public class Input {

    @FXML
    public TextArea inputta;
    @FXML
    public RadioButton updown;
    @FXML
    public Button startbut,randomnum;
    //生成20个1-200的随机数
    public void getrnum(){
        StringBuffer sb1 = new StringBuffer();
        int[] randnum = new int[20];
        for(int i=0;i<19;i++){
            randnum[i] = (int)(1+Math.random()*200);
            sb1.append(randnum[i]+",");
        }
        sb1.append((int)(1+Math.random()*100));
        inputta.setText(sb1.toString());
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/DemoTest/input.fxml"));
        primaryStage.setTitle("请输入数据");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public int[] getarr(String string){
        String[] str = string.split(",");
        int[] num = new int[str.length];
        for(int i=0;i<str.length;i++){
            num[i] = Integer.parseInt(str[i]);
        }
        return num;
    }

    public boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public void startsort(){
        int sortindex = new MainUI().sortindex;
        //System.out.println("radiobutton:"+updown.isSelected());
        boolean judge = updown.isSelected();
        //由于调用一次排序函数，num已经被排序好，所以多初始化几个初始数组
        String[] string = inputta.getText().split(",");
        for(int i=0;i<string.length;i++){
            if(!isNumber(string[i]) || inputta.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("警告");
                alert.setHeaderText("输入错误");
                alert.setContentText("请按照正确格式输入数字！");
                alert.showAndWait();
            }
        }
        int[] num = getarr(inputta.getText());
        int[] num1 = getarr(inputta.getText());
        int[] num2 = getarr(inputta.getText());
        BarChartSample bar = new BarChartSample();
        bar.count = 0;
        bar.temp = 0;
        if(sortindex == 1){
            if(judge == false){
                bar.start(new Stage(),new selectSort().getresult(0,num),num1,"选择排序",new selectSort().gettime(0,num2));
            }
            else if(judge == true){
                bar.start(new Stage(),new selectSort().getresult(1,num),num1,"选择排序",new selectSort().gettime(1,num2));
            }
        }
        else if(sortindex == 2){
            if(judge == false){
                bar.start(new Stage(),new bubbleSort().getresult(0,num),num1,"冒泡排序",new bubbleSort().gettime(0,num2));
            }
            else if(judge == true){
                bar.start(new Stage(),new bubbleSort().getresult(1,num),num1,"冒泡排序",new bubbleSort().gettime(1,num2));
            }
        }
        else if(sortindex == 3){
            if(judge == false){
                bar.start(new Stage(),new quickSort().getresult(0,num),num1,"快速排序",new quickSort().gettime(0,num2));
            }
            else if(judge == true){
                bar.start(new Stage(),new quickSort().getresult(1,num),num1,"快速排序",new quickSort().gettime(1,num2));
            }
        }
        else if(sortindex == 4){
            if(judge == false){
                bar.start(new Stage(),new insertSort().getresult(0,num),num1,"插入排序",new insertSort().gettime(0,num2));
            }
            else if(judge == true){
                bar.start(new Stage(),new insertSort().getresult(1,num),num1,"插入排序",new insertSort().gettime(1,num2));
            }
        }
        else if(sortindex == 5){
            if(judge == false){
                bar.start(new Stage(),new shellSort().getresult(0,num),num1,"希尔排序",new shellSort().gettime(0,num2));
            }
            else if(judge == true){
                bar.start(new Stage(),new shellSort().getresult(1,num),num1,"希尔排序",new shellSort().gettime(1,num2));
            }
        }
        else if(sortindex == 6){
            if(judge == false){
                bar.start(new Stage(),new redixSort().getresult(0,num),num1,"基数排序",new redixSort().gettime(0,num2));
            }
            else if(judge == true){
                bar.start(new Stage(),new redixSort().getresult(1,num),num1,"基数排序",new redixSort().gettime(1,num2));
            }
        }
        else if(sortindex == 7){
            if(judge == false){
                bar.start(new Stage(),new heapSort().getresult(0,num),num1,"堆排序",new heapSort().gettime(0,num2));
            }
            else if(judge == true){
                bar.start(new Stage(),new heapSort().getresult(1,num),num1,"堆排序",new heapSort().gettime(1,num2));
            }
        }
        else if(sortindex == 8){
            if(judge == false){
                bar.start(new Stage(),new mergeSort().getresult(0,num),num1,"归并排序",new mergeSort().gettime(0,num2));
            }
            else if(judge == true){
                bar.start(new Stage(),new mergeSort().getresult(1,num),num1,"归并排序",new mergeSort().gettime(1,num2));
            }
        }

        //隐藏当前输入窗口
        /*Stage stage = (Stage)startbut.getScene().getWindow();
        stage.hide();*/
    }
}
