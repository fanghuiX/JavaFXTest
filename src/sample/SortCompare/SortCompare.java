package sample.SortCompare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.SortCreate.*;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class SortCompare{
    @FXML
    private TextArea numtext;
    @FXML
    private ChoiceBox firstchoice,secondchoice;
    @FXML
    private  RadioButton updown;

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sortCompare/sortCompare.fxml"));
        primaryStage.setTitle("排序比较");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    public void startcompare(MouseEvent mouseEvent) {
        String str = numtext.getText();
        String[] string = str.split(",");
        for(int i=0;i<string.length;i++){
            if(!isNumber(string[i]) || str.equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("警告");
                alert.setHeaderText("输入错误");
                alert.setContentText("请按照正确格式输入数字！");
                alert.showAndWait();
            }
        }
        int[] num = new int[string.length];
        int[] num1 = new int[string.length];
        int[] num2 = new int[string.length];
        int[] num3 = new int[string.length];
        for(int i=0;i<num.length;i++){
            num[i] = Integer.parseInt(string[i]);
            num1[i] = num[i];
            num2[i] = num[i];
            num3[i] = num[i];
        }

        int flag = 0;
        if(updown.isSelected()){
            flag = 1;
        }
        String first = (String)firstchoice.getValue();
        String second = (String)secondchoice.getValue();

        sortResult firstsr = getres(flag,first,num);
        ArrayList<int[]> firstsort = firstsr.getSortres();
        String firsttime = firstsr.getSorttime();

        sortResult secondsr = getres(flag,second,num1);
        ArrayList<int[]> secondsort = secondsr.getSortres();
        String secondtime = secondsr.getSorttime();

        sortCompareUI scui = new sortCompareUI();
        if(first.equals("选择第一个排序算法") || second.equals("选择第二个排序算法")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setHeaderText("出现一个错误");
            alert.setContentText("请选择正确的排序算法！");
            alert.showAndWait();
        }
        else{
            scui.start(new Stage(),num3,firstsort,secondsort,first,second,firsttime,secondtime);
        }
    }

    public void randomnum() {
        int[] num = new int[19];
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<num.length;i++){
            num[i] = (int)(1+Math.random()*200);
            sb.append(num[i]+",");
        }
        sb.append((int)(1+Math.random()*200)+"");
        numtext.setText(sb.toString());
    }

    public sortResult getres(int flag,String str,int[] num){
        sortResult sr = new sortResult();
        sr.setSortname("asdfg");
        int[] num1 = new int[num.length];
        System.arraycopy(num,0,num1,0,num.length);
        if(str.equals("选择排序")){
            sr.setSortres(new selectSort().getresult(flag,num));
            sr.setSorttime(new selectSort().gettime(flag,num1));
        }
        else if(str.equals("冒泡排序")){
            sr.setSortres(new bubbleSort().getresult(flag,num));
            sr.setSorttime(new bubbleSort().gettime(flag,num1));
        }
        else if(str.equals("快速排序")){
            sr.setSortres(new quickSort().getresult(flag,num));
            sr.setSorttime(new quickSort().gettime(flag,num1));
        }
        else if(str.equals("直接插入排序")){
            sr.setSortres(new insertSort().getresult(flag,num));
            sr.setSorttime(new insertSort().gettime(flag,num1));
        }
        else if(str.equals("希尔排序")){
            sr.setSortres(new shellSort().getresult(flag,num));
            sr.setSorttime(new shellSort().gettime(flag,num1));
        }
        else if(str.equals("基数排序")){
            sr.setSortres(new redixSort().getresult(flag,num));
            sr.setSorttime(new redixSort().gettime(flag,num1));
        }
        else if(str.equals("堆排序")){
            sr.setSortres(new heapSort().getresult(flag,num));
            sr.setSorttime(new heapSort().gettime(flag,num1));
        }
        else if(str.equals("归并排序")){
            sr.setSortres(new mergeSort().getresult(flag,num));
            sr.setSorttime(new mergeSort().gettime(flag,num1));
        }
        return sr;
    }
}
