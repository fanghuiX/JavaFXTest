package sample.inputTree;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.GraphViz.CreateGraph;
import sample.JavaFXUI.MainUI;
import sample.JavaFXUI.showImage;

public class Inputbtree{
    @FXML
    private TextArea btreeta;
    @FXML
    private Button btreeb,vieweg,dynview;
    @FXML
    private TextField tf;
    //单例模式
    public static volatile Inputbtree itstance;
    public Inputbtree(){}
    public static Inputbtree getInstance(){
        if(itstance == null){
            synchronized(Inputbtree.class){
                if(itstance == null){
                    itstance = new Inputbtree();
                }
            }
        }
        return itstance;
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/inputTree/inputbtree.fxml"));
        primaryStage.setTitle("请输入数据");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    //静态可视化
    public void btreeclick(){
        //System.out.println("btree:"+new MainUI().index);
        int index = new MainUI().index;
        if(index == 1){
            System.out.println("处理树");
            CreateGraph cg = new CreateGraph();
            cg.choice(1,btreeta.getText());
            cg.start(CreateGraph.nodes,CreateGraph.bt);
        }
        else if(index == 2){
            System.out.println("处理二叉树");
            CreateGraph cg = new CreateGraph();
            cg.choice(2,btreeta.getText());
            cg.start(CreateGraph.nodes,CreateGraph.bt);
        }
        else if(index == 4){
            System.out.println("处理森林");
            CreateGraph cg = new CreateGraph();
            cg.choice(4,btreeta.getText());
            cg.start(CreateGraph.nodes,CreateGraph.bt);
        }
        try{
            showImage si = new showImage();
            si.start(new Stage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        /*Stage stage = (Stage)btreeb.getScene().getWindow();
        stage.hide();*/
    }

    public void viewclick(){
        int index = new MainUI().index;
        if(index == 1){
            tf.setText("A(B(E(K,L),F),C(G),D(H,I(M,N),J))");
        }
        else if(index == 2){
            tf.setText("ABCDE#FGH#I##JK");
        }
        else if(index == 4){
            tf.setText("A(B(D,E),C);F(G,H(I,J));K(L,M(O,P,Q),N)");
        }
    }
}
