package sample.DemoTest;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.JavaFXUI.MainUI;
import sample.SortCreate.*;

import java.awt.*;

public class Input extends Application {

    @FXML
    public TextArea inputta;
    @FXML
    public RadioButton updown;
    @FXML
    public Button startbut;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("input.fxml"));
        primaryStage.setTitle("请输入数据");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public int[] getarr(String string){
        String[] str = string.split(",");
        int[] num = new int[str.length];
        for(int i=0;i<str.length;i++){
            num[i] = Integer.parseInt(str[i]);
        }
        return num;
    }

    public void startsort(){
        int sortindex = new MainUI().sortindex;
        //System.out.println("radiobutton:"+updown.isSelected());
        boolean judge = updown.isSelected();
        int[] num = getarr(inputta.getText());
        BarChartSample bar = new BarChartSample();
        bar.count = 0;
        bar.temp = 0;
        if(sortindex == 1){
            if(judge == false){
                bar.start(new Stage(),new selectSort().getresult(0,num),num,"选择排序",new selectSort().gettime(0,num));
            }
            else if(judge == true){
                bar.start(new Stage(),new selectSort().getresult(1,num),num,"选择排序",new selectSort().gettime(1,num));
            }
        }
        else if(sortindex == 2){
            if(judge == false){
                bar.start(new Stage(),new bubbleSort().getresult(0,num),num,"冒泡排序",new bubbleSort().gettime(0,num));
            }
            else if(judge == true){
                bar.start(new Stage(),new bubbleSort().getresult(1,num),num,"冒泡排序",new bubbleSort().gettime(1,num));
            }
        }
        else if(sortindex == 3){

        }
        else if(sortindex == 4){

        }
        else if(sortindex == 5){

        }
        else if(sortindex == 6){

        }
        else if(sortindex == 7){

        }
        else if(sortindex == 8){

        }

        //隐藏当前输入窗口
        /*Stage stage = (Stage)startbut.getScene().getWindow();
        stage.hide();*/
    }
}
