package sample.inputTree;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Searchtree extends Application {
    @FXML
    private TextField tf;
    @FXML
    private TextArea btreeta;

    //单例模式
    public static volatile Searchtree instance;
    public Searchtree(){}
    public static Searchtree getInstance(){
        if(instance == null){
            synchronized(Searchtree.class){
                if(instance == null){
                    instance = new Searchtree();
                }
            }
        }
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("searchtree.fxml"));
        primaryStage.setTitle("请输入数据");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void viewclick(){
        tf.setText("ABCDE#FGH#I##JK");
    }

    public void preclicked(){

    }

    public void inclicked(){

    }

    public void postclicked(){

    }
}
