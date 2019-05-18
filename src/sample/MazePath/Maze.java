package sample.MazePath;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Maze {
    private String filename = "src/sample/MazePath/maze_101_101.txt";
    private int blockside = 8;
    private String amethod = "DFS";
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/MazePath/maze.fxml"));
        primaryStage.setTitle("迷宫寻路");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void sizesmall(){
        filename = "src/sample/MazePath/maze_30_30.txt";
        blockside = 20;
    }
    public void sizemid(){
        filename = "src/sample/MazePath/maze_50_101.txt";
        blockside = 12;
    }
    public void sizelarge(){
        filename = "src/sample/MazePath/maze_101_101.txt";
        blockside = 8;
    }

    public void deepsearch(){
        amethod = "DFS";
    }
    public void boardsearch(){
        amethod = "BFS";
    }

    public void clickok(){
        if(amethod == "DFS"){
            sample.MazeDFS.AlgoVisualizer vis = new sample.MazeDFS.AlgoVisualizer(filename,blockside);
        }
        else if(amethod == "BFS"){
            sample.MazeBFS.AlgoVisualizer vis = new sample.MazeBFS.AlgoVisualizer(filename,blockside);
        }
    }
}
