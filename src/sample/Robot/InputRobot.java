package sample.Robot;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class InputRobot extends Application {
    @FXML
    private TextField num;
    @FXML
    private TextArea position;

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Robot/inputRobot.fxml"));
        primaryStage.setTitle("喷漆机器人输入数据");
        primaryStage.setScene(new Scene(root, 360, 300));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void clickok() throws Exception{
        String string = position.getText();
        string = string.replace(" ",",");
        string = string.replace("\n",",");
        int number = Integer.parseInt(num.getText());
        int temp = 0;
        String str[] = string.split(",");
        for(int i=0;i<str.length;i++){
            if(Integer.parseInt(str[i]) > temp){
                temp = Integer.parseInt(str[i]);
            }
        }
        new Main(temp*50+150, temp*50+100, number, string);
    }

    public void clickexample(){
        num.setText("7");
        position.setText("0 0 2 2 1"+"\n"+"2 0 6 1 2"+
                "\n"+"0 2 2 4 1"+"\n"+"2 1 3 4 2"+"\n"+
                "3 1 6 3 1"+"\n"+"0 4 3 6 1"+"\n"+
                "3 3 6 6 2");
    }
}
