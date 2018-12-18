package sample.SortCompare;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SortCompare extends Application {
    @FXML
    private TextArea numtext;
    @FXML
    private ChoiceBox firstchoice,secondchoice;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sortCompare.fxml"));
        primaryStage.setTitle("排序比较");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void startcompare(MouseEvent mouseEvent) {
        //System.out.println(firstchoice.getValue());
        //System.out.println(secondchoice.getValue());
        String str = numtext.getText();
        String[] string = str.split(",");
        int[] num = new int[string.length];
        for(int i=0;i<num.length;i++){
            num[i] = Integer.parseInt(string[i]);
        }
        ArrayList<int[]> firstsort = null;
        ArrayList<int[]> secondsort = null;
        String first = (String)firstchoice.getValue();
        String second = (String)secondchoice.getValue();
        System.out.println(first+" "+second);
        String firsttime = "";
        String secondtime = "";
        sortCompareUI scui = new sortCompareUI();
        scui.start(new Stage(),num,firstsort,secondsort,first,second,firsttime,secondtime);
    }

    public void randomnum(MouseEvent mouseEvent) {
        int[] num = new int[19];
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<num.length;i++){
            num[i] = (int)(1+Math.random()*200);
            sb.append(num[i]+",");
        }
        sb.append((int)(1+Math.random()*200)+"");
        numtext.setText(sb.toString());
    }
}
