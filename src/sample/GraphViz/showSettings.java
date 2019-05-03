package sample.GraphViz;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class showSettings{

    public void show(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/GraphViz/settings.fxml"));
        primaryStage.setTitle("设置树结构的可视化节点属性");
        primaryStage.setScene(new Scene(root, 560, 450));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
