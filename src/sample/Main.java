package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/JavaFXUI/mainUI.fxml"));
        primaryStage.setTitle("可视化");
        primaryStage.setScene(new Scene(root, 600, 430));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
