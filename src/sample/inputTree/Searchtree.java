package sample.inputTree;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.GraphViz.CreateGraph;
import sample.JavaFXUI.showImage;

public class Searchtree{
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

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/inputTree/searchtree.fxml"));
        primaryStage.setTitle("请输入数据");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void viewclick(){
        tf.setText("ABCDE#FGH#I##JK");
    }

    public void preclicked(){
        System.out.println("处理线索二叉树-前序");
        CreateGraph cg = new CreateGraph();
        cg.getstr(btreeta.getText(),"pre");
        cg.start2(CreateGraph.nodes,CreateGraph.bt,CreateGraph.pre,CreateGraph.post);
        try{
            showImage si = new showImage();
            si.start(new Stage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void inclicked(){
        System.out.println("处理线索二叉树-中序");
        CreateGraph cg = new CreateGraph();
        cg.getstr(btreeta.getText(),"in");
        cg.start2(CreateGraph.nodes,CreateGraph.bt,CreateGraph.pre,CreateGraph.post);
        try{
            showImage si = new showImage();
            si.start(new Stage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void postclicked(){
        System.out.println("处理线索二叉树-后序");
        CreateGraph cg = new CreateGraph();
        cg.getstr(btreeta.getText(),"post");
        cg.start2(CreateGraph.nodes,CreateGraph.bt,CreateGraph.pre,CreateGraph.post);
        try{
            showImage si = new showImage();
            si.start(new Stage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
