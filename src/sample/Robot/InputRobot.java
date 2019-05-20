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

    public void clickok(){
        System.out.println(num.getText());
        System.out.println(position.getText());
        String string = position.getText();
        string = string.replace(" ","");
        string = string.replace("\n","");
        char[] c = string.toCharArray();
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+" ");
        }
        new Main(600, 500);
    }

    public void clickexample(){
        num.setText("7");
        position.setText("0 0 2 2 1"+"\n"+"0 2 1 6 2"+
                "\n"+"2 0 4 2 1"+"\n"+"1 2 4 3 2"+"\n"+
                "1 3 3 6 1"+"\n"+"4 0 6 3 1"+"\n"+
                "3 3 6 6 2");
    }
}
