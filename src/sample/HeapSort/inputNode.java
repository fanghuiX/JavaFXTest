package sample.HeapSort;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class inputNode{
    @FXML
    private TextField tf;
    @FXML
    private Button random;
    @FXML
    private Button confirm;
    @FXML
    private ToggleGroup heap;

    private boolean updown = true;
    //单例模式
    public static volatile inputNode instance;
    public inputNode(){}
    public static inputNode getInstance(){
        if(instance == null){
            synchronized(inputNode.class){
                if(instance == null){
                    instance = new inputNode();
                }
            }
        }
        return instance;
    }

    public void startnode(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/HeapSort/heapsort.fxml"));
        primaryStage.setTitle("请输入数据");
        primaryStage.setScene(new Scene(root, 500, 160));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void clickrand() {
        int[] num = new int[15];
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<num.length-1;i++){
            num[i] = (int) (Math.random() * 100)+1;
            sb.append(num[i]+",");
        }
        num[num.length-1] = (int) (Math.random() * 200)+1;
        sb.append(num[num.length-1]);
        tf.setText(sb.toString());
    }

    public void big(){
        updown = false;
    }
    public void small(){
        updown = true;
    }

    public void clickok() {
        String str = tf.getText();
        String s[] = str.split(",");
        int[] num = new int[s.length];
        for(int i=0;i<s.length;i++){
            num[i] = Integer.parseInt(s[i]);
        }
        newThread nt = new newThread();
        nt.num = num;
        nt.flag = updown;
        newThread.running = true;
        nt.start();
        //newThread.running = false;
    }
}
